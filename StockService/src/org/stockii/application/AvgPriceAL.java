
package org.stockii.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stockii.bean.AvgPrice;
import org.stockii.bean.Stock;
import org.stockii.common.Common;
import org.stockii.common.FixSizedPriorityQueue;
import org.stockii.dao.AvgPriceDAO;
import org.stockii.dao.StockBasicInfoDAO;
import org.stockii.domain.AvgPricePO;
import org.stockii.domain.StockBasicInfo;

/**
 * 均价处理应用逻辑
 * @author tt
 *
 */
public class AvgPriceAL {
	private static final Logger log = LoggerFactory.getLogger(AvgPriceAL.class);
	
	public static int HEAPSIZE = 100;
	private StockBasicInfoDAO stockBasicInfoDAO;
	private AvgPriceDAO avgPriceDAO;
	/**
	 * @param stockBasicInfoDAO the stockBasicInfoDAO to set
	 */
	public void setStockBasicInfoDAO(StockBasicInfoDAO stockBasicInfoDAO) {
		this.stockBasicInfoDAO = stockBasicInfoDAO;
	}
	/**
	 * @param avgPriceDAO the avgPriceDAO to set
	 */
	public void setAvgPriceDAO(AvgPriceDAO avgPriceDAO) {
		this.avgPriceDAO = avgPriceDAO;
	}
	
	/**
	 * 求出一段时间的股票平均值对应表
	 * @param startDate 起始日期
	 * @param endDate 截止日期
	 * @return 是否生成表格成功
	 */
	public boolean selectStocks(Date startDate,Date endDate){
		List<AvgPricePO> avgPriceList = avgPriceDAO.findAvgPriceByDate(startDate, endDate);//求出所有股票的平均值
		Map<String,String> stockMap = stockBasicInfoDAO.findAllStockName();//求出股票代码对应名称
		Map<String,BigDecimal> startMap = avgPriceDAO.findAvgPriceByDate(startDate);
		Map<String,BigDecimal> endMap = avgPriceDAO.findAvgPriceByDate(endDate);
		int i = 0;
		
		for (AvgPricePO po:avgPriceList){
			++i;
			po.setStart_date(startDate);
			po.setEnd_date(endDate);
			po.setStock_name(stockMap.get(po.getStock_id()));//补充股票名称
			po.setStart_price(startMap.get(po.getStock_id()));//补充起始价
			po.setEnd_price(endMap.get(po.getStock_id()));//补充终止价
			po.setSection_num(Common.getSectionNum(po.getAvg_value(), po.getStart_price(), po.getEnd_price()));
		}
		
		for (Iterator<AvgPricePO> it = avgPriceList.iterator(); it.hasNext();){
			AvgPricePO po = (AvgPricePO)it.next();
			if (po.getStart_price() == null || po.getEnd_price() == null || po.getAvg_value() == null){
				it.remove();
			}
		}
		
		log.info("avgPriceList length:"+avgPriceList.size());
		
		return calculateAndSaveABC(avgPriceList);//计算A\B\C并保存到数据表中
	}
	
	/**
	 * 获取所有股票基本信息
	 * @return
	 */
	public List<Stock> findAllStock(){
		List<Stock> result = new ArrayList<Stock>();
		for (StockBasicInfo info:stockBasicInfoDAO.findAllStock()){
			result.add(new Stock(info.getStock_id(),info.getStock_name(),info.getList_date()));
		}
		return result;
	}
	
	/**
	 * 由股票平均值对应表求出a（向上跨区一百名）,b（向下跨区一百名）,c（不跨区一百名），并保存到数据库里
	 * @param avgPriceList
	 * @return 是否成功
	 */
	public boolean calculateAndSaveABC(List<AvgPricePO> avgPriceList){
		avgPriceDAO.clearData();//清空原数据表数据
		
		List<AvgPrice> data = poToVO(avgPriceList);
		
		FixSizedPriorityQueue<AvgPrice> AStack = new FixSizedPriorityQueue<AvgPrice>(HEAPSIZE,true);//用优先级队列建立最小堆
		FixSizedPriorityQueue<AvgPrice> BStack = new FixSizedPriorityQueue<AvgPrice>(HEAPSIZE,false);//用优先级队列建立最大堆
		FixSizedPriorityQueue<AvgPrice> CStack = new FixSizedPriorityQueue<AvgPrice>(HEAPSIZE,false);//用优先级队列建立最大堆
		
		for (AvgPrice po:data){
			if (po.getSection_num()>=0){
				AStack.put(po);//最大的100个
				CStack.put(po);//最小的100个
			}else{
				BStack.put(po);//绝对值由大到小的100个
			}
		}

		//批量保存到数据表中
		boolean saveA = avgPriceDAO.saveAvgPrice(voToPO(AStack.sort()));
		boolean saveB = avgPriceDAO.saveAvgPrice(voToPO(BStack.sort()));
		boolean saveC = avgPriceDAO.saveAvgPrice(voToPO(CStack.sort()));
		
		return saveA&&saveB&&saveC;
		
	}
	
	/**
	 * 数据格式转换PO到VO
	 * @param list
	 * @return
	 */
	public List<AvgPrice> poToVO(List<AvgPricePO> list){
		List<AvgPrice> result = new ArrayList<AvgPrice>();
		if (list != null){
			for (AvgPricePO po:list){
				AvgPrice item = new AvgPrice();
				item.setStock_id(po.getStock_id());
				item.setStock_name(po.getStock_name());
				item.setAvg_value(po.getAvg_value());
				item.setEnd_date(po.getEnd_date());
				item.setEnd_price(po.getEnd_price());
				item.setSection_num(po.getSection_num());
				item.setStart_date(po.getStart_date());
				item.setStart_price(po.getStart_price());
				result.add(item);
			}
		}
		return result;
	}
	
	/**
	 * 数据格式转换VO到PO
	 * @param list
	 * @return
	 */
	public List<AvgPricePO> voToPO(List<AvgPrice> list){
		List<AvgPricePO> result = new ArrayList<AvgPricePO>();
		if (list != null){
			for (AvgPrice vo:list){
				AvgPricePO item = new AvgPricePO();
				item.setStock_id(vo.getStock_id());
				item.setStock_name(vo.getStock_name());
				item.setAvg_value(vo.getAvg_value());
				item.setEnd_date(vo.getEnd_date());
				item.setEnd_price(vo.getEnd_price());
				item.setSection_num(vo.getSection_num());
				item.setStart_date(vo.getStart_date());
				item.setStart_price(vo.getStart_price());
				result.add(item);
			}
		}
		return result;
	}
	
	/**
	 * 返回A类均价表
	 * @return
	 */
	public List<AvgPrice> findA(){
		return poToVO(avgPriceDAO.findAvgPriceByType(1, HEAPSIZE));
	}
	
	/**
	 * 返回B类均价表
	 * @return
	 */
	public List<AvgPrice> findB(){
		return poToVO(avgPriceDAO.findAvgPriceByType(2, HEAPSIZE));
	}
	
	/**
	 * 返回C类均价表
	 * @return
	 */
	public List<AvgPrice> findC(){
		return poToVO(avgPriceDAO.findAvgPriceByType(3, HEAPSIZE));
	}
	
	/**
	 * 找出所有均价表
	 * @return
	 */
	public List<AvgPricePO> findAllAvgPrice(){
		return avgPriceDAO.findAllAvgPrice();
	}
}
