/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������ConnListener
 * 
 * �������ڣ�2014-07-08
 */
package org.news.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ��ȡ���ݿ����ӵ�Listener
 * @author tt
 * @version 14.6.18
 */
public class ConnListener implements ServletContextListener{

	/**
	 * Ӧ�ùر�ʱ�ر����ݿ�����
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		Pools.closeAllConnections();
	}

	/**
	 * Ӧ������ʱ��������
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		Pools.config();
		
	}

}
