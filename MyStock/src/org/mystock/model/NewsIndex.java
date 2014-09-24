/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsIndex
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.model;

/**
 * 文章索引VO
 * 
 * @author tt
 * @version 14.9.16
 */
public class NewsIndex {

	private int newsInfoId;				//文章Id
	private String newsInfoTitle;		//文章标题
	private String newsInfoTime;		//创建时间
	private String newsAuthor;			//文章作者
	
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
	public String getNewsInfoTime() {
		return newsInfoTime;
	}
	/**
	 * 设置创建时间
	 * @param newsInfoTime the newsInfoTime to set
	 */
	public void setNewsInfoTime(String newsInfoTime) {
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
}
