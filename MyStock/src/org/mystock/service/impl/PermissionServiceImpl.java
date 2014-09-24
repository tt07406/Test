/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：PermissionServiceImpl
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service.impl;

import java.util.List;

import org.mystock.dao.PermissionHibernateDAO;
import org.mystock.model.Permission;
import org.mystock.service.PermissionService;

/**
 * 权限服务类
 * @author tt
 * @version 14.8.18
 */
public class PermissionServiceImpl implements PermissionService {
	
	private PermissionHibernateDAO permissionDao;

	public void setPermissionDao(PermissionHibernateDAO permissionDao) {
		this.permissionDao = permissionDao;
	}

	/**
	 * 根据身份证号和授权ID获取权限级别
	 * @param idNumber
	 * @param authenticationId
	 * @return 权限级别
	 */
	public int getPermissionLevel(String idNumber, String authenticationId){
		List<Permission> result = this.permissionDao.getAllPermissions(idNumber, authenticationId);
		if (result.size() > 0){
			return result.get(0).getPermissionLevel();
		}else{
			return 0;
		}
	}
}
