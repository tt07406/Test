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
 * 均价处理DAO
 * @author tt
 *
 */
public class AvgPriceDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(AvgPriceDAO.class);
	
	/**
	 * 找出一个时间段内所有股票均价的平均值
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public List<AvgPricePO> findAvgPriceByDate(final Date startDate,final Date endDate){
		try {
   			final String queryString = "select new org.stockii.domain.AvgPricePO(s.stock_id,avg(s.avg_price)) from stock_day_info as s " +
   					"where s.created between ? and ? group by s.stock_id";
   			List<AvgPricePO> list = getHibernateTemplate().executeFind(
   					new HibernateCallback() {
   						// 实现HibernateCallback接口必须实现的方法
   						public Object doInHibernate(Session session)
   								throws HibernateException, SQLException {
   							// 执行Hibernate分页查询
   							List<AvgPricePO> result = session.createQuery(queryString)
   									// 为hql语句传入参数
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
	 * 通过日期找出均价
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
   						// 实现HibernateCallback接口必须实现的方法
   						public Object doInHibernate(Session session)
   								throws HibernateException, SQLException {
   							// 执行Hibernate分页查询
   							List<Map> result = session.createQuery(queryString)
   									// 为hql语句传入参数
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
	 * 批量保存入库
	 * @param data
	 * @return
	 */
	public boolean saveAvgPrice(List<AvgPricePO> data){
		boolean result = true;

		try{
			for (int i = 0; i< data.size(); ++i){
				getHibernateTemplate().save(data.get(i));
				
				// 批插入的对象立即写入数据库并释放内存
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
	 * 清空数据库
	 */
	@SuppressWarnings("unchecked")
	public void clearData(){
		try{
		getHibernateTemplate().executeFind(
					new HibernateCallback() {
						// 实现HibernateCallback接口必须实现的方法
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
	 * 获取某一类型的均价表
	 * @param currentPage 1表示A,2表示B,3表示C
	 * @param lineSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<AvgPricePO> findAvgPriceByType(final int currentPage, final int lineSize){
		try {
   			final String queryString = "from stock_avg_price";
   			List<AvgPricePO> list = getHibernateTemplate().executeFind(
   					new HibernateCallback() {
   						// 实现HibernateCallback接口必须实现的方法
						public Object doInHibernate(Session session)
   								throws HibernateException, SQLException {
   							// 执行Hibernate分页查询
   							List<AvgPricePO> result = session.createQuery(queryString)
   									// 为hql语句传入参数
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
	 * 找出所有均价表
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
