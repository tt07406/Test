package org.news.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer usersId;
	private String usersName;
	private String usersPass;
	private String usersEmail;
	private String usersInfo;
	private String realName;
	private String sex;
	private String phone;
	private String idNumber;
	private Set replyses = new HashSet(0);
	private Set leavemessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String usersName) {
		this.usersName = usersName;
	}

	/** full constructor */
	public Users(String usersName, String usersPass, String usersEmail,
			String usersInfo, String realName, String sex, String phone,
			String idNumber, Set replyses, Set leavemessages) {
		this.usersName = usersName;
		this.usersPass = usersPass;
		this.usersEmail = usersEmail;
		this.usersInfo = usersInfo;
		this.realName = realName;
		this.sex = sex;
		this.phone = phone;
		this.idNumber = idNumber;
		this.replyses = replyses;
		this.leavemessages = leavemessages;
	}

	// Property accessors

	public Integer getUsersId() {
		return this.usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUsersName() {
		return this.usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersPass() {
		return this.usersPass;
	}

	public void setUsersPass(String usersPass) {
		this.usersPass = usersPass;
	}

	public String getUsersEmail() {
		return this.usersEmail;
	}

	public void setUsersEmail(String usersEmail) {
		this.usersEmail = usersEmail;
	}

	public String getUsersInfo() {
		return this.usersInfo;
	}

	public void setUsersInfo(String usersInfo) {
		this.usersInfo = usersInfo;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Set getReplyses() {
		return this.replyses;
	}

	public void setReplyses(Set replyses) {
		this.replyses = replyses;
	}

	public Set getLeavemessages() {
		return this.leavemessages;
	}

	public void setLeavemessages(Set leavemessages) {
		this.leavemessages = leavemessages;
	}

}