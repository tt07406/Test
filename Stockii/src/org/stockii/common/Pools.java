package org.stockii.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.PropertyResourceBundle;

/**
 * JDBC���ӳ�,��ϵͳ��Ҫ��ȡ���ݿ�����ʱ��ֻ�贴��һ�����ݿ����Ӷ���
 * ��������ݿ��ȡ���ӣ�Ȼ�����ִ��SQL�������ݿ���в�����
 * @author tt
 * @version 14.6.18
 */
public class Pools {

	private final static int num = 3;//������������
	/**
	 * ���ݿ����URL
	 */
	private static String url;

	/**
	 * ���ݿ�����
	 */
	private static String driver;

	/**
	 * ���ݿ�����û���
	 */
	private static String user;

	/**
	 * ���ݿ���ʿ���
	 */
	private static String password;

	/**
	 * �����ļ�����
	 */
	private final static String fileName = "database";	
	private static Connection con = null;
	private static LinkedList<Connection> pools = new LinkedList<Connection>();//�������ʾ���ӳ�
	
	static{//��ʼ�����ӳأ��������ɸ�����
		config();
		try {
			Class.forName(driver);
			for(int i = 1 ; i <= num ; i++){
				pools.addLast(getPoolsConnection());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void config() {
		//��ȡϵͳ����
		PropertyResourceBundle resourceBundle = (PropertyResourceBundle) PropertyResourceBundle
				.getBundle(fileName);
		//��ϵͳ���ø�ֵ�������
		Enumeration<String> enu = resourceBundle.getKeys();
		while (enu.hasMoreElements()) {
			String propertyName = enu.nextElement().toString();
			if (propertyName.equals("database.url"))
				url = resourceBundle.getString("database.url");
			if (propertyName.equals("database.driver"))
				driver = resourceBundle.getString("database.driver");
			if (propertyName.equals("database.username"))
				user = resourceBundle.getString("database.username");
			if (propertyName.equals("database.password"))
				password = resourceBundle.getString("database.password");
		}
		try {//��ʼ�����ӳأ��������ɸ�����
			Class.forName(driver);
			for(int i = 1 ; i <= num ; i++){
				pools.addLast(getPoolsConnection());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAllConnections(){
		try {
			for(int i = 1 ; i <= num ; i++){
				pools.get(i).close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡһ������
	 * @return
	 */
	public static Connection getPoolsConnection(){
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * �ӳ��еõ�һ������
	 * @return
	 */
	public static Connection getPoolsConnectionSingle(){
		con = pools.removeFirst();
		return con ;
	}
	
	/**
	 * �����ӷŻس���
	 * @param con
	 * @throws SQLException
	 */
	public static void freeConnection(Connection con) throws SQLException{
		pools.addLast(con);
	}
	
}
