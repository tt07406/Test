package org.news.hibernate.domain;

import java.sql.Timestamp;

/**
 * Leavemessage entity. @author MyEclipse Persistence Tools
 */

public class Leavemessage implements java.io.Serializable {

	// Fields

	private Integer leaveMessageId;
	private Users users;
	private String leaveMessageContent;
	private Timestamp leaveMessageTime;

	// Constructors

	/** default constructor */
	public Leavemessage() {
	}

	/** full constructor */
	public Leavemessage(Users users, String leaveMessageContent,
			Timestamp leaveMessageTime) {
		this.users = users;
		this.leaveMessageContent = leaveMessageContent;
		this.leaveMessageTime = leaveMessageTime;
	}

	// Property accessors

	public Integer getLeaveMessageId() {
		return this.leaveMessageId;
	}

	public void setLeaveMessageId(Integer leaveMessageId) {
		this.leaveMessageId = leaveMessageId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getLeaveMessageContent() {
		return this.leaveMessageContent;
	}

	public void setLeaveMessageContent(String leaveMessageContent) {
		this.leaveMessageContent = leaveMessageContent;
	}

	public Timestamp getLeaveMessageTime() {
		return this.leaveMessageTime;
	}

	public void setLeaveMessageTime(Timestamp leaveMessageTime) {
		this.leaveMessageTime = leaveMessageTime;
	}

}