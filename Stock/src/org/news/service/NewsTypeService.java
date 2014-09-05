/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsTypeService
 * 
 * 创建日期：2014-06-20
 */
package org.news.service;

import java.util.List;

import org.news.model.NewsType;

/**
 * 文章类型服务类接口
 * @author tt
 * @version 14.6.18
 */
public interface NewsTypeService {
	
	/**
	 * 添加频道
	 * @param type
	 * @param description
	 * @return 操作是否成功
	 */
	public boolean addNewsType(String type, String description);
	
	/**
	 * 删除新闻种类
	 * @param index
	 * @return 是否成功
	 */
	public boolean deleteNewsType(int index);
	
	/**
	 * 修改频道信息
	 * @param NewsType
	 * @return 是否成功
	 */
	public boolean updateNewsType(NewsType newsType) ;
	
	/**
	* 查询所有的频道信息
	* @return 频道集合
	*/
	 public List<NewsType> getAllNewsType();

	/**
	 * 根据ID号找到对应的类别
	 * @param typeid
	 * @return
	 */
	public NewsType getNewsTypeById(int typeid);

	/**
	 * 根据名称找到对应的类别
	 * @param name
	 * @return
	 */
	public boolean findNewsTypeName(String name);
}
