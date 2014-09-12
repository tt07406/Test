/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������UsersHibernateDAO
 * 
 * �������ڣ�2014-09-12
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
 * �û���ϢDAO
 * @author tt
 * @version 14.8.18
 */
public class UsersHibernateDAO extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory.getLogger(UsersHibernateDAO.class);
	
	/**
	 * �û���¼��֤
	 * @param user
	 * @return ��֤�Ĳ������
	 */
	public boolean findLogin(Users user){
		String userName = user.getUsersName();
		String userPass = user.getUsersPass();
		
		//ȡ��ID�����Ҵ�����
		long result = (Long)getHibernateTemplate().find("select count(usersId) from users where usersName = ? and usersPass = ?", userName,userPass).get(0);
		
		if (result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ���ӻ�Ա
	 * @param user ����VO����
	 * @return �����Ƿ�ɹ�
	 */
	public boolean addUser(Users user){
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
     * ��ͨ��Id�����һ�Ա����Ϣ
     * @param usersId
     * @return
     */
    public Users findUsersById(int usersId){
    	return (Users)getHibernateTemplate().get(Users.class, usersId); 
    }
    
	/**
	 * ����ɾ����Ա
	 * @param userIds
	 * @return �Ƿ�ɹ�
	 */
	public boolean deleteUsers(int[] userIds) {
		for (int i = 0; i < userIds.length; i++) {
			try {
				getHibernateTemplate().delete(findUsersById(userIds[i]));
				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * �޸Ļ�Ա��Ϣ
	 * @param users
	 * @return ����Ա
	 */
	public Users updateUsers(Users user) {
		try{
			getHibernateTemplate().update(user);
			log.debug("update successful");
			return user;
		}catch (Exception e) {
			log.error("update failed", e);
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��ѯ���еĻ�Ա��Ϣ
	 * @return ��Ա����
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
      * ��ͨ�����������ҹ���Ա����Ϣ
      * @param usersName
      * @return
      */
     @SuppressWarnings("unchecked")
	public Users findUsersByName(String usersName){
    	 try {
   			String queryString = "from users where usersName = ?";
   			List<Users> result = (List<Users>)getHibernateTemplate().find(queryString,usersName);
   			return result.get(0);
   		} catch (RuntimeException re) {
   			log.error("find name failed", re);
   			throw re;
   		}
     }
     
     /**
  	 * ģ����ѯ��Ա
  	 * @param keyword
  	 * @return ��Ա����
  	 */
       @SuppressWarnings("unchecked")
	public List<Users> getUsersByKey(String keyword) {
		try {
			String queryString = "from users where usersInfo like binary ?"
					+ " or usersName like binary ?"
					+ " or realName like binary ?"
					+ " or usersEmail like binary ?"
					+ " or phone like binary ?" 
					+ " or idNumber like binary ?";
			return (List<Users>) getHibernateTemplate().find(queryString,
					keyword, keyword, keyword, keyword, keyword, keyword);
		} catch (RuntimeException re) {
			log.error("getUsersByKey failed", re);
			throw re;
		}
	}
       
	/**
	 * ��ѯ���йؼ��ֵĻ�Ա����
	 * 
	 * @param keyword
	 * @return ��Ա����
	 */
	public long getCount(String keyword) {
		return (Long) getHibernateTemplate().find(
				"select count(usersId) from users"
						+ " where usersInfo like binary ?"
						+ " or usersName like binary ?"
						+ " or realName like binary ?"
						+ " or usersEmail like binary ?"
						+ " or phone like binary ?"
						+ " or idNumber like binary ?", keyword, keyword,
				keyword, keyword, keyword, keyword).get(0);
	}
       
       /**
     	* ģ����ѯ��Ա
     	* @param keyword �ؼ���
        * @param currentPage ��ǰҳ
        * @param lineSize ÿҳ��С
        * @return ���ż���
        */
        @SuppressWarnings("unchecked")
		public List<Users> getAllUsers(final String keyword, final int currentPage, final int lineSize){
        	final String hql = "from users where usersInfo like binary ?"
				+ " or usersName like binary ?"
				+ " or realName like binary ?"
				+ " or usersEmail like binary ?"
				+ " or phone like binary ?" 
				+ " or idNumber like binary ? order by usersId desc"; // ģ��ƥ��
			List<Users> list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							// ִ��Hibernate��ҳ��ѯ
							List<Users> result = session.createQuery(hql)
									// Ϊhql��䴫�����
									.setParameter(0, keyword)
									.setParameter(1, keyword)
									.setParameter(2, keyword)
									.setParameter(3, keyword)
									.setParameter(4, keyword)
									.setParameter(5, keyword)
									.setFirstResult((currentPage - 1) * lineSize)
									.setMaxResults(lineSize).list();
							return result;
						}
					});
			return list;
        }
}