/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsInfoHibernateDAO
 * 
 * 创建日期：2014-09-24
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
 * 文章信息DAO
 * @author tt
 * @version 14.9.16
 */
public class NewsInfoHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(NewsInfoHibernateDAO.class);
	
	/**
	 * 添加新闻
	 * @param newsInfo
	 * @return 操作是否成功
	 */
	@SuppressWarnings("finally")
	public long addNewsInfo(NewsInfo newsInfo){
		long result = -1;
		try {
			Integer id = (Integer)getHibernateTemplate().save(newsInfo);//返回新闻ID
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
	 * @param newsInfoIds
	 * @return 是否成功
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
	 * 通过新闻Id查询文章内容
	 * @param newsInfoId
	 * @return 文章内容
	 */
	public NewsInfo searchNewsInfo(int newsInfoId) {
		return (NewsInfo)getHibernateTemplate().get(NewsInfo.class, newsInfoId); 
	}
	
	/**
	 * 修改文章信息
	 * @param newsInfo
	 * @return 文章内容
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
	 * 查询所有的新闻信息
	 * @return 新闻集合
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
      * 模糊查询新闻，只要文章标题、内容、时间和作者有一个匹配上即可
      * @param keyword
      * @return 新闻集合
      */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(String keyword){
    	 try {
			String queryString = "from newsinfo where newsInfoTitle like  ?"
					+ " or newsInfoContent like  ?"
					+ " or newsInfoTime like  ?"
					+ " or newsType like  ?"
					+ " or adminName like  ?"
					+ " or newsAuthor like  ? order by newsInfoId desc"; // 模糊匹配
   			return (List<NewsInfo>)getHibernateTemplate().find(queryString, '%' + keyword + '%',  
   					'%' + keyword + '%', Common.getSwitchDate(keyword), '%' + keyword + '%', 
   					'%' + keyword + '%', '%' + keyword + '%');
   		} catch (RuntimeException re) {
   			log.error("getAllNewsInfo failed", re);
   			throw re;
   		}
     }
     
     /**
      * 模糊查询新闻，只要文章标题、内容、时间和作者有一个匹配上即可
      * @param keyword 关键字
      * @param currentPage 当前页
      * @param lineSize 每页大小
      * @return 新闻集合
      */
     @SuppressWarnings("unchecked")
	public List<NewsInfo> getAllNewsInfo(final String keyword, final int currentPage, final int lineSize){
		final String hql = "from newsinfo where newsInfoTitle like ?"
					+ " or newsInfoContent like ?"
					+ " or newsInfoTime like ?"
					+ " or newsType like ?"
					+ " or adminName like  ?"
					+ " or newsAuthor like ?  order by newsInfoId desc"; // 模糊匹配
		List<NewsInfo> list = getHibernateTemplate().executeFind(
				new HibernateCallback() {
					// 实现HibernateCallback接口必须实现的方法
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						// 执行Hibernate分页查询
						List<NewsInfo> result = session.createQuery(hql)
								// 为hql语句传入参数
								.setParameter(0, '%' + keyword + '%')
								.setParameter(1, '%' + keyword + '%')
								.setDate(2, Common.getSwitchDate(keyword))
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
  	 * 根据文章类型查询的相关的新闻
  	 * @return 新闻集合
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
        * 获取查询结果的数量
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword){
    	   return (Long)getHibernateTemplate().find("select count(newsInfoId) from newsinfo" +
    	   		 " where newsInfoTitle like ?" +
	 		     " or newsInfoContent like ?" +
	 		     " or newsInfoTime like ?" +
	 		     " or newsType like ?" +
	 		     " or adminName like  ?" +
	 		     " or newsAuthor like ? order by newsInfoId desc",'%' + keyword + '%', 
	 		    '%' + keyword + '%',Common.getSwitchDate(keyword), '%' + keyword + '%', 
	 		    '%' + keyword + '%', '%' + keyword + '%').get(0);
       }
       
       
}
