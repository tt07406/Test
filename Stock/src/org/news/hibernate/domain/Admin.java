package org.news.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminName;
	private String adminPass;
	private String adminInfo;
	private Set newsinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String adminName) {
		this.adminName = adminName;
	}

	/** full constructor */
	public Admin(String adminName, String adminPass, String adminInfo,
			Set newsinfos) {
		this.adminName = adminName;
		this.adminPass = adminPass;
		this.adminInfo = adminInfo;
		this.newsinfos = newsinfos;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPass() {
		return this.adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getAdminInfo() {
		return this.adminInfo;
	}

	public void setAdminInfo(String adminInfo) {
		this.adminInfo = adminInfo;
	}

	public Set getNewsinfos() {
		return this.newsinfos;
	}

	public void setNewsinfos(Set newsinfos) {
		this.newsinfos = newsinfos;
	}

}