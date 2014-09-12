/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsInfoHibernateDAO
 * 
 * �������ڣ�2014-09-12
 */
package org.news.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.news.model.NewsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ������ϢDAO
 * @author tt
 * @version 14.8.18
 */
public class NewsInfoHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(NewsAttachmentHibernateDAO.class);
	
	/**
	 * ��������
	 * @param newsInfo
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addNewsInfo(NewsInfo newsInfo){
		try {
			getHibernateTemplate().save(newsInfo);
			log.debug("save successful");
			return true;
		} catch (Exception e) {
			log.error("save failed", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * ����ɾ��
	 * @param newsInfoIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds) {
		for (int i = 0; i < newsInfoIds.length; i++) {
			try {
				getHibernateTemplate().delete(searchNewsInfo(newsInfoIds[i]));
				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				return false;
			}
		}
		return true;
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
	public NewsInfo updateNewsInformation(NewsInfo newsInfo) {
		try{
			getHibernateTemplate().update(newsInfo);
			log.debug("update successful");
			return newsInfo;
		}catch (Exception e) {
			log.error("update failed", e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ѯ���е�������Ϣ
	 * @return ���ż���
	 */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(){
    	 try {
   			String queryString = "from newsInfo order by newsInfoId desc";
   			return (List<NewsInfo>)getHibernateTemplate().find(queryString);
   		} catch (RuntimeException re) {
   			log.error("find all failed", re);
   			throw re;
   		}
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���������ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword
      * @return ���ż���
      */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(String keyword){
    	 try {
			String queryString = "from newsInfo where newsInfoTitle like binary ?"
					+ " or newsInfoDescribe like binary ? "
					+ " or newsInfoContent like binary ?"
					+ " or newsInfoTime like binary ?"
					+ " or newsType like binary ?"
					+ " or newsAuthor like binary ? order by newsInfoId desc"; // ģ��ƥ��
   			return (List<NewsInfo>)getHibernateTemplate().find(queryString, keyword, keyword, 
   					keyword, keyword, keyword, keyword);
   		} catch (RuntimeException re) {
   			log.error("getAllNewsInfo failed", re);
   			throw re;
   		}
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���������ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return ���ż���
      */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(final String keyword, final int currentPage, final int lineSize){
		final String hql = "from newsInfo where newsInfoTitle like ?"
					+ " or newsInfoDescribe like ? "
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
								.setParameter(2, '%' + keyword + '%')
								.setParameter(3, '%' + keyword + '%')
								.setParameter(4, '%' + keyword + '%')
								.setParameter(5, '%' + keyword + '%')
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
     			String queryString = "from newsInfo where newsType=? order by newsInfoId desc";
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
    	   return (Long)getHibernateTemplate().find("select count(newsInfoId) from newsInfo" +
    	   		 " where newsInfoTitle like binary ?" +
	 		     " or newsInfoDescribe like binary ? " +
	 		     " or newsInfoContent like binary ?" +
	 		     " or newsInfoTime like binary ?" +
	 		     " or newsType like binary ?" +
	 		     " or newsAuthor like binary ? order by newsInfoId desc",keyword, 
	 		     keyword, keyword, keyword, keyword, keyword).get(0);
       }
}