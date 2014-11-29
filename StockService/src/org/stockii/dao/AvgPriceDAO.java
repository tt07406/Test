package org.stockii.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.stockii.domain.AvgPricePO;

/**
 * ���۴���DAO
 * @author tt
 *
 */
public class AvgPriceDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(AvgPriceDAO.class);
	
	/**
	 * �ҳ�һ��ʱ��������й�Ʊ���۵�ƽ��ֵ
	 * @param startDate ��ʼʱ��
	 * @param endDate ����ʱ��
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<AvgPricePO> findAvgPriceByDate(final Date startDate,final Date endDate){
		try {
   			final String queryString = "select new org.stockii.domain.AvgPricePO(s.stock_id,avg(s.avg_price)) from stock_day_info as s " +
   					"where s.created between ? and ? group by s.stock_id";
   			List<AvgPricePO> list = getHibernateTemplate().executeFind(
   					new HibernateCallback() {
   						// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
   						public Object doInHibernate(Session session)
   								throws HibernateException, SQLException {
   							// ִ��Hibernate��ҳ��ѯ
   							List<AvgPricePO> result = session.createQuery(queryString)
   									// Ϊhql��䴫�����
   									.setDate(0, startDate)
   									.setDate(1, endDate).list();

   							return result;
   						}
   					});
   			return list;
   		} catch (RuntimeException re) {
   			log.error("findAvgPriceByDate failed", re);
   			throw re;
   		}

	}
	
	/**
	 * ͨ�������ҳ�����
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,BigDecimal> findAvgPriceByDate(final Date date){
		try {
   			final String queryString = "select new map(s.stock_id,s.avg_price) from stock_day_info as s where s.created between ? and ?";
   			Map<String,BigDecimal> result = new HashMap<String,BigDecimal>();
   			List<Map> list = getHibernateTemplate().executeFind(
   					new HibernateCallback() {
   						// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
   						public Object doInHibernate(Session session)
   								throws HibernateException, SQLException {
   							// ִ��Hibernate��ҳ��ѯ
   							List<Map> result = session.createQuery(queryString)
   									// Ϊhql��䴫�����
   									.setDate(0, date)
   									.setDate(1, date).list();
   							return result;
   						}
   					});
   			for (Map map : list){
				result.put((String)map.get("0"), (BigDecimal)map.get("1"));
			}
			return result;
   		} catch (RuntimeException re) {
   			log.error("findAvgPriceByDate failed", re);
   			throw re;
   		}
	}
	
	/**
	 * �����������
	 * @param data
	 * @return
	 */
	public boolean saveAvgPrice(List<AvgPricePO> data){
		boolean result = true;

		try{
			for (int i = 0; i< data.size(); ++i){
				getHibernateTemplate().save(data.get(i));
				
				// ������Ķ�������д�����ݿⲢ�ͷ��ڴ�
   				if (i % 10 == 0) {
   					getHibernateTemplate().flush();
   					getHibernateTemplate().clear();
   				}
			}
		} catch (RuntimeException re) {
			log.error("saveAvgPrice failed", re);
			result = false;
			throw re;
		}

		return result;
	}
	
	
	/**
	 * ������ݿ�
	 */
	@SuppressWarnings("unchecked")
	public void clearData(){
		try{
		getHibernateTemplate().executeFind(
					new HibernateCallback() {
						// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {

							session.createSQLQuery("truncate table stock_avg_price").executeUpdate();
							return null;
						}
					});
		} catch (RuntimeException re) {
   			log.error("clearData failed", re);
   			throw re;
   		}
	}
	
	/**
	 * ��ȡĳһ���͵ľ��۱�
	 * @param currentPage 1��ʾA,2��ʾB,3��ʾC
	 * @param lineSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AvgPricePO> findAvgPriceByType(final int currentPage, final int lineSize){
		try {
   			final String queryString = "from stock_avg_price";
   			List<AvgPricePO> list = getHibernateTemplate().executeFind(
   					new HibernateCallback() {
   						// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
						public Object doInHibernate(Session session)
   								throws HibernateException, SQLException {
   							// ִ��Hibernate��ҳ��ѯ
   							List<AvgPricePO> result = session.createQuery(queryString)
   									// Ϊhql��䴫�����
   									.setFirstResult((currentPage - 1) * lineSize)
   									.setMaxResults(lineSize).list();
   							return result;
   						}
   					});
   			return list;
   		} catch (RuntimeException re) {
   			log.error("findAvgPriceByType failed", re);
   			throw re;
   		}
	}
	
	/**
	 * �ҳ����о��۱�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AvgPricePO> findAllAvgPrice(){
		try{
			String queryString = "from stock_avg_price as b";
			return (List<AvgPricePO>)getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
   			log.error("findAllAvgPrice failed", re);
   			throw re;
   		}

	}
}
