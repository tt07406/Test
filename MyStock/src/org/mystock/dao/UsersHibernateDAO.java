/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：UsersHibernateDAO
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.dao;

import java.util.List;

import org.mystock.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户信息DAO
 * @author tt
 * @version 14.9.16
 */
public class UsersHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(UsersHibernateDAO.class);
	
	/**
	 * 查找用户的身份证号和授权ID
	 * @param user
	 * @return 验证的操作结果
	 */
	@SuppressWarnings("unchecked")
	public Users findLogin(Users user){
		String userName = user.getUsersName();
		String userPass = user.getUsersPass();
			
		 try {
	  			String queryString = "from users where usersName = ? and usersPass = ?";
	  			List<Users> result = (List<Users>)getHibernateTemplate().find(queryString, userName, userPass);
	  			
	  			if (result.size() > 0){
	  				return result.get(0);
	  			}else{
	  				return null;
	  			}
	  		} catch (RuntimeException re) {
	  			log.error("find all failed", re);
	  			throw re;
	  		}
	}
	
}
