/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������PermissionService
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service;

/**
 * Ȩ�޷�����ӿ�
 * @author tt
 * @version 14.9.16
 */
public interface PermissionService {

	/**
	 * �������֤�ź���ȨID��ȡȨ�޼���
	 * @param idNumber
	 * @param authenticationId
	 * @return Ȩ�޼���
	 */
	public int getPermissionLevel(String idNumber, String authenticationId);
}
