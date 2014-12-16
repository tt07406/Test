package org.stockii.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.stockii.common.Common;
import org.stockii.common.DB_UTILS;


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
		boolean b = false;//操作成功与否
		int size = liabilityList.size();
		sql = "insert into liability_statement " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		con = DB_UTILS.getConnection();//获取连接
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //实例化操作

			for (int x = 0; x < size; ++x){
				int mul = 1 ;
				String unit = null;
				ArrayList<Object> row = (ArrayList<Object>) liabilityList.get(x);
				for (int y = 1; y <= row.size(); ++y){
					if (y == 1){
						pstmt.setLong(y, startNum++);
					}else if (y == 2){
						pstmt.setString(y, (String)row.get(y-1));
					}else if (y == 3){
						pstmt.setDate(y, (java.sql.Date)Common.getSwitchDate((String)row.get(y-1)));
					}else if (y == 4){
						unit = (String)row.get(y-1);
						if (unit.equals("千元")){
							mul = 1000;
						}
						pstmt.setString(y, unit);
					}else {
						pstmt.setLong(y, (Long)row.get(y-1)*mul);
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
	
	/**
	 * 获取表格大小
	 * @return 记录数
	 */
	public long getCount(){
		long count = 0;
		sql = "select max(seq_no) from liability_statement";
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
}
