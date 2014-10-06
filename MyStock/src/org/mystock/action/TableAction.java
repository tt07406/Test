/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：TableAction
 * 
 * 创建日期：2014-10-01
 */
package org.mystock.action;

import java.util.ArrayList;
import java.util.List;

import org.mystock.model.Table;
import org.mystock.model.TableVO;
import org.mystock.service.TableService;
import org.mystock.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 表格操作Action
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
	
	Table tables;
	String msg; //提示信息
	List<TableVO> allTable;//所有表格
	String pg;  //URL
	String cp; //为当前所在的页
	String ls; //每次显示的记录数
	int tid; //表格ID
	String kw; //查询关键字
	long recorders; //查询到的全部记录数
	String url;
	int page;
	int size;
	
	
	
	
	/**
	 * @return the tables
	 */
	public Table getTables() {
		return tables;
	}




	/**
	 * @param tables the tables to set
	 */
	public void setTables(Table tables) {
		this.tables = tables;
	}




	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}




	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}




	/**
	 * @return the allTable
	 */
	public List<TableVO> getAllTable() {
		return allTable;
	}




	/**
	 * @param allTable the allTable to set
	 */
	public void setAllTable(List<TableVO> allTable) {
		this.allTable = allTable;
	}




	/**
	 * @return the pg
	 */
	public String getPg() {
		return pg;
	}




	/**
	 * @param pg the pg to set
	 */
	public void setPg(String pg) {
		this.pg = pg;
	}




	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}




	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}




	/**
	 * @return the ls
	 */
	public String getLs() {
		return ls;
	}




	/**
	 * @param ls the ls to set
	 */
	public void setLs(String ls) {
		this.ls = ls;
	}




	/**
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}




	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}




	/**
	 * @return the kw
	 */
	public String getKw() {
		return kw;
	}




	/**
	 * @param kw the kw to set
	 */
	public void setKw(String kw) {
		this.kw = kw;
	}




	/**
	 * @return the recorders
	 */
	public long getRecorders() {
		return recorders;
	}




	/**
	 * @param recorders the recorders to set
	 */
	public void setRecorders(long recorders) {
		this.recorders = recorders;
	}




	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}




	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}




	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}




	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}




	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}




	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}




	/**
	 * 插入表格
	 * @return
	 */
	public String insert(){
		try {
			if (tableService.addTable(tables)) {
				setMsg(MessageUtil
						.get("table.insert.true"));
			} else {
				setMsg(MessageUtil
						.get("table.insert.false"));
			}
			setUrl("table_insert.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新前的操作
	 * @return
	 */
	public String updatepre(){
		try {//找了ID对应的表格信息
			tables = tableService.searchTable(tid);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	/**
	 * 删除表格
	 * @return
	 */
	public String delete(){
		int[] tableIds = new int[1];
		tableIds[0] = tid;
		try {
			if(tableService.deleteTable(tableIds)){
				setMsg(MessageUtil
						.get("table.delete.true"));
			} else {
				setMsg(MessageUtil
						.get("table.delete.false"));
			}
			setUrl("Table_list.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 获取表格列表
	 * @return
	 */
	public String list(){
		String URL = "Table_list.action" ;
		
		try {
			int currentPage = 1 ;	// 为当前所在的页，默认在第1页
			int lineSize = 20;		// 每次显示的记录数
			String keyWord = getKw();	// 接收查询关键字

			try{
				currentPage = Integer.parseInt(cp) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(ls) ;
			} catch(Exception e) {}
			if(keyWord == null){
				keyWord = "" ;	// 如果模糊查询没有关键字，则表示查询全部
			}
			
			List<Table> all = tableService.getAllTable(keyWord, currentPage, lineSize);
			List<TableVO> tableVO = new ArrayList<TableVO>();
			for (Table table:all){
				tableVO.add(tableService.toTableVO(table));
			}
			recorders = tableService.getAllCount(keyWord) ;
			allTable = tableVO;
			setUrl(URL);
			setPage(currentPage);
			setSize(lineSize);
	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 查看表格信息
	 * @return
	 */
	public String show(){
		try {
			tables = tableService.searchTable(tid);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新表格
	 * @return
	 */
	public String update(){
		try {//更新数据库
			if (tableService.updateTable(tables)) {
				setMsg(MessageUtil
						.get("table.update.true"));
			} else {
				setMsg(MessageUtil
						.get("table.update.false"));
			}
			setUrl("Table_list.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

}
