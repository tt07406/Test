/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInfoServiceImpl
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mystock.dao.NewsInfoHibernateDAO;
import org.mystock.model.NewsIndex;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsVO;
import org.mystock.service.NewsInfoService;

/**
 * ������Ϣ������
 * @author tt
 * @version 14.9.16
 */
public class NewsInfoServiceImpl implements NewsInfoService{
	private NewsInfoHibernateDAO newsInfoDAO; //����������ϢDAO
	
	/**
	 * @param newsInfoDAO the newsInfoDAO to set
	 */
	public void setNewsInfoDAO(NewsInfoHibernateDAO newsInfoDAO) {
		this.newsInfoDAO = newsInfoDAO;
	}

	/**
	 * ������ŷ���
	 * @param newsInfo
	 * @return �����Ƿ�ɹ�
	 * @throws IOException 
	 */
	public boolean addNewsInfo(NewsInfo newsInfo){
		Long currentID = newsInfoDAO.addNewsInfo(newsInfo);
		if (currentID <= 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	/**
	 * ����ɾ������
	 * @param newsInfoIds
	 * @return
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds) {
		return newsInfoDAO.deleteNewsInfo(newsInfoIds);
	}
	
	/**
	 * ��ѯ�������ݷ���
	 * @param newsInfoId
	 * @return
	 */
	public NewsInfo searchNewsInfo(int newsInfoId) {
		return newsInfoDAO.searchNewsInfo(newsInfoId);
	}
	
	/**
	 * �޸�������Ϣ����
	 * @param newsInfo
	 * @return
	 * @throws IOException 
	 */
	public boolean updateNewsInformation(NewsInfo newsInfo){
		if (newsInfoDAO.updateNewsInformation(newsInfo) == null){
			return false;
	    }else{
	    	return true;
	    }
	}
	
	/**
	 * ��ѯ���е�������Ϣ
	 * @return ���ż���
	 */
     public List<NewsInfo> getAllNewsInfo(){
    	 return newsInfoDAO.getAllNewsInfo();
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword
      * @return ���ż���
      */
     public List<NewsInfo> getAllNewsInfo(String keyword){
    	 return newsInfoDAO.getAllNewsInfo(keyword);
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return ���ż���
      */
     public List<NewsInfo> getAllNewsInfo(String keyword, int currentPage, int lineSize){
    	 return newsInfoDAO.getAllNewsInfo(keyword,currentPage,lineSize);
     }
     
     /**
  	 * �����������Ͳ�ѯ����ص�����
  	 * @param newsType 
  	 * @return ���ż���
  	 */
       public List<NewsInfo> getAllNewsInfoByType(String newsType){
    	   List<NewsInfo> newsInfos = getAllNewsInfo();
    	   List<NewsInfo> results = new ArrayList<NewsInfo>();
    	   
    	   for (NewsInfo news:newsInfos){
    		   if (news.getNewsType().contains(newsType+",")){
    			   results.add(news);
    		   }
    	   }
    	   return results;
       }
       
       /**
     	 * �����������Ͳ�ѯ����ص�����
     	 * @param newsType 
     	 * @param currentPage ��ǰҳ
     	 * @param lineSize ÿҳ��С
     	 * @return ���ż���
     	 */
          public List<NewsInfo> getAllNewsInfoByType(String newsType, int currentPage, int lineSize){
        	  List<NewsInfo> newsInfos = getAllNewsInfoByType(newsType);
        	  int floor = (currentPage - 1) * lineSize ;//����
        	  int celling = currentPage * lineSize ; //����
        	 
        	  List<NewsInfo> result = new ArrayList<NewsInfo>();
        	  for (int i = 0; i < newsInfos.size(); ++i){
        		  if (i >= floor && i < celling){
        			  result.add(newsInfos.get(i));
        		  }
        	  }
        	  
        	  return result;
          }
       
       /**
        * ��ȡ��ѯ���������
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword){
    	   return newsInfoDAO.getAllCount(keyword);
       }
       
       /**
        * �����ŵ�POת����VO����ʾ
        * @param newsInfo
        * @return
        */
       public NewsVO toNewsVO(NewsInfo newsInfo){
    	   NewsVO newsVO = new NewsVO();
    	   if (newsInfo != null){
    		   newsVO.setNewsInfoId(newsInfo.getNewsInfoId());
    		   newsVO.setNewsAuthor(newsInfo.getNewsAuthor());
    		   newsVO.setNewsInfoTime(newsInfo.getNewsInfoTime());
    		   newsVO.setNewsInfoTitle(newsInfo.getNewsInfoTitle());
    		   newsVO.setNewsType(newsInfo.getNewsType());
    	   }
    	   return newsVO;    	   
       }
       
       /**
        * �����ŵ�POת��������VO����ʾ
        * @param newsInfo
        * @return
        */
       public NewsIndex toNewsIndex(NewsInfo newsInfo){
    	   NewsIndex newsVO = new NewsIndex();
    	   if (newsInfo != null){
    		   newsVO.setNewsInfoId(newsInfo.getNewsInfoId());
    		   newsVO.setNewsAuthor(newsInfo.getNewsAuthor());
    		   newsVO.setNewsInfoTime(newsInfo.getNewsInfoTime().toString());
    		   newsVO.setNewsInfoTitle(newsInfo.getNewsInfoTitle());
    	   }
    	   return newsVO;    	   
       }
}
