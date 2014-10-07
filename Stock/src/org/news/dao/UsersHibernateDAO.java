/*
 * 系统名称：新闻发布系统
 * 
 * 类名：UsersHibernateDAO
 * 
 * 创建日期：2014-09-12
 */
package org.news.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.news.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户信息DAO
 * @author tt
 * @version 14.8.18
 */
public class UsersHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(UsersHibernateDAO.class);
	
	/**
	 * 用户登录验证,用户名或邮箱登录
	 * @param user
	 * @return 验证的操作结果
	 */
	public boolean findLogin(Users user){
		String userName = user.getUsersName();
		String userPass = user.getUsersPass();
		
		//取得ID数，且大于零
		long result = (Long)getHibernateTemplate().find("select count(usersId) from users where usersName = ? and usersPass = ?", userName,userPass).get(0);
		
		if (result > 0){
			return true;
		}else{
			result = (Long)getHibernateTemplate().find("select count(usersId) from users where usersEmail = ? and usersPass = ?", userName,userPass).get(0);
			if (result > 0){
				return true;
			}else{
				return false;
			}
		}
	}
	
	/**
	 * 添加会员
	 * @param user 传入VO对象
	 * @return 操作是否成功
	 */
	@SuppressWarnings("finally")
	public boolean addUser(Users user){
		boolean result = false;
		try {
			getHibernateTemplate().save(user);
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
     * 可通过Id来查找会员的信息
     * @param usersId
     * @return
     */
    public Users findUsersById(int usersId){
    	return (Users)getHibernateTemplate().get(Users.class, usersId); 
    }
    
	/**
	 * 批量删除会员
	 * @param userIds
	 * @return 是否成功
	 */
	public boolean deleteUsers(int[] userIds) {
		boolean result = true;
		for (int i = 0; i < userIds.length; i++) {
			try {
				getHibernateTemplate().delete(findUsersById(userIds[i]));
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
	 * 修改会员信息
	 * @param users
	 * @return 管理员
	 */
	@SuppressWarnings("finally")
	public Users updateUsers(Users user) {
		try{
			getHibernateTemplate().update(user);
			log.debug("update successful");
		}catch (RuntimeException e) {
			log.error("update failed", e);
			user = null;
			throw e;
		}finally{
			return user;
		}
	}
	
	/**
	 * 查询所有的会员信息
	 * @return 会员集合
	 */
     @SuppressWarnings("unchecked")
	public List<Users> getAllUsers(){
    	 try {
  			String queryString = "from users order by usersId";
  			return (List<Users>)getHibernateTemplate().find(queryString);
  		} catch (RuntimeException re) {
  			log.error("find all failed", re);
  			throw re;
  		}
     }
     
     /**
      * 可通过名称来查找管理员的信息
      * @param usersName
      * @return
      */
     @SuppressWarnings("unchecked")
	public Users findUsersByName(String usersName){
    	 try {
   			String queryString = "from users where usersName = ?";
   			List<Users> result = (List<Users>)getHibernateTemplate().find(queryString,usersName);
   			if (result.size()>0){
   				return result.get(0);
   			}else{
   				return null;
   			}
   		} catch (RuntimeException re) {
   			log.error("find name failed", re);
   			re.printStackTrace();
   		}
   		return null;
     }
     
     /**
  	 * 模糊查询会员
  	 * @param keyword
  	 * @return 会员集合
  	 */
       @SuppressWarnings("unchecked")
	public List<Users> getUsersByKey(String keyword) {
		try {
			String queryString = "from users where usersInfo like  ?"
					+ " or usersName like  ?"
					+ " or realName like  ?"
					+ " or usersEmail like  ?"
					+ " or phone like  ?" 
					+ " or idNumber like  ?";
			return (List<Users>) getHibernateTemplate().find(queryString,
					'%' + keyword + '%', '%' + keyword + '%', '%' + keyword + '%', '%' + keyword + '%', '%' + keyword + '%', '%' + keyword + '%');
		} catch (RuntimeException re) {
			log.error("getUsersByKey failed", re);
			throw re;
		}
	}
       
	/**
	 * 查询含有关键字的会员数量
	 * 
	 * @param keyword
	 * @return 会员数量
	 */
	public long getCount(String keyword) {
		return (Long) getHibernateTemplate().find(
				"select count(usersId) from users"
						+ " where usersInfo like  ?"
						+ " or usersName like  ?"
						+ " or realName like  ?"
						+ " or usersEmail like  ?"
						+ " or phone like  ?"
						+ " or idNumber like  ?", '%' + keyword + '%', '%' + keyword + '%',
						'%' + keyword + '%', '%' + keyword + '%', '%' + keyword + '%', '%' + keyword + '%').get(0);
	}
       
       /**
     	* 模糊查询会员
     	* @param keyword 关键字
        * @param currentPage 当前页
        * @param lineSize 每页大小
        * @return 新闻集合
        */
        @SuppressWarnings("unchecked")
		public List<Users> getAllUsers(final String keyword, final int currentPage, final int lineSize){
        	final String hql = "from users where usersInfo like  ?"
				+ " or usersName like  ?"
				+ " or realName like  ?"
				+ " or usersEmail like  ?"
				+ " or phone like  ?" 
				+ " or idNumber like  ? order by usersId desc"; // 模糊匹配
			List<Users> list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						// 实现HibernateCallback接口必须实现的方法
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							// 执行Hibernate分页查询
							List<Users> result = session.createQuery(hql)
									// 为hql语句传入参数
									.setParameter(0, '%' + keyword + '%')
									.setParameter(1, '%' + keyword + '%')
									.setParameter(2, '%' + keyword + '%')
									.setParameter(3, '%' + keyword + '%')
									.setParameter(4, '%' + keyword + '%')
									.setParameter(5, '%' + keyword + '%')
									.setFirstResult((currentPage - 1) * lineSize)
									.setMaxResults(lineSize).list();
							return result;
						}
					});
			return list;
        }
}
