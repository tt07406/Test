/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������TableService
 * 
 * �������ڣ�2014-10-01
 */
package org.mystock.service;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.mystock.model.Table;

/**
 * ��������ӿ�
 * @author tt
 * @version 14.9.16
 */
public interface TableService {
	
	/**
	 * ��ӱ�����
	 * @param table
	 * @return �����Ƿ�ɹ�
	 * @throws IOException 
	 */
	public boolean addTable(Table table);
	
	/**
	 * ����ɾ������
	 * @param tableIds
	 * @return
	 */
	public boolean deleteTable(int[] tableIds);
	
	/**
	 * ��ѯ������
	 * @param tableId
	 * @return
	 */
	public Table searchTable(int tableId);
	
	/**
	 * �޸ı�����
	 * @param table
	 * @return
	 * @throws IOException 
	 */
	public boolean updateTable(Table table);
	
	/**
	 * ��ѯ���еı����Ϣ
	 * @return ��񼯺�
	 */
     public List<Table> getAllTable();
     
     /**
      * ģ����ѯ���ֻҪ�����⡢���ݡ�ժҪ��һ��ƥ���ϼ���
      * @param keyword
      * @return ���ż���
      */
     public List<Table> getAllTable(String keyword);
     
     /**
      * ģ����ѯ���ֻҪ�����⡢���ݡ�ժҪ��һ��ƥ���ϼ���
      * @param keyword �ؼ���
      * @param currentPage ��ǰҳ
      * @param lineSize ÿҳ��С
      * @return ���ż���
      */
     public List<Table> getAllTable(String keyword, int currentPage, int lineSize);
     
	/**
	 * ��ȡ��ѯ���������
	 * 
	 * @param keyword
	 * @return
	 */
	public long getAllCount(String keyword);


       /**
        * ���ݵ����ݿ�
        */
       public void backup(SessionFactory sf);

}
