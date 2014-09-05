/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AdminService
 * 
 * �������ڣ�2014-06-20
 */
package org.news.service;

import java.util.List;

import org.news.model.Admin;

/**
 * ����Ա������ӿ�
 * @author tt
 * @version 14.6.18
 */
public interface AdminService {

	/**
	 * ����Ա��¼��֤
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public boolean findLogin(Admin user);
	
	/**
	 * ��ӹ���Ա
	 * @param user ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addAdmin(Admin user);
	
	/**
	 * ����ɾ������Ա
	 * @param adminIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteAdmins(int[] adminIds);
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param admin
	 * @return �Ƿ�ɹ�
	 */
	public boolean updateAdmin(Admin admin);
	
	/**
	 * ��ѯ���еĹ���Ա��Ϣ
	 * @return ����Ա����
	 */
     public List<Admin> getAllAdmin();
     
     /**
      * ��ͨ��Id�����ҹ���Ա����Ϣ
      * @param adminId
      * @return
      */
     public Admin findAdminById(int adminId);
     
     /**
      * ��ͨ�����������ҹ���Ա����Ϣ
      * @param adminName
      * @return
      */
     public Admin findAdminById(String adminName);
     
     /**
  	 * ģ����ѯ����Ա
  	 * @return ����Ա����
  	 */
       public List<Admin> getAdminByInfo(String keyword);
       
       /**
        * ��ѯ���йؼ��ֵĹ���Ա����
        * @param keyword
        * @return ����Ա����
        */
       public long getCount(String keyword);

    /**
     * ���ҹ���Ա�Ƿ���� 
     * @param userName
     * @return
     */
	public boolean findAdminName(String userName);
}
