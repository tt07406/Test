/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������PermissionService
 * 
 * �������ڣ�2014-09-23
 */
package org.news.service;

import java.util.List;

import org.news.model.Permission;

/**
 * Ȩ�޷�����ӿ�
 * @author tt
 * @version 14.8.18
 */
public interface PermissionService {

	/**
	 * ���Ȩ��
	 * @param permission ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addPermission(Permission permission);
	
	/**
     * ��ͨ��Id������Ȩ�޵���Ϣ
     * @param permissionId
     * @return
     */
    public Permission findPermissionById(int permissionId);
    
    /**
	 * ����ɾ��Ȩ��
	 * @param permissionIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deletePermissions(int[] permissionIds);
	
	/**
	 * �޸�Ȩ����Ϣ
	 * @param permission
	 * @return Ȩ��
	 */
	public boolean updatePermissions(Permission permission);
	
	/**
	 * ��ѯ���е�Ȩ����Ϣ
	 * @return Ȩ�޼���
	 */
	public List<Permission> getAllPermissions();
}
