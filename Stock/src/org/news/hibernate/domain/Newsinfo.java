package org.news.hibernate.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Newsinfo entity. @author MyEclipse Persistence Tools
 */

public class Newsinfo implements java.io.Serializable {

	// Fields

	private Integer newsInfoId;
	private Admin admin;
	private String newsInfoTitle;
	private String newsInfoDescribe;
	private String newsInfoContent;
	private Timestamp newsInfoTime;
	private String newsAuthor;
	private String newsType;
	private Integer newsInfoState;
	private Set replyses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Newsinfo() {
	}

	/** full constructor */
	public Newsinfo(Admin admin, String newsInfoTitle, String newsInfoDescribe,
			String newsInfoContent, Timestamp newsInfoTime, String newsAuthor,
			String newsType, Integer newsInfoState, Set replyses) {
		this.admin = admin;
		this.newsInfoTitle = newsInfoTitle;
		this.newsInfoDescribe = newsInfoDescribe;
		this.newsInfoContent = newsInfoContent;
		this.newsInfoTime = newsInfoTime;
		this.newsAuthor = newsAuthor;
		this.newsType = newsType;
		this.newsInfoState = newsInfoState;
		this.replyses = replyses;
	}

	// Property accessors

	public Integer getNewsInfoId() {
		return this.newsInfoId;
	}

	public void setNewsInfoId(Integer newsInfoId) {
		this.newsInfoId = newsInfoId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNewsInfoTitle() {
		return this.newsInfoTitle;
	}

	public void setNewsInfoTitle(String newsInfoTitle) {
		this.newsInfoTitle = newsInfoTitle;
	}

	public String getNewsInfoDescribe() {
		return this.newsInfoDescribe;
	}

	public void setNewsInfoDescribe(String newsInfoDescribe) {
		this.newsInfoDescribe = newsInfoDescribe;
	}

	public String getNewsInfoContent() {
		return this.newsInfoContent;
	}

	public void setNewsInfoContent(String newsInfoContent) {
		this.newsInfoContent = newsInfoContent;
	}

	public Timestamp getNewsInfoTime() {
		return this.newsInfoTime;
	}

	public void setNewsInfoTime(Timestamp newsInfoTime) {
		this.newsInfoTime = newsInfoTime;
	}

	public String getNewsAuthor() {
		return this.newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsType() {
		return this.newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}

	public Integer getNewsInfoState() {
		return this.newsInfoState;
	}

	public void setNewsInfoState(Integer newsInfoState) {
		this.newsInfoState = newsInfoState;
	}

	public Set getReplyses() {
		return this.replyses;
	}

	public void setReplyses(Set replyses) {
		this.replyses = replyses;
	}

}