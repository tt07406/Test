/*
 * 系统名称：新闻发布系统
 * 
 * 类名：PermissionServiceImpl
 * 
 * 创建日期：2014-09-23
 */
package org.news.service.impl;

import java.util.List;

import org.news.dao.PermissionHibernateDAO;
import org.news.model.Permission;
import org.news.service.PermissionService;

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

	@Override
	public boolean addPermission(Permission permission) {
		
		if (this.permissionDao.findPermissionById(permission.getPermissionId())==null){
			return this.permissionDao.addPermission(permission);
		}else{
			return false;
		}
		
	}

	@Override
	public boolean deletePermissions(int[] permissionIds) {
		return this.permissionDao.deletePermissions(permissionIds);
	}

	@Override
	public Permission findPermissionById(int permissionId) {
		return this.permissionDao.findPermissionById(permissionId);
	}

	@Override
	public List<Permission> getAllPermissions() {
		return this.permissionDao.getAllPermissions();
	}

	@Override
	public boolean updatePermissions(Permission permission) {
		if (this.permissionDao.updatePermissions(permission) == null){
			return false;
		}else{
			return true;
		}
	}

}
