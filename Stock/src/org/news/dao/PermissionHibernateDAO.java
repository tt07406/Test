/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������PermissionHibernateDAO
 * 
 * �������ڣ�2014-09-23
 */
package org.news.dao;

import java.util.List;

import org.news.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Ȩ����Ϣ��DAO
 * 
 * @author tt
 * @version 14.8.18
 */
public class PermissionHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(PermissionHibernateDAO.class);
	
	/**
	 * ���Ȩ��
	 * @param permission ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	@SuppressWarnings("finally")
	public boolean addPermission(Permission permission){
		boolean result = false;
		try {
			getHibernateTemplate().save(permission);
			log.debug("save successful");
			result = true;
		} catch (RuntimeException e) {
			log.error("save failed", e);
			throw e;
		}finally{
			return result;
		}
	}
	
	/**
     * ��ͨ��Id������Ȩ�޵���Ϣ
     * @param permissionId
     * @return
     */
    public Permission findPermissionById(int permissionId){
    	return (Permission)getHibernateTemplate().get(Permission.class, permissionId); 
    }
    
    /**
	 * ����ɾ��Ȩ��
	 * @param permissionIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deletePermissions(int[] permissionIds) {
		boolean result = true;
		for (int i = 0; i < permissionIds.length; i++) {
			try {
				getHibernateTemplate().delete(findPermissionById(permissionIds[i]));
				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				result = false;
				throw re;
			}
		}
		return result;
	}
	
	/**
	 * �޸�Ȩ����Ϣ
	 * @param permission
	 * @return Ȩ��
	 */
	@SuppressWarnings("finally")
	public Permission updatePermissions(Permission permission) {
		try{
			getHibernateTemplate().update(permission);
			log.debug("update successful");
		}catch (RuntimeException e) {
			log.error("update failed", e);
			permission = null;
			throw e;
		}finally{
			return permission;
		}
	}
	
	/**
	 * ��ѯ���е�Ȩ����Ϣ
	 * @return Ȩ�޼���
	 */
     @SuppressWarnings("unchecked")
	public List<Permission> getAllPermissions(){
    	 try {
  			String queryString = "from permission order by permissionId";
  			return (List<Permission>)getHibernateTemplate().find(queryString);
  		} catch (RuntimeException re) {
  			log.error("find all failed", re);
  			throw re;
  		}
     }
}
