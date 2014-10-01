/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsInfoServiceImpl
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mystock.dao.NewsInfoHibernateDAO;
import org.mystock.model.NewsIndex;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsVO;
import org.mystock.service.NewsInfoService;

/**
 * 文章信息服务类
 * @author tt
 * @version 14.9.16
 */
public class NewsInfoServiceImpl implements NewsInfoService{
	private NewsInfoHibernateDAO newsInfoDAO; //引入新闻消息DAO
	
	/**
	 * @param newsInfoDAO the newsInfoDAO to set
	 */
	public void setNewsInfoDAO(NewsInfoHibernateDAO newsInfoDAO) {
		this.newsInfoDAO = newsInfoDAO;
	}

	/**
	 * 添加新闻服务
	 * @param newsInfo
	 * @return 操作是否成功
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
	 * 批量删除服务
	 * @param newsInfoIds
	 * @return
	 */
	public boolean deleteNewsInfo(int[] newsInfoIds) {
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
	public boolean updateNewsInformation(NewsInfo newsInfo){
		if (newsInfoDAO.updateNewsInformation(newsInfo) == null){
			return false;
	    }else{
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
      * 模糊查询新闻，只要文章标题、内容、时间和作者有一个匹配上即可
      * @param keyword
      * @return 新闻集合
      */
     public List<NewsInfo> getAllNewsInfo(String keyword){
    	 return newsInfoDAO.getAllNewsInfo(keyword);
     }
     
     /**
      * 模糊查询新闻，只要文章标题、内容、时间和作者有一个匹配上即可
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
    		   newsVO.setNewsInfoTime(newsInfo.getNewsInfoTime());
    		   newsVO.setNewsInfoTitle(newsInfo.getNewsInfoTitle());
    		   newsVO.setNewsType(newsInfo.getNewsType());
    		   newsVO.setAdminName(newsInfo.getAdminName());
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
    		   newsVO.setNewsInfoTime(newsInfo.getNewsInfoTime().toString());
    		   newsVO.setNewsInfoTitle(newsInfo.getNewsInfoTitle());
    	   }
    	   return newsVO;    	   
       }
       
       /**
        * 备份到数据库
        */
       public void backup(SessionFactory sf){
    	    List<NewsInfo> data = getAllNewsInfo();//获取源数据
    	    Session session = null;
    	    Transaction tx = null;
	   		
	   		//先回收空间
	   		try {
	   			session = sf.openSession();
				tx = session.beginTransaction();
				session.createSQLQuery("truncate table newsinfo").executeUpdate();
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				if (session != null) {
	   				if (session.isOpen()) {
	   					session.close(); // 关闭Session
	   				}
	   			}
			}
	   		
	   		try{			
	   			session = sf.openSession();
	   			//开始事务
	   			Transaction t=session.beginTransaction();
	   			
	   			//备份新闻详情
	   			for (int i = 0; i< data.size(); ++i){
	   				session.save(data.get(i));
	   			
	   				// 批插入的对象立即写入数据库并释放内存
	   				if (i % 10 == 0) {
	   					session.flush();
	   					session.clear();
	   				}
	   			}
	   			//提交事务
	   			t.commit();
	   		}catch (Exception e) {
	   			e.printStackTrace(); // 打印错误信息
	   			session.getTransaction().rollback(); // 出错将回滚事物
	   		} finally {
	   			if (session != null) {
	   				if (session.isOpen()) {
	   					session.close(); // 关闭Session
	   				}
	   			}
	   		}
       }
}
