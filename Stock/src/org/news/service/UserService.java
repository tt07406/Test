/*
 * 系统名称：新闻发布系统
 * 
 * 类名：UserService
 * 
 * 创建日期：2014-06-26
 */
package org.news.service;

import java.util.List;

import org.news.model.Users;

/**
 * 会员服务类接口
 * @author tt
 * @version 14.6.18
 */
public interface UserService {

	/**
	 * 用户登录验证
	 * @param user
	 * @return 验证的操作结果
	 */
	public boolean findLogin(Users user);
	
	/**
	 * 添加会员
	 * @param user 传入VO对象
	 * @return 操作是否成功
	 */
	public boolean addUsers(Users user);
	
	/**
	 * 批量删除会员
	 * @param usersIds
	 * @return 是否成功
	 */
	public boolean deleteUserss(int[] usersIds);
	
	/**
	 * 修改会员信息
	 * @param users
	 * @return 是否成功
	 */
	public boolean updateUsers(Users users);
	
	/**
	 * 查询所有的会员信息
	 * @return 会员集合
	 */
     public List<Users> getAllUsers();
     
     /**
      * 可通过Id来查找会员的信息
      * @param usersId
      * @return
      */
     public Users findUsersById(int usersId);
     
     /**
      * 可通过名称来查找会员的信息
      * @param usersName
      * @return
      */
     public Users findUsersById(String usersName);
     
     /**
  	 * 模糊查询会员
  	 * @return 会员集合
  	 */
       public List<Users> getUsersByKey(String keyword);
       
       /**
        * 查询含有关键字的会员数量
        * @param keyword
        * @return 会员数量
        */
       public long getCount(String keyword);
    
    /**
     * 模糊查询会员
     * @param keyword
     * @param currentPage 页数
     * @param linesize 每页大小
     * @return 会员集合
     */
    public List<Users> getAllUsers(String keyword, int currentPage, int linesize);

    /**
     * 查询用户名是否存在
     * @param name
     * @return
     */
    public boolean findUserName(String name);
}
