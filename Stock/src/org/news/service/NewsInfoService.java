/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsInfoService
 * 
 * 创建日期：2014-06-18
 */
package org.news.service;

import java.io.IOException;
import java.util.List;

import org.news.model.NewsIndex;
import org.news.model.NewsInfo;
import org.news.model.NewsVO;

/**
 * 文章信息服务类接口
 * @author tt
 * @version 14.6.18
 */
public interface NewsInfoService {

	/**
	 * 添加新闻服务
	 * @param newsInfo
	 * @return 操作是否成功
	 * @throws IOException 
	 */
	public boolean addNewsInfo(NewsInfo newsInfo,
			List<java.io.File> attachment, List<String> attachmentFileName) throws IOException;
	
	/**
	 * 批量删除服务
	 * @param newsInfoIds
	 * @return
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds);
	
	/**
	 * 查询文章内容服务
	 * @param newsInfoId
	 * @return
	 */
	public NewsInfo searchNewsInfo(int newsInfoId);
	
	/**
	 * 修改文章信息服务
	 * @param newsInfo
	 * @return
	 * @throws IOException 
	 */
	public boolean updateNewsInformation(NewsInfo newsInfo, 
			List<java.io.File> attachment, List<String> attachmentFileName) throws IOException;
	
	/**
	 * 查询所有的新闻信息
	 * @return 新闻集合
	 */
     public List<NewsInfo> getAllNewsInfo();
     
     /**
      * 模糊查询新闻，只要文章标题、描述、内容、时间和作者有一个匹配上即可
      * @param keyword
      * @return 新闻集合
      */
     public List<NewsInfo> getAllNewsInfo(String keyword);
     
     /**
      * 模糊查询新闻，只要文章标题、描述、内容、时间和作者有一个匹配上即可
      * @param keyword 关键字
      * @param currentPage 当前页
      * @param lineSize 每页大小
      * @return 新闻集合
      */
     public List<NewsInfo> getAllNewsInfo(String keyword, int currentPage, int lineSize);
     
     /**
  	 * 根据文章类型查询的相关的新闻
  	 * @param newsType 
  	 * @return 新闻集合
  	 */
       public List<NewsInfo> getAllNewsInfoByType(String newsType);
       
       /**
     	 * 根据文章类型查询的相关的新闻
     	 * @param newsType 
     	 * @param currentPage 当前页
     	 * @param lineSize 每页大小
     	 * @return 新闻集合
     	 */
          public List<NewsInfo> getAllNewsInfoByType(String newsType, int currentPage, int lineSize);
       
       /**
        * 获取查询结果的数量
        * @param keyword
        * @return
        */
       public long getAllCount(String keyword);
       
       /**
        * 将新闻的PO转化成VO供显示
        * @param newsInfo
        * @return
        */
       public NewsVO toNewsVO(NewsInfo newsInfo);
       
       /**
        * 将新闻的PO转化成索引VO供显示
        * @param newsInfo
        * @return
        */
       public NewsIndex toNewsIndex(NewsInfo newsInfo);

       /**
        * 文件转化为字节流
        * @param file
        * @return
        * @throws IOException
        */
       public  byte[] readFile(java.io.File file) throws IOException ;
}
