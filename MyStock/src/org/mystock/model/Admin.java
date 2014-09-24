/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：Admin
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.model;

/**
 * 管理员VO
 * 
 * @author tt
 * @version 14.9.16
 */
public class Admin {

	private String adminName;	//管理员用户
	private String adminPass;	//管理员密码
	private int adminLevel;		//管理员权限等级
	
	
	/**
	 * 初始化函数
	 * @param adminName
	 * @param adminPass
	 * @param adminLevel
	 */
	public Admin(String adminName, String adminPass, int adminLevel) {
		super();
		this.adminName = adminName;
		this.adminPass = adminPass;
		this.adminLevel = adminLevel;
	}
	
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	/**
	 * @return the adminPass
	 */
	public String getAdminPass() {
		return adminPass;
	}
	/**
	 * @param adminPass the adminPass to set
	 */
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	/**
	 * @return the adminLevel
	 */
	public int getAdminLevel() {
		return adminLevel;
	}
	/**
	 * @param adminLevel the adminLevel to set
	 */
	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}
}
