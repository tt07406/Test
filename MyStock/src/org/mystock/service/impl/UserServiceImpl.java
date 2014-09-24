/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：UserService
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service.impl;


import org.mystock.dao.UsersHibernateDAO;
import org.mystock.model.Users;
import org.mystock.service.UserService;

/**
 * 会员服务类
 * @author tt
 * @version 14.6.18
 */
public class UserServiceImpl implements UserService{

	private UsersHibernateDAO userDAO;
	
	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UsersHibernateDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * 查找用户的身份证号和授权ID
	 * @param user
	 * @return 验证的操作结果
	 */
	public Users findLogin(Users user){
		Users result = this.userDAO.findLogin(user);
		if (result != null ){
			if (result.getUserIdNum().isEmpty()||result.getUsersInfo().isEmpty()){
				return null;
			}
		}
		
		return result;
	}
}
