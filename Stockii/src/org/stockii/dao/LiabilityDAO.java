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
 * ��ծ���DAO
 * 
 * @author tt
 * @version 14.12.16
 */
public class LiabilityDAO {

	private String sql;								//DAO���õ���SQL���
	private Connection con = null; 					//���ݿ�����Ӷ���
	private PreparedStatement pstmt = null; 		//���ݿ�Ĳ���
	private ResultSet rs = null ;					//���ݿ�����
	
	/**
	 * ������������
	 * @param liabilityList
	 * @return
	 */
	public boolean insertBatch(List<List<Object>> liabilityList ,long startNum){
		boolean b = false;//�����ɹ����
		int size = liabilityList.size();
		sql = "insert into liability_statement " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		con = DB_UTILS.getConnection();//��ȡ����
		
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); //ʵ��������

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
						if (unit.equals("ǧԪ")){
							mul = 1000;
						}
						pstmt.setString(y, unit);
					}else {
						pstmt.setLong(y, (Long)row.get(y-1)*mul);
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
	
	/**
	 * ��ȡ����С
	 * @return ��¼��
	 */
	public long getCount(){
		long count = 0;
		sql = "select max(seq_no) from liability_statement";
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
}
