package org.stockii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.stockii.common.Common;
import org.stockii.common.DB_UTILS;
import org.stockii.common.LogUtil;


/**
 * 负债表的DAO
 * 
 * @author tt
 * @version 14.12.16
 */
public class LiabilityDAO {

	private String sql;								//DAO中用到的SQL语句
	private Connection con = null; 					//数据库的连接对象
	private PreparedStatement pstmt = null; 		//数据库的操作
	private ResultSet rs = null ;					//数据库结果集
	
	/**
	 * 批量插入数据
	 * @param liabilityList
	 * @return
	 */
	public boolean insertBatch(List<List<Object>> liabilityList ,long startNum){

		sql = "insert into liability_statement " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		return insert(liabilityList,startNum,sql);
	}
	
	/**
	 * 获取表格大小
	 * @return 记录数
	 */
	public long getCount(){
		sql = "select max(seq_no) from liability_statement";
		return getNum(sql);
	}
	
	/**
	 * 批量插入数据（银行）
	 * @param liabilityList
	 * @return
	 */
	public boolean insertBatchBank(List<List<Object>> liabilityList ,long startNum){

		sql = "insert into liability_statement_bank " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		return insert(liabilityList,startNum,sql);
	}
	
	/**
	 * 获取表格大小（银行）
	 * @return 记录数
	 */
	public long getCountBank(){
		sql = "select max(seq_no) from liability_statement_bank";
		return getNum(sql);
	}
	
	public long getNum(String sql){
		long count = 0;
		con = DB_UTILS.getConnection();

		try {
			pstmt = con.prepareStatement(sql); // 实例化查询对象

			rs = pstmt.executeQuery(); // 取得查询结果

			if (rs.next()) {
				count = rs.getLong(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_UTILS.close(con, pstmt, rs);
		}
		return count;
	}
	
	public boolean insert(List<List<Object>> liabilityList ,long startNum, String sql){
		boolean b = false;//操作成功与否
		int size = liabilityList.size();
		con = DB_UTILS.getConnection();//获取连接
		
		LogUtil.getLogger().info(startNum+"");
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //实例化操作

			for (int x = 0; x < size; ++x){
				int mul = 1 ;
				String unit = null;
				ArrayList<Object> row = (ArrayList<Object>) liabilityList.get(x);
				//LogUtil.getLogger().info(row.size()+1);
				for (int y = 1; y <= row.size()+1; ++y){
					Object value = y>1?row.get(y-2):null;
					//LogUtil.getLogger().info(value);
					if (y == 1){
						pstmt.setInt(y, (int)startNum++);
					}else if (y == 2){
						pstmt.setString(y, (String)value);
					}else if (y == 3){
						pstmt.setDate(y, new java.sql.Date(Common.getSwitchDate((String)value).getTime()));
					}else if (y == 4){
						unit = (String)value;
						if (unit.equals("千元")){
							mul = 1000;
						}else{
							mul = 1;
						}
						pstmt.setString(y, unit);
					}else {
						if (value == null || "".equals(value)){
							pstmt.setLong(y, 0);
						}else{
							Integer num = new Integer((String) value);
							pstmt.setLong(y, num*mul);
						}												
					}
				}
				pstmt.addBatch();
			}
			
			int i[] = pstmt.executeBatch();						//更新表格
			if (i.length > 0) {
				b = true;
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_UTILS.close(con, pstmt, rs);
		}
		
		return b;
	}
	
}
