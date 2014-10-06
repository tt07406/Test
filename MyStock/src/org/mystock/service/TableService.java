/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：TableService
 * 
 * 创建日期：2014-10-01
 */
package org.mystock.service;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsVO;
import org.mystock.model.Table;
import org.mystock.model.TableVO;

/**
 * 表格服务类接口
 * @author tt
 * @version 14.9.16
 */
public interface TableService {
	
	/**
	 * 添加表格服务
	 * @param table
	 * @return 操作是否成功
	 * @throws IOException 
	 */
	public boolean addTable(Table table);
	
	/**
	 * 批量删除服务
	 * @param tableIds
	 * @return
	 */
	public boolean deleteTable(int[] tableIds);
	
	/**
	 * 查询表格服务
	 * @param tableId
	 * @return
	 */
	public Table searchTable(int tableId);
	
	/**
	 * 修改表格服务
	 * @param table
	 * @return
	 * @throws IOException 
	 */
	public boolean updateTable(Table table);
	
	/**
	 * 查询所有的表格信息
	 * @return 表格集合
	 */
     public List<Table> getAllTable();
     
     /**
      * 模糊查询表格，只要表格标题、内容、摘要有一个匹配上即可
      * @param keyword
      * @return 新闻集合
      */
     public List<Table> getAllTable(String keyword);
     
     /**
      * 模糊查询表格，只要表格标题、内容、摘要有一个匹配上即可
      * @param keyword 关键字
      * @param currentPage 当前页
      * @param lineSize 每页大小
      * @return 新闻集合
      */
     public List<Table> getAllTable(String keyword, int currentPage, int lineSize);
     
	/**
	 * 获取查询结果的数量
	 * 
	 * @param keyword
	 * @return
	 */
	public long getAllCount(String keyword);
	
	/**
     * 将表格的PO转化成VO供显示
     * @param table
     * @return
     */
    public TableVO toTableVO(Table table);


       /**
        * 备份到数据库
        */
       public void backup(SessionFactory sf);

}
