/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������TableAction
 * 
 * �������ڣ�2014-10-01
 */
package org.mystock.action;

import org.mystock.service.TableService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ������Action
 * @author tt
 * @version 14.9.16
 */
public class TableAction extends ActionSupport {
	
	private static final long serialVersionUID = -5244341070259281864L;
	
	private TableService tableService;

	/**
	 * @param tableService the tableService to set
	 */
	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}
	

}
