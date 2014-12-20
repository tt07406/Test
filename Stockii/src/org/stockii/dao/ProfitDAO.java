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
 * ������DAO
 * 
 * @author tt
 * @version 14.12.16
 */
public class ProfitDAO {

	private String sql;								//DAO���õ���SQL���
	private Connection con = null; 					//���ݿ�����Ӷ���
	private PreparedStatement pstmt = null; 		//���ݿ�Ĳ���
	private ResultSet rs = null ;					//���ݿ�����
	
	/**
	 * ������������
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
	 * ��ȡ����С
	 * @return ��¼��
	 */
	public long getCount(){
		sql = "select max(seq_no) from profit_statement";
		return getNum(sql);
	}
	
	/**
	 * �����������ݣ����У�
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
	 * ��ȡ����С�����У�
	 * @return ��¼��
	 */
	public long getCountBank(){
		sql = "select max(seq_no) from profit_statement_bank";
		return getNum(sql);
	}
	
	public long getNum(String sql){
		long count = 0;
		con = DB_UTILS.getConnection();

		try {
			pstmt = con.prepareStatement(sql); // ʵ������ѯ����

			rs = pstmt.executeQuery(); // ȡ�ò�ѯ���

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
		boolean b = false;//�����ɹ����
		int size = profitList.size();
		con = DB_UTILS.getConnection();//��ȡ����
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //ʵ��������

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
						if (unit.equals("ǧԪ")){
							mul = 1000;
							unit = "Ԫ";
						}else if (unit.equals("����")){
							mul = 1000000;
							unit = "Ԫ";
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
			
			int i[] = pstmt.executeBatch();						//���±��
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
