/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AdminService
 * 
 * �������ڣ�2014-06-20
 */
package org.news.service.impl;

import java.util.List;

import org.news.dao.AdminHibernateDAO;
import org.news.model.Admin;
import org.news.service.AdminService;

/**
 * ����Ա������
 * @author tt
 * @version 14.6.18
 */
public class AdminServiceImpl implements AdminService{

	private AdminHibernateDAO adminDAO;
	
	/**
	 * @param adminDAO the adminDAO to set
	 */
	public void setAdminDAO(AdminHibernateDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	/**
	 * ����Ա��¼��֤
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public boolean findLogin(Admin user){
		return adminDAO.findLogin(user);
	}
	
	/**
	 * ��ӹ���Ա
	 * @param user ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addAdmin(Admin user){
		if (findAdminName(user.getAdminName())){//�ظ�����֤
			return false;
		}
		if (adminDAO.findAdminById(user.getAdminId()) == null){//�����������
			return adminDAO.addAdmin(user);
		}else{
			return false;
		}
		  
	}
	
	/**
	 * ����ɾ������Ա
	 * @param adminIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteAdmins(int[] adminIds) {
		return adminDAO.deleteAdmins(adminIds);
	}
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param admin
	 * @return �Ƿ�ɹ�
	 */
	public boolean updateAdmin(Admin admin) {
		if (adminDAO.updateAdmin(admin) == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * ��ѯ���еĹ���Ա��Ϣ
	 * @return ����Ա����
	 */
     public List<Admin> getAllAdmin(){
    	 return adminDAO.getAllAdmin();
     }
     
     /**
      * ��ͨ��Id�����ҹ���Ա����Ϣ
      * @param adminId
      * @return
      */
     public Admin findAdminById(int adminId){
    	 return adminDAO.findAdminById(adminId);
     }
     
     /**
      * ��ͨ�����������ҹ���Ա����Ϣ
      * @param adminId
      * @return
      */
     public Admin findAdminById(String adminId){
    	 return adminDAO.findAdminByName(adminId);
     }
     
     
     /**
  	 * ģ����ѯ����Ա
  	 * @return ����Ա����
  	 */
       public List<Admin> getAdminByInfo(String keyword){
    	   return adminDAO.getAdminByInfo(keyword);
       }
       
       /**
        * ��ѯ���йؼ��ֵĹ���Ա����
        * @param keyword
        * @return ����Ա����
        */
       public long getCount(String keyword){
    	   return adminDAO.getCount(keyword);
       }

    /**
     * ���ҹ���Ա�Ƿ���� 
     * @param userName
     * @return
     */
	public boolean findAdminName(String userName) {
		if (adminDAO.findAdminByName(userName) != null){
			return true;
		}
		return false;
	}
}
