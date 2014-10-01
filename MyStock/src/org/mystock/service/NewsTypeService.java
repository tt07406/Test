/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsTypeService
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.mystock.model.NewsType;

/**
 * 文章类型服务类接口
 * @author tt
 * @version 14.9.16
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
	
	/**
     * 备份到数据库
     */
    public void backup(SessionFactory sf);
}
