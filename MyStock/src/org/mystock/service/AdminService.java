/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：AdminService
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.service;

import java.util.List;

import org.mystock.model.Admin;

/**
 * 管理员服务类接口
 * @author tt
 * @version 14.9.16
 */
public interface AdminService {

	/**
	 * 管理员登录验证
	 * @param user
	 * @return 验证的操作结果
	 */
	public boolean findLogin(Admin user);
	
	/**
	 * 添加管理员
	 * @param user 传入VO对象
	 * @return 操作是否成功
	 */
	public boolean addAdmin(Admin user);
	
	/**
	 * 批量删除管理员
	 * @param adminIds
	 * @return 是否成功
	 */
	public boolean deleteAdmins(int[] adminIds);
	
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return 是否成功
	 */
	public boolean updateAdmin(Admin admin);
	
	/**
	 * 查询所有的管理员信息
	 * @return 管理员集合
	 */
     public List<Admin> getAllAdmin();
     
     /**
      * 可通过Id来查找管理员的信息
      * @param adminId
      * @return
      */
     public Admin findAdminById(int adminId);
     
     /**
      * 可通过名称来查找管理员的信息
      * @param adminId
      * @return
      */
     public Admin findAdminById(String adminId);
     
     /**
  	 * 模糊查询管理员
  	 * @return 管理员集合
  	 */
       public List<Admin> getAdminByInfo(String keyword);
       
       /**
        * 查询含有关键字的管理员数量
        * @param keyword
        * @return 管理员数量
        */
       public long getCount(String keyword);

    /**
     * 查找管理员是否存在 
     * @param userName
     * @return
     */
	public boolean findAdminName(String userName);
}
