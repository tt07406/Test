/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：ConnListener
 * 
 * 创建日期：2014-09-30
 */
package org.mystock.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 开机启动任务的Listener
 * @author tt
 * @version 14.9.16
 */
public class ConnListener implements ServletContextListener{

	/**
	 * 应用关闭时关闭FTP连接
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		new TimerManager();
	}

	/**
	 * 应用启动时建立连接
	 */
	public void contextInitialized(ServletContextEvent arg0) {
	//	Pools.config();
		
	}

}
