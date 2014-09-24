/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsType
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 文章频道PO类
 * @author tt
 * @version 14.9.16
 */
@Entity(name="newstype")
public class NewsType {
	
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private int newsTypeId;				//频道Id
	private String newsTypeName;		//频道名，是不同种类的组合
	private String newsTypeDescripe;	//频道描述
	
	protected NewsType() {
	}

	/**
	 * 初始化函数
	 * @param newsTypeId
	 * @param newsTypeName
	 * @param newsTypeDescripe
	 */
	public NewsType(int newsTypeId, String newsTypeName, String newsTypeDescripe) {
		super();
		this.newsTypeId = newsTypeId;
		this.newsTypeName = newsTypeName;
		this.newsTypeDescripe = newsTypeDescripe;
	}

	/**
	 * 拷贝构造函数
	 * @param newsType
	 */
	public NewsType(NewsType newsType) {
		this.newsTypeId = newsType.getNewsTypeId();
		this.newsTypeName = newsType.getNewsTypeName();
		this.newsTypeDescripe = newsType.getNewsTypeDescripe();
	}


	/**
	 * 获取频道Id
	 * @return the newsTypeId
	 */
	public int getNewsTypeId() {
		return newsTypeId;
	}
	
	/**
	 * 设置频道Id
	 * @param newsTypeId the newsTypeId to set
	 */
	public void setNewsTypeId(int newsTypeId) {
		this.newsTypeId = newsTypeId;
	}
	
	/**
	 * 获取频道名
	 * @return the newsTypeName
	 */
	public String getNewsTypeName() {
		return newsTypeName;
	}
	
	/**
	 * 设置频道名
	 * @param newsTypeName the newsTypeName to set
	 */
	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}
	
	/**
	 * 获取频道描述
	 * @return the newsTypeDescripe
	 */
	public String getNewsTypeDescripe() {
		return newsTypeDescripe;
	}
	
	/**
	 * 设置频道描述
	 * @param newsTypeDescripe the newsTypeDescripe to set
	 */
	public void setNewsTypeDescripe(String newsTypeDescripe) {
		this.newsTypeDescripe = newsTypeDescripe;
	}
	
	

}
