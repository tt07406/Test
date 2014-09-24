/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：PermissionService
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service;

/**
 * 权限服务类接口
 * @author tt
 * @version 14.9.16
 */
public interface PermissionService {

	/**
	 * 根据身份证号和授权ID获取权限级别
	 * @param idNumber
	 * @param authenticationId
	 * @return 权限级别
	 */
	public int getPermissionLevel(String idNumber, String authenticationId);
}
