package org.stockii.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.PropertyResourceBundle;

/**
 * JDBC连接池,当系统需要获取数据库数据时，只需创建一个数据库连接对象，
 * 便可与数据库获取连接，然后可以执行SQL语句对数据库进行操作。
 * @author tt
 * @version 14.6.18
 */
public class Pools {

	private final static int num = 3;//池中连接数量
	/**
	 * 数据库访问URL
	 */
	private static String url;

	/**
	 * 数据库驱动
	 */
	private static String driver;

	/**
	 * 数据库访问用户名
	 */
	private static String user;

	/**
	 * 数据库访问口令
	 */
	private static String password;

	/**
	 * 配置文件名称
	 */
	private final static String fileName = "database";	
	private static Connection con = null;
	private static LinkedList<Connection> pools = new LinkedList<Connection>();//用链表表示连接池
	
	static{//初始化连接池，建立若干个连接
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
		//读取系统配置
		PropertyResourceBundle resourceBundle = (PropertyResourceBundle) PropertyResourceBundle
				.getBundle(fileName);
		//将系统设置赋值给类变量
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
		try {//初始化连接池，建立若干个连接
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
	 * 获取一个连接
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
	 * 从池中得到一个连接
	 * @return
	 */
	public static Connection getPoolsConnectionSingle(){
		con = pools.removeFirst();
		return con ;
	}
	
	/**
	 * 将连接放回池中
	 * @param con
	 * @throws SQLException
	 */
	public static void freeConnection(Connection con) throws SQLException{
		pools.addLast(con);
	}
	
}
