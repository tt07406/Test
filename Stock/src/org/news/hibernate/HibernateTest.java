package org.news.hibernate;

import org.hibernate.HibernateException;
import org.news.hibernate.dao.NewstypeDAO;
import org.news.hibernate.domain.Newstype;

public class HibernateTest {

	public static void main(String[] args){
		
		NewstypeDAO newsTypeDAO = new NewstypeDAO();
		try{
			Newstype type = newsTypeDAO.findById(new Integer(1));
			System.out.println(type.getNewsTypeName());
		}catch(HibernateException e){
			System.err.println("Entity retrieval failed."); 
			e.printStackTrace();
		}finally { 
			try { 
				newsTypeDAO.getSession().close(); 
			} catch (Exception e) {
				// do nothing 
			}
		}
			
		
	}
}
