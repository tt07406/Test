/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsInfoService
 * 
 * �������ڣ�2014-06-18
 */
package org.news.service.impl;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.news.dao.AdminHibernateDAO;
import org.news.dao.NewsAttachmentHibernateDAO;
import org.news.dao.NewsInfoHibernateDAO;
import org.news.model.NewsAttachment;
import org.news.model.NewsIndex;
import org.news.model.NewsInfo;
import org.news.model.NewsVO;
import org.news.service.NewsInfoService;

/**
 * ������Ϣ������
 * @author tt
 * @version 14.6.18
 */
public class NewsInfoServiceImpl implements NewsInfoService{
	private NewsInfoHibernateDAO newsInfoDAO; //����������ϢDAO
	private AdminHibernateDAO adminDAO;
	private NewsAttachmentHibernateDAO attachmentDAO;
	
	/**
	 * @param newsInfoDAO the newsInfoDAO to set
	 */
	public void setNewsInfoDAO(NewsInfoHibernateDAO newsInfoDAO) {
		this.newsInfoDAO = newsInfoDAO;
	}

	/**
	 * @param adminDAO the adminDAO to set
	 */
	public void setAdminDAO(AdminHibernateDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	/**
	 * @param attachmentDAO the attachmentDAO to set
	 */
	public void setAttachmentDAO(NewsAttachmentHibernateDAO attachmentDAO) {
		this.attachmentDAO = attachmentDAO;
	}

	/**
	 * ������ŷ���
	 * @param newsInfo
	 * @return �����Ƿ�ɹ�
	 * @throws IOException 
	 */
	public boolean addNewsInfo(NewsInfo newsInfo,
			List<java.io.File> attachment, List<String> attachmentFileName) throws IOException{
		Long currentID = newsInfoDAO.addNewsInfo(newsInfo);
		if (currentID < 0){
			return false;
		}
    	if (attachment == null){
    		return true;
    	}
		//�ϴ�����
		for(int i=0;i<attachment.size();i++){

			NewsAttachment newsAttachment=new NewsAttachment();
			newsAttachment.setNewsId(currentID);
			newsAttachment.setAttachmentName(attachmentFileName.get(i));
			newsAttachment.setAttachmentContent(readFile(attachment.get(i)));
			if (!attachmentDAO.addNewsAttachment(newsAttachment)){
				return false;
			}			
		}
		return true;
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
	 * @throws IOException 
	 */
	public boolean updateNewsInformation(NewsInfo newsInfo, 
			List<java.io.File> attachment, List<String> attachmentFileName) throws IOException {
		if (newsInfoDAO.updateNewsInformation(newsInfo) == null){
			return false;
	    }else{
	    	if (attachment == null){
	    		return true;
	    	}
	    	Long currentID = (long)newsInfo.getNewsInfoId();
			for(int i=0;i<attachment.size();i++){

				NewsAttachment newsAttachment=new NewsAttachment();
				newsAttachment.setNewsId(currentID);
				newsAttachment.setAttachmentName(attachmentFileName.get(i));
				newsAttachment.setAttachmentContent(readFile(attachment.get(i)));
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

       /**
        * �ļ�ת��Ϊ�ֽ���
        * @param file
        * @return
        * @throws IOException
        */
       public  byte[] readFile(java.io.File file) throws IOException {  
			long len = file.length();
			byte[] bytes = new byte[(int) len];
	
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					new FileInputStream(file));
			int r = bufferedInputStream.read(bytes);
			if (r != len)
				throw new IOException("��ȡ�ļ�����ȷ");
			bufferedInputStream.close();
			return bytes;
       }
}
