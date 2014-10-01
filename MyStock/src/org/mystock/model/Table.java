/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������Table
 * 
 * �������ڣ�2014-09-30
 */
package org.mystock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * ���PO
 * 
 * @author tt
 * @version 14.9.16
 */
@Entity(name="tables")
public class Table {
	
	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private int tableId;//���ID
	private String tableName;//�������
	private String tableAbstract;//���ժҪ
	private int tableRow;//�������
	private int tableCol;//�������
	private String tableContent;//�������
	
	public Table(){}

	public Table(int tableId, String tableName, String tableAbstract,
			int tableRow, int tableCol, String tableContent) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableAbstract = tableAbstract;
		this.tableRow = tableRow;
		this.tableCol = tableCol;
		this.tableContent = tableContent;
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

	/**
	 * @return the tableRow
	 */
	public int getTableRow() {
		return tableRow;
	}

	/**
	 * @param tableRow the tableRow to set
	 */
	public void setTableRow(int tableRow) {
		this.tableRow = tableRow;
	}

	/**
	 * @return the tableCol
	 */
	public int getTableCol() {
		return tableCol;
	}

	/**
	 * @param tableCol the tableCol to set
	 */
	public void setTableCol(int tableCol) {
		this.tableCol = tableCol;
	}

	/**
	 * @return the tableContent
	 */
	public String getTableContent() {
		return tableContent;
	}

	/**
	 * @param tableContent the tableContent to set
	 */
	public void setTableContent(String tableContent) {
		this.tableContent = tableContent;
	}
	
	
}
