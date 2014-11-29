package org.stockii.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.stockii.domain.StockBasicInfo;

/**
 * ��Ʊ������ϢDAO
 * @author tt
 *
 */
public class StockBasicInfoDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(StockBasicInfoDAO.class);
	
	/**
	 * �ҳ���Ʊ��������ƵĶ�Ӧ��ϵ
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
	 * �ҳ����й�Ʊ��Ϣ
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
