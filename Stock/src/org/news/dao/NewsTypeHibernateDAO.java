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
	 * ����Ƶ��
	 * @param newsType
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addNewsType(NewsType newsType){
		try {
			getHibernateTemplate().save(newsType);
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
	 * @param newsTypeIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteNewsType(ArrayList<Integer> newsTypeIds) {
		for (int i = 0; i < newsTypeIds.size(); i++) {
			try {
				getHibernateTemplate().delete(findNewsTypeById(newsTypeIds.get(i).intValue()));
				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				return false;
			}
		}
		return true;
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
	public NewsType updateNewsType(NewsType newsType) {
		try{
			getHibernateTemplate().update(newsType);
			log.debug("update successful");
			return newsType;
		}catch (Exception e) {
			log.error("update failed", e);
			e.printStackTrace();
		}
		return null;
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
     public NewsType findNewsTypeByName(String typename){
    	 try {
   			String queryString = "from newstype where newsTypeName = ?";
   			return (NewsType)getHibernateTemplate().find(queryString, typename).get(0);
   		} catch (RuntimeException re) {
   			log.error("find all failed", re);
   			throw re;
   		}
     }
}