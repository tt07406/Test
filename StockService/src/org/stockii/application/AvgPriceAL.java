
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
 * ���۴���Ӧ���߼�
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
	 * ���һ��ʱ��Ĺ�Ʊƽ��ֵ��Ӧ��
	 * @param startDate ��ʼ����
	 * @param endDate ��ֹ����
	 * @return �Ƿ����ɱ��ɹ�
	 */
	public boolean selectStocks(Date startDate,Date endDate){
		List<AvgPricePO> avgPriceList = avgPriceDAO.findAvgPriceByDate(startDate, endDate);//������й�Ʊ��ƽ��ֵ
		Map<String,String> stockMap = stockBasicInfoDAO.findAllStockName();//�����Ʊ�����Ӧ����
		Map<String,BigDecimal> startMap = avgPriceDAO.findAvgPriceByDate(startDate);
		Map<String,BigDecimal> endMap = avgPriceDAO.findAvgPriceByDate(endDate);
		int i = 0;
		
		for (AvgPricePO po:avgPriceList){
			++i;
			po.setStart_date(startDate);
			po.setEnd_date(endDate);
			po.setStock_name(stockMap.get(po.getStock_id()));//�����Ʊ����
			po.setStart_price(startMap.get(po.getStock_id()));//������ʼ��
			po.setEnd_price(endMap.get(po.getStock_id()));//������ֹ��
			po.setSection_num(Common.getSectionNum(po.getAvg_value(), po.getStart_price(), po.getEnd_price()));
		}
		
		for (Iterator<AvgPricePO> it = avgPriceList.iterator(); it.hasNext();){
			AvgPricePO po = (AvgPricePO)it.next();
			if (po.getStart_price() == null || po.getEnd_price() == null || po.getAvg_value() == null){
				it.remove();
			}
		}
		
		log.info("avgPriceList length:"+avgPriceList.size());
		
		return calculateAndSaveABC(avgPriceList);//����A\B\C�����浽���ݱ���
	}
	
	/**
	 * ��ȡ���й�Ʊ������Ϣ
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
	 * �ɹ�Ʊƽ��ֵ��Ӧ�����a�����Ͽ���һ������,b�����¿���һ������,c��������һ�������������浽���ݿ���
	 * @param avgPriceList
	 * @return �Ƿ�ɹ�
	 */
	public boolean calculateAndSaveABC(List<AvgPricePO> avgPriceList){
		avgPriceDAO.clearData();//���ԭ���ݱ�����
		
		List<AvgPrice> data = poToVO(avgPriceList);
		
		FixSizedPriorityQueue<AvgPrice> AStack = new FixSizedPriorityQueue<AvgPrice>(HEAPSIZE,true);//�����ȼ����н�����С��
		FixSizedPriorityQueue<AvgPrice> BStack = new FixSizedPriorityQueue<AvgPrice>(HEAPSIZE,false);//�����ȼ����н�������
		FixSizedPriorityQueue<AvgPrice> CStack = new FixSizedPriorityQueue<AvgPrice>(HEAPSIZE,false);//�����ȼ����н�������
		
		for (AvgPrice po:data){
			if (po.getSection_num()>=0){
				AStack.put(po);//����100��
				CStack.put(po);//��С��100��
			}else{
				BStack.put(po);//����ֵ�ɴ�С��100��
			}
		}

		//�������浽���ݱ���
		boolean saveA = avgPriceDAO.saveAvgPrice(voToPO(AStack.sort()));
		boolean saveB = avgPriceDAO.saveAvgPrice(voToPO(BStack.sort()));
		boolean saveC = avgPriceDAO.saveAvgPrice(voToPO(CStack.sort()));
		
		return saveA&&saveB&&saveC;
		
	}
	
	/**
	 * ���ݸ�ʽת��PO��VO
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
	 * ���ݸ�ʽת��VO��PO
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
	 * ����A����۱�
	 * @return
	 */
	public List<AvgPrice> findA(){
		return poToVO(avgPriceDAO.findAvgPriceByType(1, HEAPSIZE));
	}
	
	/**
	 * ����B����۱�
	 * @return
	 */
	public List<AvgPrice> findB(){
		return poToVO(avgPriceDAO.findAvgPriceByType(2, HEAPSIZE));
	}
	
	/**
	 * ����C����۱�
	 * @return
	 */
	public List<AvgPrice> findC(){
		return poToVO(avgPriceDAO.findAvgPriceByType(3, HEAPSIZE));
	}
	
	/**
	 * �ҳ����о��۱�
	 * @return
	 */
	public List<AvgPricePO> findAllAvgPrice(){
		return avgPriceDAO.findAllAvgPrice();
	}
}
