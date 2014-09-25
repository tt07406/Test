/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsInfo
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 文章信息的PO类
 * 
 * @author tt
 * @version 14.9.16
 */
@Entity(name="newsinfo")
public class NewsInfo {

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private int newsInfoId;				//文章Id
	private String newsInfoTitle;		//文章标题
	private String newsInfoContent;		//文章内容
	private Date newsInfoTime;		//创建时间
	private String newsAuthor;			//文章作者
	private String newsType;				//文章分类Id
	private String adminName;			//创建者
	
	public NewsInfo() {
	}
	
	

	/**
	 * 初始化函数
	 * @param newsInfoId
	 * @param newsInfoTitle
	 * @param newsInfoContent
	 * @param newsInfoTime
	 * @param newsAuthor
	 * @param newsType
	 * @param adminName
	 */
	public NewsInfo(int newsInfoId, String newsInfoTitle,
			String newsInfoContent, Date newsInfoTime, String newsAuthor,
			String newsType, String adminName) {
		super();
		this.newsInfoId = newsInfoId;
		this.newsInfoTitle = newsInfoTitle;
		this.newsInfoContent = newsInfoContent;
		this.newsInfoTime = newsInfoTime;
		this.newsAuthor = newsAuthor;
		this.newsType = newsType;
		this.adminName = adminName;
	}



	public int getNewsInfoId() {
		return newsInfoId;
	}

	public void setNewsInfoId(int newsInfoId) {
		this.newsInfoId = newsInfoId;
	}

	public String getNewsInfoTitle() {
		return newsInfoTitle;
	}

	public void setNewsInfoTitle(String newsInfoTitle) {
		this.newsInfoTitle = newsInfoTitle;
	}

	public String getNewsInfoContent() {
		return newsInfoContent;
	}

	public void setNewsInfoContent(String newsInfoContent) {
		this.newsInfoContent = newsInfoContent;
	}

	public Date getNewsInfoTime() {
		return newsInfoTime;
	}

	public void setNewsInfoTime(Date newsInfoTime) {
		this.newsInfoTime = newsInfoTime;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsType() {
		return newsType;
	}

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
