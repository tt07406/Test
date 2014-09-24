/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInfoHibernateDAO
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.mystock.model.NewsInfo;
import org.mystock.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ������ϢDAO
 * @author tt
 * @version 14.9.16
 */
public class NewsInfoHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(NewsInfoHibernateDAO.class);
	
	/**
	 * �������
	 * @param newsInfo
	 * @return �����Ƿ�ɹ�
	 */
	@SuppressWarnings("finally")
	public long addNewsInfo(NewsInfo newsInfo){
		long result = -1;
		try {
			Integer id = (Integer)getHibernateTemplate().save(newsInfo);//��������ID
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
	 * @param newsInfoIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds) {
		boolean result = true;
		for (int i = 0; i < newsInfoIds.length; i++) {
			try {
				getHibernateTemplate().delete(searchNewsInfo(newsInfoIds[i]));
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
	 * ͨ������Id��ѯ��������
	 * @param newsInfoId
	 * @return ��������
	 */
	public NewsInfo searchNewsInfo(int newsInfoId) {
		return (NewsInfo)getHibernateTemplate().get(NewsInfo.class, newsInfoId); 
	}
	
	/**
	 * �޸�������Ϣ
	 * @param newsInfo
	 * @return ��������
	 */
	@SuppressWarnings("finally")
	public NewsInfo updateNewsInformation(NewsInfo newsInfo) {
		try{
			getHibernateTemplate().update(newsInfo);
			log.debug("update successful");
		}catch (RuntimeException e) {
			log.error("update failed", e);
			newsInfo = null;
			throw e;
		}finally{
			return newsInfo;
		}
	}
	
	/**
	 * ��ѯ���е�������Ϣ
	 * @return ���ż���
	 */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(){
    	 try {
   			String queryString = "from newsinfo order by newsInfoId desc";
   			return (List<NewsInfo>)getHibernateTemplate().find(queryString);
   		} catch (RuntimeException re) {
   			log.error("find all failed", re);
   			throw re;
   		}
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword
      * @return ���ż���
      */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(String keyword){
    	 try {
			String queryString = "from newsinfo where newsInfoTitle like  ?"
					+ " or newsInfoContent like  ?"
					+ " or newsInfoTime like  ?"
					+ " or newsType like  ?"
					+ " or newsAuthor like  ? order by newsInfoId desc"; // ģ��ƥ��
   			return (List<NewsInfo>)getHibernateTemplate().find(queryString, '%' + keyword + '%',  
   					'%' + keyword + '%', Common.getSwitchDate(keyword), '%' + keyword + '%', '%' + keyword + '%');
   		} catch (RuntimeException re) {
   			log.error("getAllNewsInfo failed", re);
   			throw re;
   		}
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return ���ż���
      */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(final String keyword, final int currentPage, final int lineSize){
		final String hql = "from newsinfo where newsInfoTitle like ?"
					+ " or newsInfoContent like ?"
					+ " or newsInfoTime like ?"
					+ " or newsType like ?"
					+ " or newsAuthor like ?  order by newsInfoId desc"; // ģ��ƥ��
		List<NewsInfo> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// ִ��Hibernate��ҳ��ѯ
						List<NewsInfo> result = session.createQuery(hql)
								// Ϊhql��䴫�����
								.setParameter(0, '%' + keyword + '%')
								.setParameter(1, '%' + keyword + '%')
								.setDate(2, Common.getSwitchDate(keyword))
								.setParameter(3, '%' + keyword + '%')
								.setParameter(4, '%' + keyword + '%')
								.setFirstResult((currentPage - 1) * lineSize)
								.setMaxResults(lineSize).list();
						return result;
					}
				});
		return list;
     }
     
     /**
  	 * �����������Ͳ�ѯ����ص�����
  	 * @return ���ż���
  	 */
       @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfoByType(String newsType){
    	   try {
     			String queryString = "from newsinfo where newsType=? order by newsInfoId desc";
     			return (List<NewsInfo>)getHibernateTemplate().find(queryString, newsType);
     		} catch (RuntimeException re) {
     			log.error("find all failed", re);
     			throw re;
     		}
       }
       
       /**
        * ��ȡ��ѯ���������
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword){
    	   return (Long)getHibernateTemplate().find("select count(newsInfoId) from newsinfo" +
    	   		 " where newsInfoTitle like ?" +
	 		     " or newsInfoContent like ?" +
	 		     " or newsInfoTime like ?" +
	 		     " or newsType like ?" +
	 		     " or newsAuthor like ? order by newsInfoId desc",'%' + keyword + '%', 
	 		    '%' + keyword + '%',Common.getSwitchDate(keyword), '%' + keyword + '%', '%' + keyword + '%').get(0);
       }
       
       
}
