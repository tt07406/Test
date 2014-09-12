/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsTypeService
 * 
 * 创建日期：2014-06-20
 */
package org.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.news.dao.NewsTypeHibernateDAO;
import org.news.model.NewsInfo;
import org.news.model.NewsType;
import org.news.service.NewsInfoService;
import org.news.service.NewsTypeService;

/**
 * 文章类型服务类
 * @author tt
 * @version 14.6.18
 */
public class NewsTypeServiceImpl implements NewsTypeService {
	private NewsTypeHibernateDAO newsTypeDAO; //引入新闻消息DAO
	private NewsInfoService infoService;
	
	
	/**
	 * @param newsTypeDAO the newsTypeDAO to set
	 */
	public void setNewsTypeDAO(NewsTypeHibernateDAO newsTypeDAO) {
		this.newsTypeDAO = newsTypeDAO;
	}

	/**
	 * @param infoService the infoService to set
	 */
	public void setInfoService(NewsInfoService infoService) {
		this.infoService = infoService;
	}

	/**
	 * 添加频道
	 * @param type
	 * @param description
	 * @return 操作是否成功
	 */
	public boolean addNewsType(String type, String description){
		if (findNewsTypeName(type)){//重复性验证
			return false;
		}

		boolean flag = true;//标志
		List<NewsType> typeSet = getAllNewsType();//获取当前所有频道
		int newsTypeId;//频道ID
		if (typeSet.size() == 0){
			newsTypeId = 1;
		}else{
			newsTypeId = typeSet.get(typeSet.size()-1).getNewsTypeId()+1;
		}
		
		NewsType newstype = new NewsType(newsTypeId, type, description);
		if (!newsTypeDAO.addNewsType(newstype)){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 删除新闻种类
	 * @param index
	 * @return 是否成功
	 */
	public boolean deleteNewsType(int index) {
		ArrayList<Integer> newsTypeIds = new ArrayList<Integer>(); //要删除的频道ID
		newsTypeIds.add(new Integer(index));
		String newsType = getNewsTypeById(index).getNewsTypeName();
		
		if(newsTypeDAO.deleteNewsType(newsTypeIds)){
			List<NewsInfo> newsInfos = infoService.getAllNewsInfoByType(newsType);//得到所有该类新闻
			if (newsInfos.size() == 0){//没有新闻则成功
				return true;
			}
			//删除所有相关新闻
			int [] newsInfoIds = new int[newsInfos.size()];
			for (int i = 0; i<newsInfoIds.length; ++i){
				newsInfoIds[i] = newsInfos.get(i).getNewsInfoId();
			}
			return infoService.deleteNewsInfo(newsInfoIds);
		}else {
			return false;
		}
			
	}
	
	/**
	 * 修改频道信息
	 * @param NewsType
	 * @return 是否成功
	 */
	public boolean updateNewsType(NewsType newsType) {
		if (newsTypeDAO.updateNewsType(newsType) == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	* 查询所有的频道信息
	* @return 频道集合
	*/
	 public List<NewsType> getAllNewsType(){
		 return newsTypeDAO.getAllNewsType();
	}

	/**
	 * 根据ID号找到对应的类别
	 * @param typeid
	 * @return
	 */
	public NewsType getNewsTypeById(int typeid){
		return newsTypeDAO.findNewsTypeById(typeid);
	}

	/**
	 * 根据名称找到对应的类别
	 * @param name
	 * @return
	 */
	public boolean findNewsTypeName(String name){
		if (newsTypeDAO.findNewsTypeByName(name) == null){
			return false;
		}else {
			return true;
		}
			
	}
}
