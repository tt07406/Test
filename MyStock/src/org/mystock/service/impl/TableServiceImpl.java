/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������TableServiceImpl
 * 
 * �������ڣ�2014-10-01
 */
package org.mystock.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mystock.dao.TableHibernateDAO;
import org.mystock.model.Table;
import org.mystock.service.TableService;

/**
 * ��������
 * @author tt
 * @version 14.9.16
 */
public class TableServiceImpl implements TableService {
	
	private TableHibernateDAO tableDAO;//���������DAO
	
	/**
	 * @param tableDAO the tableDAO to set
	 */
	public void setTableDAO(TableHibernateDAO tableDAO) {
		this.tableDAO = tableDAO;
	}

	@Override
	public boolean addTable(Table table) {
		Long currentID = tableDAO.addTable(table);
		if (currentID <= 0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void backup(SessionFactory sf) {
		List<Table> data = getAllTable();//��ȡԴ����
	    Session session = null;
	    Transaction tx = null;
   		
   		//�Ȼ��տռ�
   		try {
   			session = sf.openSession();
			tx = session.beginTransaction();
			session.createSQLQuery("truncate table tables").executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
   				if (session.isOpen()) {
   					session.close(); // �ر�Session
   				}
   			}
		}
   		
   		try{			
   			session = sf.openSession();
   			//��ʼ����
   			Transaction t=session.beginTransaction();
   			
   			//������������
   			for (int i = 0; i< data.size(); ++i){
   				session.save(data.get(i));
   			
   				// ������Ķ�������д�����ݿⲢ�ͷ��ڴ�
   				if (i % 10 == 0) {
   					session.flush();
   					session.clear();
   				}
   			}
   			//�ύ����
   			t.commit();
   		}catch (Exception e) {
   			e.printStackTrace(); // ��ӡ������Ϣ
   			session.getTransaction().rollback(); // �����ع�����
   		} finally {
   			if (session != null) {
   				if (session.isOpen()) {
   					session.close(); // �ر�Session
   				}
   			}
   		}

	}

	@Override
	public boolean deleteTable(int[] tableIds) {
		
		return tableDAO.deleteTable(tableIds);
	}

	@Override
	public long getAllCount(String keyword) {
		return tableDAO.getAllCount(keyword);
	}

	@Override
	public List<Table> getAllTable() {
		
		return tableDAO.getAllTable();
	}

	@Override
	public List<Table> getAllTable(String keyword) {

		return tableDAO.getAllTable(keyword);
	}

	@Override
	public List<Table> getAllTable(String keyword, int currentPage, int lineSize) {

		return tableDAO.getAllTable(keyword, currentPage, lineSize);
	}

	@Override
	public Table searchTable(int tableId) {
		return tableDAO.searchTable(tableId);
	}

	@Override
	public boolean updateTable(Table table) {
		if (tableDAO.updateTable(table)==null){
			return false;
		}else{
			return true;
		}
	}

}
