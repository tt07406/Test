/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������UserService
 * 
 * �������ڣ�2014-06-26
 */
package org.news.service.impl;

import java.util.List;

import org.news.dao.UsersHibernateDAO;
import org.news.model.Users;
import org.news.service.UserService;

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
	 * �û���¼��֤
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public boolean findLogin(Users user){
		return userDAO.findLogin(user);
	}
	
	/**
	 * ���ӻ�Ա
	 * @param user ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addUsers(Users user){
		if (findUserName(user.getUsersName())){//�ظ�����֤
			return false;
		}
		if (userDAO.findUsersById(user.getUsersId()) == null){//�����������
			return userDAO.addUser(user);
		}else{
			return false;
		}
		  
	}
	
	/**
	 * ����ɾ����Ա
	 * @param usersIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteUserss(int[] usersIds) {
		return userDAO.deleteUsers(usersIds);
	}
	
	/**
	 * �޸Ļ�Ա��Ϣ
	 * @param users
	 * @return �Ƿ�ɹ�
	 */
	public boolean updateUsers(Users users) {
		if (userDAO.updateUsers(users) == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * ��ѯ���еĻ�Ա��Ϣ
	 * @return ��Ա����
	 */
     public List<Users> getAllUsers(){
    	 return userDAO.getAllUsers();
     }
     
     /**
      * ��ͨ��Id�����һ�Ա����Ϣ
      * @param usersId
      * @return
      */
     public Users findUsersById(int usersId){
    	 return userDAO.findUsersById(usersId);
     }
     
     /**
      * ��ͨ�����������һ�Ա����Ϣ
      * @param usersName
      * @return
      */
     public Users findUsersById(String usersName){
    	 return userDAO.findUsersByName(usersName);
     }
     
     /**
  	 * ģ����ѯ��Ա
  	 * @return ��Ա����
  	 */
       public List<Users> getUsersByKey(String keyword){
    	   return userDAO.getUsersByKey(keyword);
       }
       
       /**
        * ��ѯ���йؼ��ֵĻ�Ա����
        * @param keyword
        * @return ��Ա����
        */
       public long getCount(String keyword){
    	   return userDAO.getCount(keyword);
       }
    
    /**
     * ģ����ѯ��Ա
     * @param keyword
     * @param currentPage ҳ��
     * @param linesize ÿҳ��С
     * @return ��Ա����
     */
    public List<Users> getAllUsers(String keyword, int currentPage, int linesize){
    	return userDAO.getAllUsers(keyword, currentPage, linesize);
    }

    /**
     * ��ѯ�û����Ƿ����
     * @param name
     * @return
     */
    public boolean findUserName(String name){
    	if (null == userDAO.findUsersByName(name)){
    		return false;
    	}else{
    		return true;
    	}
    }
}