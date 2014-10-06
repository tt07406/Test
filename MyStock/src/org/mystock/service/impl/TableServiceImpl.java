/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：TableServiceImpl
 * 
 * 创建日期：2014-10-01
 */
package org.mystock.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.mystock.dao.TableHibernateDAO;
import org.mystock.model.NewsIndex;
import org.mystock.model.NewsVO;
import org.mystock.model.Table;
import org.mystock.model.TableVO;
import org.mystock.service.TableService;

/**
 * 表格服务类
 * @author tt
 * @version 14.9.16
 */
public class TableServiceImpl implements TableService {
	
	private TableHibernateDAO tableDAO;//引入表格操作DAO
	
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
		List<Table> data = getAllTable();//获取源数据
	    Session session = null;
	    Transaction tx = null;
   		
   		//先回收空间
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
   					session.close(); // 关闭Session
   				}
   			}
		}
   		
   		try{			
   			session = sf.openSession();
   			//开始事务
   			Transaction t=session.beginTransaction();
   			
   			//备份新闻详情
   			for (int i = 0; i< data.size(); ++i){
   				session.save(data.get(i));
   			
   				// 批插入的对象立即写入数据库并释放内存
   				if (i % 10 == 0) {
   					session.flush();
   					session.clear();
   				}
   			}
   			//提交事务
   			t.commit();
   		}catch (Exception e) {
   			e.printStackTrace(); // 打印错误信息
   			session.getTransaction().rollback(); // 出错将回滚事物
   		} finally {
   			if (session != null) {
   				if (session.isOpen()) {
   					session.close(); // 关闭Session
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

	@Override
	public TableVO toTableVO(Table table) {
		TableVO tableVO = new TableVO();
  	   if (table != null){
  		   tableVO.setTableId(table.getTableId());
  		   tableVO.setTableName(table.getTableName());
  		   tableVO.setTableAbstract(table.getTableAbstract());
  	   }
  	   return tableVO;    	   
	}

}
