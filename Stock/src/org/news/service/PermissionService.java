/*
 * 系统名称：新闻发布系统
 * 
 * 类名：PermissionService
 * 
 * 创建日期：2014-09-23
 */
package org.news.service;

import java.util.List;

import org.news.model.Permission;

/**
 * 权限服务类接口
 * @author tt
 * @version 14.8.18
 */
public interface PermissionService {

	/**
	 * 添加权限
	 * @param permission 传入VO对象
	 * @return 操作是否成功
	 */
	public boolean addPermission(Permission permission);
	
	/**
     * 可通过Id来查找权限的信息
     * @param permissionId
     * @return
     */
    public Permission findPermissionById(int permissionId);
    
    /**
	 * 批量删除权限
	 * @param permissionIds
	 * @return 是否成功
	 */
	public boolean deletePermissions(int[] permissionIds);
	
	/**
	 * 修改权限信息
	 * @param permission
	 * @return 权限
	 */
	public boolean updatePermissions(Permission permission);
	
	/**
	 * 查询所有的权限信息
	 * @return 权限集合
	 */
	public List<Permission> getAllPermissions();
}
