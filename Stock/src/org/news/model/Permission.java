/*
 * 系统名称：新闻发布系统
 * 
 * 类名：Permission
 * 
 * 创建日期：2014-09-23
 */
package org.news.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;



/**
 * 权限信息PO
 * @author tt
 * @version 14.8.18
 */
@Entity(name="permission")
public class Permission {

	@Id
	@GeneratedValue(generator="generator")
	@GenericGenerator(name="generator",strategy="increment")
	private int permissionId;//权限ID
	private String idNumber;//身份证号
	private String authenticationId;//授权ID
	private int permissionLevel;//权限等级
	private String cmt;//备注
	
	public Permission(){};
	
	
	
	/**
	 * 初始化函数
	 * @param permissionId
	 * @param idNumber
	 * @param authenticationId
	 * @param permissionLevel
	 * @param cmt
	 */
	public Permission(int permissionId, String idNumber,
			String authenticationId, int permissionLevel, String cmt) {
		super();
		this.permissionId = permissionId;
		this.idNumber = idNumber;
		this.authenticationId = authenticationId;
		this.permissionLevel = permissionLevel;
		this.cmt = cmt;
	}



	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getAuthenticationId() {
		return authenticationId;
	}
	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}
	public int getPermissionLevel() {
		return permissionLevel;
	}
	public void setPermissionLevel(int permissionLevel) {
		this.permissionLevel = permissionLevel;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	
	
}
