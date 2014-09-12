package org.news.hibernate.domain;

import java.sql.Timestamp;

/**
 * Replys entity. @author MyEclipse Persistence Tools
 */

public class Replys implements java.io.Serializable {

	// Fields

	private Integer replytId;
	private Users users;
	private Newsinfo newsinfo;
	private String replytContent;
	private Timestamp replytTime;

	// Constructors

	/** default constructor */
	public Replys() {
	}

	/** full constructor */
	public Replys(Users users, Newsinfo newsinfo, String replytContent,
			Timestamp replytTime) {
		this.users = users;
		this.newsinfo = newsinfo;
		this.replytContent = replytContent;
		this.replytTime = replytTime;
	}

	// Property accessors

	public Integer getReplytId() {
		return this.replytId;
	}

	public void setReplytId(Integer replytId) {
		this.replytId = replytId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Newsinfo getNewsinfo() {
		return this.newsinfo;
	}

	public void setNewsinfo(Newsinfo newsinfo) {
		this.newsinfo = newsinfo;
	}

	public String getReplytContent() {
		return this.replytContent;
	}

	public void setReplytContent(String replytContent) {
		this.replytContent = replytContent;
	}

	public Timestamp getReplytTime() {
		return this.replytTime;
	}

	public void setReplytTime(Timestamp replytTime) {
		this.replytTime = replytTime;
	}

}