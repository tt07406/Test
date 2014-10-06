/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：TableVO
 * 
 * 创建日期：2014-09-30
 */
package org.mystock.model;

/**
 * 表格VO
 * 
 * @author tt
 * @version 14.9.16
 */
public class TableVO {
	private int tableId;//表格ID
	private String tableName;//表格名称
	private String tableAbstract;//表格摘要
	
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
