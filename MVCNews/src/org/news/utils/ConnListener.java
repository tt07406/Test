/*
 * 系统名称：新闻发布系统
 * 
 * 类名：ConnListener
 * 
 * 创建日期：2014-07-08
 */
package org.news.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 获取数据库连接的Listener
 * @author tt
 * @version 14.6.18
 */
public class ConnListener implements ServletContextListener{

	/**
	 * 应用关闭时关闭数据库连接
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		Pools.closeAllConnections();
	}

	/**
	 * 应用启动时建立连接
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		Pools.config();
		
	}

}
