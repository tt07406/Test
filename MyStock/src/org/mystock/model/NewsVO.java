/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsVO
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.model;

import java.util.Date;

/**
 * 文章信息的PO类
 * 
 * @author tt
 * @version 14.9.16
 */
public class NewsVO {
	
	private int newsInfoId;				//文章Id
	private String newsInfoTitle;		//文章标题
	private Date newsInfoTime;		//创建时间
	private String newsAuthor;			//文章作者
	private String newsType;				//文章分类
	private String adminName;			//创建者
	
	/**
	 * 获取文章Id
	 * @return the newsInfoId
	 */
	public int getNewsInfoId() {
		return newsInfoId;
	}
	
	/**
	 * 设置文章Id
	 * @param newsInfoId the newsInfoId to set
	 */
	public void setNewsInfoId(int newsInfoId) {
		this.newsInfoId = newsInfoId;
	}
	
	/**
	 * 获取文章标题
	 * @return the newsInfoTitle
	 */
	public String getNewsInfoTitle() {
		return newsInfoTitle;
	}
	
	/**
	 * 设置文章标题
	 * @param newsInfoTitle the newsInfoTitle to set
	 */
	public void setNewsInfoTitle(String newsInfoTitle) {
		this.newsInfoTitle = newsInfoTitle;
	}
	
	/**
	 * 获取创建时间
	 * @return the newsInfoTime
	 */
	public Date getNewsInfoTime() {
		return newsInfoTime;
	}
	
	/**
	 * 设置创建时间
	 * @param newsInfoTime the newsInfoTime to set
	 */
	public void setNewsInfoTime(Date newsInfoTime) {
		this.newsInfoTime = newsInfoTime;
	}
	
	/**
	 * 获取文章作者
	 * @return the newsAuthor
	 */
	public String getNewsAuthor() {
		return newsAuthor;
	}
	
	/**
	 * 设置文章作者
	 * @param newsAuthor the newsAuthor to set
	 */
	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}
	
	/**
	 * 获取文章分类
	 * @return the newsType
	 */
	public String getNewsType() {
		return newsType;
	}
	
	/**
	 * 设置文章分类
	 * @param newsType the newsTypeId to set
	 */
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
