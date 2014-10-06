/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������TableVO
 * 
 * �������ڣ�2014-09-30
 */
package org.mystock.model;

/**
 * ���VO
 * 
 * @author tt
 * @version 14.9.16
 */
public class TableVO {
	private int tableId;//���ID
	private String tableName;//�������
	private String tableAbstract;//���ժҪ
	
	public TableVO(){}
	
	public TableVO(int tableId, String tableName, String tableAbstract) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableAbstract = tableAbstract;
	}

	/**
	 * @return the tableId
	 */
	public int getTableId() {
		return tableId;
	}

	/**
	 * @param tableId the tableId to set
	 */
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the tableAbstract
	 */
	public String getTableAbstract() {
		return tableAbstract;
	}

	/**
	 * @param tableAbstract the tableAbstract to set
	 */
	public void setTableAbstract(String tableAbstract) {
		this.tableAbstract = tableAbstract;
	}
	
	
}
