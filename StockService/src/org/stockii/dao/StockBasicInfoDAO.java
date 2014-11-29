package org.stockii.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.stockii.domain.StockBasicInfo;

/**
 * 股票基本信息DAO
 * @author tt
 *
 */
public class StockBasicInfoDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(StockBasicInfoDAO.class);
	
	/**
	 * 找出股票代码和名称的对应关系
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> findAllStockName(){
		Map<String,String> result = new HashMap<String,String>();
		try{
			String queryString = "select new map(b.stock_id,b.stock_name) from stock_basic_info as b";
			List<Map> list = getHibernateTemplate().find(queryString);
			for (Map map : list){
				result.put((String)map.get("0"), (String)map.get("1"));
			}
			return result;
		} catch (RuntimeException re) {
   			log.error("findAllStockBasicInfo failed", re);
   			throw re;
   		}
	}
	
	/**
	 * 找出所有股票信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StockBasicInfo> findAllStock(){
		try{
			String queryString = "from stock_basic_info as b";
			return (List<StockBasicInfo>)getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
   			log.error("findAllStock failed", re);
   			throw re;
   		}

	}

}
