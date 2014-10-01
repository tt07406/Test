/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsInfoHibernateDAO
 * 
 * 创建日期：2014-10-01
 */
package org.mystock.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.mystock.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 表格信息DAO
 * @author tt
 * @version 14.9.16
 */
public class TableHibernateDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(TableHibernateDAO.class);
	
	/**
	 * 添加表格
	 * @param table
	 * @return 操作是否成功
	 */
	@SuppressWarnings("finally")
	public long addTable(Table table){
		long result = -1;
		try {
			Integer id = (Integer)getHibernateTemplate().save(table);//返回新闻ID
			log.debug("save successful");
			log.info(id.toString());
			result = (long)id.intValue();
		} catch (RuntimeException e) {
			log.error("save failed", e);
			throw e;
		}finally{
			return result;
		}
	}
	
	/**
	 * 批量删除
	 * @param tableIds
	 * @return 是否成功
	 */
	public boolean deleteTable(int[] tableIds) {
		boolean result = true;
		for (int i = 0; i < tableIds.length; i++) {
			try {
				getHibernateTemplate().delete(searchTable(tableIds[i]));
				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				result = false;
				throw re;
			}
		}
		return result;
	}
	
	/**
	 * 通过Id查询表格内容
	 * @param tableId
	 * @return 表格
	 */
	public Table searchTable(int tableId) {
		return (Table)getHibernateTemplate().get(Table.class, tableId); 
	}
	
	/**
	 * 修改表格信息
	 * @param table
	 * @return 表格
	 */
	@SuppressWarnings("finally")
	public Table updateTable(Table table) {
		try{
			getHibernateTemplate().update(table);
			log.debug("update successful");
		}catch (RuntimeException e) {
			log.error("update failed", e);
			table = null;
			throw e;
		}finally{
			return table;
		}
	}
	
	/**
	 * 查询所有的表格信息
	 * @return 表格集合
	 */
     @SuppressWarnings("unchecked")
	public List<Table> getAllTable(){
    	 try {
   			String queryString = "from tables order by tableId desc";
   			return (List<Table>)getHibernateTemplate().find(queryString);
   		} catch (RuntimeException re) {
   			log.error("find all failed", re);
   			throw re;
   		}
     }
     
     /**
      * 模糊查询表格，只要表格标题、内容、摘要有一个匹配上即可
      * @param keyword
      * @return 表格集合
      */
     @SuppressWarnings("unchecked")
	public List<Table> getAllTable(String keyword){
    	 try {
			String queryString = "from tables where tableName like  ?"
					+ " or tableAbstract like  ?"
					+ " or tableContent like  ?"
					+ " order by tableId desc"; // 模糊匹配
   			return (List<Table>)getHibernateTemplate().find(queryString, '%' + keyword + '%',  
   					'%' + keyword + '%', '%' + keyword + '%');
   		} catch (RuntimeException re) {
   			log.error("getAllTable failed", re);
   			throw re;
   		}
     }
     
     /**
      * 模糊查询表格，只要表格标题、内容、摘要有一个匹配上即可
      * @param keyword 关键字
      * @param currentPage 当前页
      * @param lineSize 每页大小
      * @return 表格集合
      */
     @SuppressWarnings("unchecked")
	public List<Table> getAllTable(final String keyword, final int currentPage, final int lineSize){
		final String hql = "from tables where tableName like  ?"
							+ " or tableAbstract like  ?"
							+ " or tableContent like  ?"
							+ " order by tableId desc"; // 模糊匹配
		List<Table> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// 实现HibernateCallback接口必须实现的方法
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// 执行Hibernate分页查询
						List<Table> result = session.createQuery(hql)
								// 为hql语句传入参数
								.setParameter(0, '%' + keyword + '%')
								.setParameter(1, '%' + keyword + '%')
								.setParameter(2, '%' + keyword + '%')
								.setFirstResult((currentPage - 1) * lineSize)
								.setMaxResults(lineSize).list();
						return result;
					}
				});
		return list;
     }
       
       /**
        * 获取查询结果的数量
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword){
    	   return (Long)getHibernateTemplate().find("select count(tableId) from tables" +
    	   		 " where tableName like ?" +
	 		     " or tableAbstract like ?" +
	 		     " or tableContent like ?" +
	 		     " order by tableId desc",'%' + keyword + '%', 
	 		    '%' + keyword + '%','%' + keyword + '%').get(0);
       }
       
       
}
