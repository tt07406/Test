/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������UserService
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service;

import org.mystock.model.Users;

/**
 * ��Ա������ӿ�
 * @author tt
 * @version 14.6.18
 */
public interface UserService {

	/**
	 * �����û������֤�ź���ȨID
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public Users findLogin(Users user);
}
