/*
 * 系统名称：新闻发布系统
 * 
 * 类名：AdminDAOHibernate
 * 
 * 创建日期：2014-09-11
 */
package org.news.dao;

import java.util.List;

import org.news.model.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 管理员信息的DAO
 * 
 * @author tt
 * @version 14.8.18
 */
public class AdminHibernateDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AdminHibernateDAO.class);

	/**
	 * 用户登录验证
	 * @param user
	 * @return 验证的操作结果
	 */
	public boolean findLogin(Admin user){
		String adminName = user.getAdminName();
		String adminPass = user.getAdminPass();
		
		//取得ID数，且大于零
		long result = (Long)getHibernateTemplate().find("select count(a.adminId) from Admin a where a.adminName = ? and a.adminPass = ?", adminName,adminPass).get(0);
		
		if (result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 添加管理员
	 * @param user 传入VO对象
	 * @return 操作是否成功
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
     * 可通过Id来查找管理员的信息
     * @param adminId
     * @return
     */
    public Admin findAdminById(int adminId){
    	return (Admin)getHibernateTemplate().get(Admin.class, adminId); 
    }
	
	/**
	 * 批量删除管理员
	 * @param adminIds
	 * @return 是否成功
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
	 * 修改管理员信息
	 * @param admin
	 * @return 管理员
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
	 * 查询所有的管理员信息
	 * @return 管理员集合
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
      * 可通过名称来查找管理员的信息
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
  			re.printStackTrace();
  		}
  		return null;
     }
     
     /**
  	 * 模糊查询管理员
  	 * @return 管理员集合
  	 */
      @SuppressWarnings("unchecked")
	 public List<Admin> getAdminByInfo(String keyword){
    	   try {
    			String queryString = "from Admin a where a.adminInfo like ?";
    			return (List<Admin>)getHibernateTemplate().find(queryString,'%' + keyword + '%');
    		} catch (RuntimeException re) {
    			log.error("find AdminByInfo failed", re);
    			throw re;
    		}
       }
      
      /**
       * 查询含有关键字的管理员数量
       * @param keyword
       * @return 管理员数量
       */
      public long getCount(String keyword){
    	  return (Long)getHibernateTemplate().find("select count(a.adminId) " +
    	  		"from Admin a where a.adminInfo like ?",'%' + keyword + '%').get(0);
      }
}
