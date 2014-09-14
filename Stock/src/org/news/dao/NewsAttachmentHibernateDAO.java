/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsAttachmentHibernateDAO
 * 
 * �������ڣ�2014-09-12
 */
package org.news.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.news.model.NewsAttachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ���Ÿ�����DAO
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsAttachmentHibernateDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(NewsAttachmentHibernateDAO.class);

	/**
	 * ��Ӹ���
	 * @param newsAttachment
	 * @return �����Ƿ�ɹ�
	 */
	@SuppressWarnings("finally")
	public boolean addNewsAttachment(NewsAttachment newsAttachment){
		boolean result = false;
		try {	
			getHibernateTemplate().save(newsAttachment);
			log.debug("save successful");
			result = true;
		} catch (RuntimeException e) {
			log.error("save failed", e);
			throw e;
		}finally{
			return result;
		}
	}
	
	/**
	 * ɾ������
	 * @param newsAttachment
	 * @return �Ƿ�ɹ�
	 */
	@SuppressWarnings("finally")
	public boolean deleteNewsAttachment(NewsAttachment newsAttachment) {
		boolean result = false;
		try {
			getHibernateTemplate().delete(newsAttachment);
			log.debug("delete successful");
			result = true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}finally{
			return result;
		}
	}
	
	/**
	 * ɾ������
	 * @param newsId
	 * @return �Ƿ�ɹ�
	 */
	@SuppressWarnings("unchecked")
	public boolean deleteNewsAttachmentByNewsId(final long newsId) {
		boolean result = false;
		result = getHibernateTemplate().execute(new HibernateCallback() {
		      @SuppressWarnings("finally")
			public Object doInHibernate(Session session) throws SQLException,
		          HibernateException {
		    	boolean result = false;  
		        Query query = session.createQuery(
		            "delete from  news_attachment where news_id = ? ");
		        query.setInteger(0, (int)newsId);
		        try{
		        	query.executeUpdate();
		        	result = true;
		        }catch(Exception e){
		        	throw new RuntimeException();
		        }finally{
		        	return result;
		        }		        
		       }
		    });
		return result;
	}
	
	/**
	 * �޸ĸ�����Ϣ
	 * @param newsAttachment
	 * @return Ƶ��
	 */
	@SuppressWarnings("finally")
	public NewsAttachment updateNewsAttachment(NewsAttachment newsAttachment) {
		try{
			getHibernateTemplate().update(newsAttachment);
			log.debug("update successful");
		}catch (RuntimeException e) {
			log.error("update failed", e);
			newsAttachment = null;
			throw e;
		}finally{
			return newsAttachment;
		}
	}
	
	/**
	 * ��ѯ���еĸ���
	 * @return ��������
	 */
     @SuppressWarnings("unchecked")
	public List<NewsAttachment> getAllNewsAttachment(){
    	 try {
  			String queryString = "from news_attachment order by attachment_id";
  			return (List<NewsAttachment>)getHibernateTemplate().find(queryString);
  		} catch (RuntimeException re) {
  			log.error("find all failed", re);
  			throw re;
  		}
     }
     
     /**
   	  * ģ����ѯ���
   	  * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return �������
      */
    @SuppressWarnings("unchecked")
	public List<NewsAttachment> getAllSoftwares(final String keyword, final int currentPage, final int lineSize){
    	//ͨ��һ��HibernateCallback������ִ�в�ѯ
    	final String hql = "from news_attachment where news_id=0 and attachment_name like ? " +
    			"order by attachment_id";
    	  List<NewsAttachment> list = getHibernateTemplate()
  			.executeFind(new HibernateCallback()
  		{
  			//ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
  			public Object doInHibernate(Session session)
  				throws HibernateException, SQLException
  			{
  				//ִ��Hibernate��ҳ��ѯ
  				List<NewsAttachment> result = session.createQuery(hql)
  					//Ϊhql��䴫�����
  					.setParameter(0, '%' + keyword + '%') 
  					.setFirstResult((currentPage - 1) * lineSize)
  					.setMaxResults(lineSize)
  					.list();
  				return result;
  			}
  		});
  		return list;
      }
    
    /**
     * ��ѯ���йؼ��ֵ��������
     * @param keyword
     * @return �������
     */
    public long getCount(String keyword){
    	return (Long)getHibernateTemplate().find("select count(Attachment_id) " +
    	  		"from news_attachment where news_id=0 and attachment_name like ?",'%' + keyword + '%').get(0);
    }
    
    /**
     * ��ͨ��Id�����Ҹ�������Ϣ
     * @param attachmentId
     * @return
     */
    public NewsAttachment findNewsAttachmentById(long attachmentId){
    	return (NewsAttachment)getHibernateTemplate().get(NewsAttachment.class, attachmentId); 
    }
    
    /**
     * ��ͨ��NewsId�����Ҹ�������Ϣ
     * @param newsId
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<NewsAttachment> findNewsAttachmentByNewsId(long newsId){
    	
    	try {
  			String queryString = "from news_attachment where news_id = ?";
  			return (List<NewsAttachment>)getHibernateTemplate().find(queryString, newsId);
  		} catch (RuntimeException re) {
  			log.error("find all failed", re);
  			throw re;
  		}
    }
}
