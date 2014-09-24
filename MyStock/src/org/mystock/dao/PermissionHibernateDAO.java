/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：PermissionHibernateDAO
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.dao;

import java.util.List;

import org.mystock.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 权限信息的DAO
 * 
 * @author tt
 * @version 14.9.16
 */
public class PermissionHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(PermissionHibernateDAO.class);
	
	/**
	 * 根据身份证号和授权ID查询相关权限
	 * @return 权限集合
	 */
     @SuppressWarnings("unchecked")
	public List<Permission> getAllPermissions(String idNumber, String authenticationId){
    	 try {
  			String queryString = "from permission where idNumber = ? and authenticationId = ? order by permissionId";
  			return (List<Permission>)getHibernateTemplate().find(queryString, idNumber, authenticationId);
  		} catch (RuntimeException re) {
  			log.error("find all failed", re);
  			throw re;
  		}
     }
}
