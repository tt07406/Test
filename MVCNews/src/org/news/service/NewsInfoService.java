/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsInfoService
 * 
 * �������ڣ�2014-06-18
 */
package org.news.service;

import java.util.ArrayList;
import java.util.List;

import org.news.dao.AdminDAO;
import org.news.dao.NewsAttachmentDAO;
import org.news.dao.NewsInfoDAO;
import org.news.model.NewsAttachment;
import org.news.model.NewsIndex;
import org.news.model.NewsInfo;
import org.news.model.NewsVO;
import org.news.utils.Logger;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;

/**
 * ������Ϣ������
 * @author tt
 * @version 14.6.18
 */
public class NewsInfoService {

	private NewsInfoDAO newsInfoDAO = new NewsInfoDAO(); //����������ϢDAO
	private AdminDAO adminDAO = new AdminDAO();
	private NewsAttachmentDAO attachmentDAO = new NewsAttachmentDAO();
	
	/**
	 * �������ŷ���
	 * @param newsInfo
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addNewsInfo(NewsInfo newsInfo,SmartUpload upload){
		Long currentID = (long)newsInfo.getNewsInfoId();
    	
		//���ϴ�����
		for(int i=0;i<upload.getFiles().getCount();i++){
			File f = upload.getFiles().getFile(i);
			if(f.isMissing())continue;
			
			Logger.log("size"+f.getSize(), Logger.DEBUG);
			NewsAttachment newsAttachment=new NewsAttachment();
			newsAttachment.setNewsId(currentID);
			newsAttachment.setAttachmentName(f.getFileName());
			newsAttachment.setAttachmentContent(f.getFileBinaryData());
			if (!attachmentDAO.addNewsAttachment(newsAttachment)){
				return false;
			}			
		}
		return newsInfoDAO.addNewsInfo(newsInfo);
	}
	
	/**
	 * ����ɾ������
	 * @param newsInfoIds
	 * @return
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds) {
		for (int i=0;i<newsInfoIds.length;++i){
			//�и�����ɾ������
			if(attachmentDAO.findNewsAttachmentByNewsId(newsInfoIds[i]).size()>0&&!attachmentDAO.deleteNewsAttachmentByNewsId(newsInfoIds[i])){
				return false;
			}
		}

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
	 */
	public boolean updateNewsInformation(NewsInfo newsInfo, SmartUpload upload) {
		if (newsInfoDAO.updateNewsInformation(newsInfo) == null){
			return false;
	    }else{
	    	Long currentID = (long)newsInfo.getNewsInfoId();
	    	//attachmentDAO.deleteNewsAttachmentByNewsId(currentID);
			for(int i=0;i<upload.getFiles().getCount();i++){
				File f = upload.getFiles().getFile(i);
				if(f.isMissing())continue;
				
				NewsAttachment newsAttachment=new NewsAttachment();
				newsAttachment.setNewsId(currentID);
				newsAttachment.setAttachmentName(f.getFileName());
				newsAttachment.setAttachmentContent(f.getFileBinaryData());
				if (!attachmentDAO.addNewsAttachment(newsAttachment)){
					return false;
				}
			}
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
      * ģ����ѯ���ţ�ֻҪ���±��⡢���������ݡ�ʱ���������һ��ƥ���ϼ���
      * @param keyword
      * @return ���ż���
      */
     public List<NewsInfo> getAllNewsInfo(String keyword){
    	 return newsInfoDAO.getAllNewsInfo(keyword);
     }
     
     /**
      * ģ����ѯ���ţ�ֻҪ���±��⡢���������ݡ�ʱ���������һ��ƥ���ϼ���
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
    		   newsVO.setNewsInfoDescribe(newsInfo.getNewsInfoDescribe());
    		   newsVO.setAdminName(adminDAO.findAdminById(newsInfo.getAdminId()).getAdminName());
    		   newsVO.setNewsInfoState(newsInfo.getNewsInfoState());
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
    		   newsVO.setNewsInfoDescribe(newsInfo.getNewsInfoDescribe());
    		   newsVO.setNewsInfoTime(newsInfo.getNewsInfoTime().toString());
    		   newsVO.setNewsInfoTitle(newsInfo.getNewsInfoTitle());
    	   }
    	   return newsVO;    	   
       }
}