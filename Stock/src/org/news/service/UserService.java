/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������UserService
 * 
 * �������ڣ�2014-06-26
 */
package org.news.service;

import java.util.List;

import org.news.model.Users;

/**
 * ��Ա������ӿ�
 * @author tt
 * @version 14.6.18
 */
public interface UserService {

	/**
	 * �û���¼��֤
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public boolean findLogin(Users user);
	
	/**
	 * ��ӻ�Ա
	 * @param user ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addUsers(Users user);
	
	/**
	 * ����ɾ����Ա
	 * @param usersIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteUserss(int[] usersIds);
	
	/**
	 * �޸Ļ�Ա��Ϣ
	 * @param users
	 * @return �Ƿ�ɹ�
	 */
	public boolean updateUsers(Users users);
	
	/**
	 * ��ѯ���еĻ�Ա��Ϣ
	 * @return ��Ա����
	 */
     public List<Users> getAllUsers();
     
     /**
      * ��ͨ��Id�����һ�Ա����Ϣ
      * @param usersId
      * @return
      */
     public Users findUsersById(int usersId);
     
     /**
      * ��ͨ�����������һ�Ա����Ϣ
      * @param usersName
      * @return
      */
     public Users findUsersById(String usersName);
     
     /**
  	 * ģ����ѯ��Ա
  	 * @return ��Ա����
  	 */
       public List<Users> getUsersByKey(String keyword);
       
       /**
        * ��ѯ���йؼ��ֵĻ�Ա����
        * @param keyword
        * @return ��Ա����
        */
       public long getCount(String keyword);
    
    /**
     * ģ����ѯ��Ա
     * @param keyword
     * @param currentPage ҳ��
     * @param linesize ÿҳ��С
     * @return ��Ա����
     */
    public List<Users> getAllUsers(String keyword, int currentPage, int linesize);

    /**
     * ��ѯ�û����Ƿ����
     * @param name
     * @return
     */
    public boolean findUserName(String name);
}
