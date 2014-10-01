/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInfoHibernateDAO
 * 
 * �������ڣ�2014-10-01
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
 * �����ϢDAO
 * @author tt
 * @version 14.9.16
 */
public class TableHibernateDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(TableHibernateDAO.class);
	
	/**
	 * ��ӱ��
	 * @param table
	 * @return �����Ƿ�ɹ�
	 */
	@SuppressWarnings("finally")
	public long addTable(Table table){
		long result = -1;
		try {
			Integer id = (Integer)getHibernateTemplate().save(table);//��������ID
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
	 * ����ɾ��
	 * @param tableIds
	 * @return �Ƿ�ɹ�
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
	 * ͨ��Id��ѯ�������
	 * @param tableId
	 * @return ���
	 */
	public Table searchTable(int tableId) {
		return (Table)getHibernateTemplate().get(Table.class, tableId); 
	}
	
	/**
	 * �޸ı����Ϣ
	 * @param table
	 * @return ���
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
	 * ��ѯ���еı����Ϣ
	 * @return ��񼯺�
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
      * ģ����ѯ���ֻҪ�����⡢���ݡ�ժҪ��һ��ƥ���ϼ���
      * @param keyword
      * @return ��񼯺�
      */
     @SuppressWarnings("unchecked")
	public List<Table> getAllTable(String keyword){
    	 try {
			String queryString = "from tables where tableName like  ?"
					+ " or tableAbstract like  ?"
					+ " or tableContent like  ?"
					+ " order by tableId desc"; // ģ��ƥ��
   			return (List<Table>)getHibernateTemplate().find(queryString, '%' + keyword + '%',  
   					'%' + keyword + '%', '%' + keyword + '%');
   		} catch (RuntimeException re) {
   			log.error("getAllTable failed", re);
   			throw re;
   		}
     }
     
     /**
      * ģ����ѯ���ֻҪ�����⡢���ݡ�ժҪ��һ��ƥ���ϼ���
      * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return ��񼯺�
      */
     @SuppressWarnings("unchecked")
	public List<Table> getAllTable(final String keyword, final int currentPage, final int lineSize){
		final String hql = "from tables where tableName like  ?"
							+ " or tableAbstract like  ?"
							+ " or tableContent like  ?"
							+ " order by tableId desc"; // ģ��ƥ��
		List<Table> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// ִ��Hibernate��ҳ��ѯ
						List<Table> result = session.createQuery(hql)
								// Ϊhql��䴫�����
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
        * ��ȡ��ѯ���������
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
