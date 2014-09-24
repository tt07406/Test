/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：UserService
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service;

import org.mystock.model.Users;

/**
 * 会员服务类接口
 * @author tt
 * @version 14.6.18
 */
public interface UserService {

	/**
	 * 查找用户的身份证号和授权ID
	 * @param user
	 * @return 验证的操作结果
	 */
	public Users findLogin(Users user);
}
