/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AdminDAOHibernate
 * 
 * �������ڣ�2014-09-11
 */
package org.news.dao;

import java.util.List;

import org.news.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ����Ա��Ϣ��DAO
 * 
 * @author tt
 * @version 14.8.18
 */
public class AdminHibernateDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AdminHibernateDAO.class);

	/**
	 * �û���¼��֤
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public boolean findLogin(Admin user){
		String adminName = user.getAdminName();
		String adminPass = user.getAdminPass();
		
		//ȡ��ID�����Ҵ�����
		long result = (Long)getHibernateTemplate().find("select count(a.adminId) from Admin a where a.adminName = ? and a.adminPass = ?", adminName,adminPass).get(0);
		
		if (result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ���ӹ���Ա
	 * @param user ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addAdmin(Admin user){
		try {
			getHibernateTemplate().save(user);
			log.debug("save successful");
			return true;
		} catch (Exception e) {
			log.error("save failed", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
     * ��ͨ��Id�����ҹ���Ա����Ϣ
     * @param adminId
     * @return
     */
    public Admin findAdminById(int adminId){
    	return (Admin)getHibernateTemplate().get(Admin.class, adminId); 
    }
	
	/**
	 * ����ɾ������Ա
	 * @param adminIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteAdmins(int[] adminIds) {
		for (int i = 0; i < adminIds.length; i++) {
			try {
				getHibernateTemplate().delete(findAdminById(adminIds[i]));
				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param admin
	 * @return ����Ա
	 */
	public Admin updateAdmin(Admin admin) {
		try{
			getHibernateTemplate().update(admin);
			log.debug("update successful");
			return admin;
		}catch (Exception e) {
			log.error("update failed", e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ѯ���еĹ���Ա��Ϣ
	 * @return ����Ա����
	 */
     @SuppressWarnings("unchecked")
	public List<Admin> getAllAdmin(){
    	 try {
 			String queryString = "from Admin";
 			return (List<Admin>)getHibernateTemplate().find(queryString);
 		} catch (RuntimeException re) {
 			log.error("find all failed", re);
 			throw re;
 		}
     }
     
     /**
      * ��ͨ�����������ҹ���Ա����Ϣ
      * @param adminName
      * @return
      */
     @SuppressWarnings("unchecked")
	public Admin findAdminByName(String adminName){
    	 try {
  			String queryString = "from Admin a where a.adminName = ?";
  			List<Admin> result = (List<Admin>)getHibernateTemplate().find(queryString,adminName);
  			return result.get(0);
  		} catch (RuntimeException re) {
  			log.error("find name failed", re);
  			throw re;
  		}
     }
     
     /**
  	 * ģ����ѯ����Ա
  	 * @return ����Ա����
  	 */
      @SuppressWarnings("unchecked")
	 public List<Admin> getAdminByInfo(String keyword){
    	   try {
    			String queryString = "from Admin a where a.adminInfo like ?";
    			return (List<Admin>)getHibernateTemplate().find(queryString,keyword);
    		} catch (RuntimeException re) {
    			log.error("find AdminByInfo failed", re);
    			throw re;
    		}
       }
      
      /**
       * ��ѯ���йؼ��ֵĹ���Ա����
       * @param keyword
       * @return ����Ա����
       */
      public long getCount(String keyword){
    	  return (Long)getHibernateTemplate().find("select count(a.adminId) " +
    	  		"from Admin a where a.adminInfo like ?",keyword).get(0);
      }
}