/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsAttachmentHibernateDAO
 * 
 * 创建日期：2014-09-12
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
 * 新闻附件的DAO
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsAttachmentHibernateDAO extends HibernateDaoSupport {
	
	private static final Logger log = LoggerFactory.getLogger(NewsAttachmentHibernateDAO.class);

	/**
	 * 添加附件
	 * @param newsAttachment
	 * @return 操作是否成功
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
	 * 删除附件
	 * @param newsAttachment
	 * @return 是否成功
	 */
	@SuppressWarnings("finally")
	public boolean deleteNewsAttachment(NewsAttachment newsAttachment) {
		boolean result = false;
		try {
			NewsAttachment attachment = getHibernateTemplate().merge(newsAttachment);
			getHibernateTemplate().delete(attachment);
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
	 * 删除附件
	 * @param newsId
	 * @return 是否成功
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
	 * 修改附件信息
	 * @param newsAttachment
	 * @return 频道
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
	 * 查询所有的附件
	 * @return 附件集合
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
   	  * 模糊查询软件
   	  * @param keyword 关键字
      * @param currentPage 当前页
      * @param lineSize 每页大小
      * @return 软件集合
      */
    @SuppressWarnings("unchecked")
	public List<NewsAttachment> getAllSoftwares(final String keyword, final int currentPage, final int lineSize){
    	//通过一个HibernateCallback对象来执行查询
    	final String hql = "from news_attachment where news_id=0 and attachment_name like ? " +
    			"order by attachment_id";
    	  List<NewsAttachment> list = getHibernateTemplate()
  			.executeFind(new HibernateCallback()
  		{
  			//实现HibernateCallback接口必须实现的方法
  			public Object doInHibernate(Session session)
  				throws HibernateException, SQLException
  			{
  				//执行Hibernate分页查询
  				List<NewsAttachment> result = session.createQuery(hql)
  					//为hql语句传入参数
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
     * 查询含有关键字的软件数量
     * @param keyword
     * @return 软件数量
     */
    public long getCount(String keyword){
    	return (Long)getHibernateTemplate().find("select count(Attachment_id) " +
    	  		"from news_attachment where news_id=0 and attachment_name like ?",'%' + keyword + '%').get(0);
    }
    
    /**
     * 可通过Id来查找附件的信息
     * @param attachmentId
     * @return
     */
    public NewsAttachment findNewsAttachmentById(long attachmentId){
    	return (NewsAttachment)getHibernateTemplate().get(NewsAttachment.class, attachmentId); 
    }
    
    /**
     * 可通过NewsId来查找附件的信息
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
