/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsTypeHibernateDAO
 * 
 * �������ڣ�2014-09-12
 */
package org.news.dao;

import java.util.ArrayList;
import java.util.List;

import org.news.model.NewsType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ����������ϢDAO
 * @author tt
 * @version 14.8.18
 */
public class NewsTypeHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(NewsTypeHibernateDAO.class);
	
	/**
	 * ���Ƶ��
	 * @param newsType
	 * @return �����Ƿ�ɹ�
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
	 * ����ɾ��
	 * @param newsTypeIds
	 * @return �Ƿ�ɹ�
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
     * ��ͨ��Id������Ƶ������Ϣ
     * @param typeId
     * @return
     */
    public NewsType findNewsTypeById(int typeId){
    	return (NewsType)getHibernateTemplate().get(NewsType.class, typeId); 
    }
    
    /**
	 * �޸�Ƶ����Ϣ
	 * @param NewsType
	 * @return Ƶ��
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
	 * ��ѯ���е�Ƶ����Ϣ
	 * @return Ƶ������
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
      * ��ͨ������������Ƶ������Ϣ
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
