package org.stockii.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.stockii.common.DB_UTILS;

/**
 * 股权变动表的DAO
 * 
 * @author tt
 * @version 14.12.16
 */
public class EquityChangeDAO {

	private String sql;								//DAO中用到的SQL语句
	private Connection con = null; 					//数据库的连接对象
	private PreparedStatement pstmt = null; 		//数据库的操作
	private ResultSet rs = null ;					//数据库结果集
	
	/**
	 * 批量插入数据
	 * @param changeList
	 * @return
	 */
	public boolean insertBatch(List<List<Object>> changeList){

		sql = "insert into equity_change_statement " +
				"values(null,?,?,?,?,?,?,?)"; 
		
		return insert(changeList,sql);
	}
	
	/**
	 * 获取表格大小
	 * @return 记录数
	 */
	public long getCount(){
		sql = "select max(seq_no) from equity_change_statement";
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
	
	public boolean insert(List<List<Object>> changeList ,String sql){
		boolean b = false;//操作成功与否
		int size = changeList.size();
		con = DB_UTILS.getConnection();//获取连接
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //实例化操作

			for (int x = 0; x < size; ++x){
				ArrayList<Object> row = (ArrayList<Object>) changeList.get(x);
				
				for (int y = 1; y <= row.size(); ++y){
					Object value = row.get(y-1);
					if (y == 1){
						pstmt.setString(y, (String)value);
					}else if (y == 2){
						pstmt.setString(y, (String)value);
					}else {
						if (value == null || "".equals(value)){
							pstmt.setString(y, "");
						}else if (value instanceof String){
							pstmt.setString(y, (String)value);
						}else{
							BigDecimal num = new BigDecimal((Double)value);
							NumberFormat nf = NumberFormat.getNumberInstance();
					        nf.setMaximumFractionDigits(2);
							pstmt.setString(y, nf.format(num));
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
