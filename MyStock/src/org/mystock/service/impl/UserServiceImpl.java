/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������UserService
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.service.impl;


import org.mystock.dao.UsersHibernateDAO;
import org.mystock.model.Users;
import org.mystock.service.UserService;

/**
 * ��Ա������
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
	 * �����û������֤�ź���ȨID
	 * @param user
	 * @return ��֤�Ĳ������
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
