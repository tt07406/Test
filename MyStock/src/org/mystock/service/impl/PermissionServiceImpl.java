/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������PermissionServiceImpl
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service.impl;

import java.util.List;

import org.mystock.dao.PermissionHibernateDAO;
import org.mystock.model.Permission;
import org.mystock.service.PermissionService;

/**
 * Ȩ�޷�����
 * @author tt
 * @version 14.8.18
 */
public class PermissionServiceImpl implements PermissionService {
	
	private PermissionHibernateDAO permissionDao;

	public void setPermissionDao(PermissionHibernateDAO permissionDao) {
		this.permissionDao = permissionDao;
	}

	/**
	 * �������֤�ź���ȨID��ȡȨ�޼���
	 * @param idNumber
	 * @param authenticationId
	 * @return Ȩ�޼���
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
