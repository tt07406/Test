/*
 * 系统名称：新闻发布系统
 * 
 * 类名：PermissionHibernateDAO
 * 
 * 创建日期：2014-09-23
 */
package org.news.dao;

import java.util.List;

import org.news.model.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 权限信息的DAO
 * 
 * @author tt
 * @version 14.8.18
 */
public class PermissionHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(PermissionHibernateDAO.class);
	
	/**
	 * 添加权限
	 * @param permission 传入VO对象
	 * @return 操作是否成功
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
     * 可通过Id来查找权限的信息
     * @param permissionId
     * @return
     */
    public Permission findPermissionById(int permissionId){
    	return (Permission)getHibernateTemplate().get(Permission.class, permissionId); 
    }
    
    /**
	 * 批量删除权限
	 * @param permissionIds
	 * @return 是否成功
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
	 * 修改权限信息
	 * @param permission
	 * @return 权限
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
	 * 查询所有的权限信息
	 * @return 权限集合
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
