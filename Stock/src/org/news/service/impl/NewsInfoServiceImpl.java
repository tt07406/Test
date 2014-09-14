/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsInfoService
 * 
 * 创建日期：2014-06-18
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
 * 文章信息服务类
 * @author tt
 * @version 14.6.18
 */
public class NewsInfoServiceImpl implements NewsInfoService{
	private NewsInfoHibernateDAO newsInfoDAO; //引入新闻消息DAO
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
	 * 添加新闻服务
	 * @param newsInfo
	 * @return 操作是否成功
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
		//上传附件
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
	 * 批量删除服务
	 * @param newsInfoIds
	 * @return
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds) {
		for (int i=0;i<newsInfoIds.length;++i){
			//有附件才删除附件
			if(attachmentDAO.findNewsAttachmentByNewsId(newsInfoIds[i]).size()>0&&!attachmentDAO.deleteNewsAttachmentByNewsId(newsInfoIds[i])){
				return false;
			}
		}

		return newsInfoDAO.deleteNewsInfo(newsInfoIds);
	}
	
	/**
	 * 查询文章内容服务
	 * @param newsInfoId
	 * @return
	 */
	public NewsInfo searchNewsInfo(int newsInfoId) {
		return newsInfoDAO.searchNewsInfo(newsInfoId);
	}
	
	/**
	 * 修改文章信息服务
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
	 * 查询所有的新闻信息
	 * @return 新闻集合
	 */
     public List<NewsInfo> getAllNewsInfo(){
    	 return newsInfoDAO.getAllNewsInfo();
     }
     
     /**
      * 模糊查询新闻，只要文章标题、描述、内容、时间和作者有一个匹配上即可
      * @param keyword
      * @return 新闻集合
      */
     public List<NewsInfo> getAllNewsInfo(String keyword){
    	 return newsInfoDAO.getAllNewsInfo(keyword);
     }
     
     /**
      * 模糊查询新闻，只要文章标题、描述、内容、时间和作者有一个匹配上即可
      * @param keyword 关键字
      * @param currentPage 当前页
      * @param lineSize 每页大小
      * @return 新闻集合
      */
     public List<NewsInfo> getAllNewsInfo(String keyword, int currentPage, int lineSize){
    	 return newsInfoDAO.getAllNewsInfo(keyword,currentPage,lineSize);
     }
     
     /**
  	 * 根据文章类型查询的相关的新闻
  	 * @param newsType 
  	 * @return 新闻集合
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
     	 * 根据文章类型查询的相关的新闻
     	 * @param newsType 
     	 * @param currentPage 当前页
     	 * @param lineSize 每页大小
     	 * @return 新闻集合
     	 */
          public List<NewsInfo> getAllNewsInfoByType(String newsType, int currentPage, int lineSize){
        	  List<NewsInfo> newsInfos = getAllNewsInfoByType(newsType);
        	  int floor = (currentPage - 1) * lineSize ;//下限
        	  int celling = currentPage * lineSize ; //上限
        	 
        	  List<NewsInfo> result = new ArrayList<NewsInfo>();
        	  for (int i = 0; i < newsInfos.size(); ++i){
        		  if (i >= floor && i < celling){
        			  result.add(newsInfos.get(i));
        		  }
        	  }
        	  
        	  return result;
          }
       
       /**
        * 获取查询结果的数量
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword){
    	   return newsInfoDAO.getAllCount(keyword);
       }
       
       /**
        * 将新闻的PO转化成VO供显示
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
        * 将新闻的PO转化成索引VO供显示
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
        * 文件转化为字节流
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
				throw new IOException("读取文件不正确");
			bufferedInputStream.close();
			return bytes;
       }
}
