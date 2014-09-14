/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsTypeHibernateDAO
 * 
 * 创建日期：2014-09-12
 */
package org.news.dao;

import java.util.ArrayList;
import java.util.List;

import org.news.model.NewsType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 文章类型信息DAO
 * @author tt
 * @version 14.8.18
 */
public class NewsTypeHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(NewsTypeHibernateDAO.class);
	
	/**
	 * 添加频道
	 * @param newsType
	 * @return 操作是否成功
	 */
	@SuppressWarnings("finally")
	public boolean addNewsType(NewsType newsType){
		boolean result = false;
		try {
			getHibernateTemplate().save(newsType);
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
	 * 批量删除
	 * @param newsTypeIds
	 * @return 是否成功
	 */
	public boolean deleteNewsType(ArrayList<Integer> newsTypeIds) {
		boolean result = true;
		for (int i = 0; i < newsTypeIds.size(); i++) {
			try {
				getHibernateTemplate().delete(findNewsTypeById(newsTypeIds.get(i).intValue()));
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
     * 可通过Id来查找频道的信息
     * @param typeId
     * @return
     */
    public NewsType findNewsTypeById(int typeId){
    	return (NewsType)getHibernateTemplate().get(NewsType.class, typeId); 
    }
    
    /**
	 * 修改频道信息
	 * @param NewsType
	 * @return 频道
	 */
	@SuppressWarnings("finally")
	public NewsType updateNewsType(NewsType newsType) {
		try{
			getHibernateTemplate().update(newsType);
			log.debug("update successful");
		}catch (RuntimeException e) {
			log.error("update failed", e);
			newsType =  null;
			throw e;
		}finally{
			return newsType;
		}
	}
	
	/**
	 * 查询所有的频道信息
	 * @return 频道集合
	 */
     @SuppressWarnings("unchecked")
	public List<NewsType> getAllNewsType(){
    	 try {
   			String queryString = "from newstype order by newsTypeId";
   			return (List<NewsType>)getHibernateTemplate().find(queryString);
   		} catch (RuntimeException re) {
   			log.error("find all failed", re);
   			throw re;
   		}
     }
     
     /**
      * 可通过名称来查找频道的信息
      * @param typename
      * @return
      */
     @SuppressWarnings("unchecked")
	public NewsType findNewsTypeByName(String typename){
    	 try {
   			String queryString = "from newstype where newsTypeName = ?";
   			List<NewsType> result = getHibernateTemplate().find(queryString, typename);
   			if (result.size()>0){
   				return result.get(0);
   			}else{
   				return null;
   			}
   		} catch (RuntimeException re) {
   			log.error("find all failed", re);
   			return null;
   		}
     }
}
