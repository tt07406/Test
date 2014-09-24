/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsInfo
 * 
 * 创建日期：2014-06-18
 */
package org.news.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 文章信息的PO类
 * 
 * @author tt
 * @version 14.6.18
 */
@Entity(name="newsinfo")
public class NewsInfo {

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private int newsInfoId;				//文章Id
	private String newsInfoTitle;		//文章标题
	private String newsInfoDescribe;	//文章描述
	private String newsInfoContent;		//文章内容
	private Date newsInfoTime;		//创建时间
	private String newsAuthor;			//文章作者
	private int adminId;				//管理员Id
	private String newsType;				//文章分类Id
	private int newsInfoState;			//文章状态
	
	public NewsInfo() {
	}

	/**
	 * 初始化函数
	 * @param newsInfoId
	 * @param newsInfoTitle
	 * @param newsInfoDescribe
	 * @param newsInfoContent
	 * @param newsInfoTime
	 * @param newsAuthor
	 * @param adminId
	 * @param newsTypeId
	 * @param newsInfoState
	 */
	public NewsInfo(int newsInfoId, String newsInfoTitle,
			String newsInfoDescribe, String newsInfoContent,
			Date newsInfoTime, String newsAuthor, int adminId,
			String newsType, int newsInfoState) {
		super();
		this.newsInfoId = newsInfoId;
		this.newsInfoTitle = newsInfoTitle;
		this.newsInfoDescribe = newsInfoDescribe;
		this.newsInfoContent = newsInfoContent;
		this.newsInfoTime = newsInfoTime;
		this.newsAuthor = newsAuthor;
		this.adminId = adminId;
		this.newsType = newsType;
		this.newsInfoState = newsInfoState;
	}
	
	/**
	 * 获取文章Id
	 * @return the newsInfoId
	 */
	public int getNewsInfoId() {
		return newsInfoId;
	}
	
	/**文章Id
	 * 设置
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
	 * 获取 文章描述
	 * @return the newsInfoDescribe
	 */
	public String getNewsInfoDescribe() {
		return newsInfoDescribe;
	}
	
	/**
	 * 设置文章描述
	 * @param newsInfoDescribe the newsInfoDescribe to set
	 */
	public void setNewsInfoDescribe(String newsInfoDescribe) {
		this.newsInfoDescribe = newsInfoDescribe;
	}
	
	/**获取文章内容
	 * @return the newsInfoContent
	 */
	public String getNewsInfoContent() {
		return newsInfoContent;
	}
	
	/**
	 * 设置文章内容
	 * @param newsInfoContent the newsInfoContent to set
	 */
	public void setNewsInfoContent(String newsInfoContent) {
		this.newsInfoContent = newsInfoContent;
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
	 * 获取管理员Id
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}
	
	/**
	 * 设置管理员Id
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	 * @param newsType the newsType to set
	 */
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	/**
	 * 获取文章状态
	 * @return the newsInfoState
	 */
	public int getNewsInfoState() {
		return newsInfoState;
	}
	
	/**
	 * 设置文章状态
	 * @param newsInfoState the newsInfoState to set
	 */
	public void setNewsInfoState(int newsInfoState) {
		this.newsInfoState = newsInfoState;
	}
	
	

}

