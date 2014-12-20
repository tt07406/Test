package org.stockii.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.stockii.common.Common;
import org.stockii.common.DB_UTILS;

/**
 * 利润表的DAO
 * 
 * @author tt
 * @version 14.12.16
 */
public class ProfitDAO {

	private String sql;								//DAO中用到的SQL语句
	private Connection con = null; 					//数据库的连接对象
	private PreparedStatement pstmt = null; 		//数据库的操作
	private ResultSet rs = null ;					//数据库结果集
	
	/**
	 * 批量插入数据
	 * @param profitList
	 * @return
	 */
	public boolean insertBatch(List<List<Object>> profitList){

		sql = "insert into profit_statement " +
				"values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		return insert(profitList,sql);
	}
	
	/**
	 * 获取表格大小
	 * @return 记录数
	 */
	public long getCount(){
		sql = "select max(seq_no) from profit_statement";
		return getNum(sql);
	}
	
	/**
	 * 批量插入数据（银行）
	 * @param profitList
	 * @return
	 */
	public boolean insertBatchBank(List<List<Object>> profitList){

		sql = "insert into profit_statement_bank " +
				"values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?)"; 
		
		return insert(profitList,sql);
	}
	
	/**
	 * 获取表格大小（银行）
	 * @return 记录数
	 */
	public long getCountBank(){
		sql = "select max(seq_no) from profit_statement_bank";
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
	
	public boolean insert(List<List<Object>> profitList ,String sql){
		boolean b = false;//操作成功与否
		int size = profitList.size();
		con = DB_UTILS.getConnection();//获取连接
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //实例化操作

			for (int x = 0; x < size; ++x){
				int mul = 1 ;
				String unit = null;
				ArrayList<Object> row = (ArrayList<Object>) profitList.get(x);
				for (int y = 1; y <= row.size(); ++y){
					Object value = row.get(y-1);
					//LogUtil.getLogger().info(value+";"+y);
					if (y == 1){
						pstmt.setString(y, (String)value);
					}else if (y == 2){
						Date date = new java.sql.Date(Common.getSwitchDate((String)value).getTime());
						pstmt.setDate(y, date);
					}else if (y == 3){
						unit = (String)value;
						if (unit.equals("千元")){
							mul = 1000;
							unit = "元";
						}else if (unit.equals("百万")){
							mul = 1000000;
							unit = "元";
						}else{
							mul = 1;
						}
						pstmt.setString(y, unit);
					}else {
						if ( y == 47 || y == 48){
							mul = 1;
						}
						if (value == null || "".equals(value)){
							pstmt.setDouble(y, 0);
						}else if (value instanceof String){
							long num = Long.parseLong((String)value);
							pstmt.setDouble(y, (double)num*mul);
						}else{
							pstmt.setDouble(y, (Double)value*mul);
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
