/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������ConnListener
 * 
 * �������ڣ�2014-09-30
 */
package org.mystock.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ��ȡFTP���ӵ�Listener
 * @author tt
 * @version 14.9.16
 */
public class ConnListener implements ServletContextListener{

	/**
	 * Ӧ�ùر�ʱ�ر�FTP����
	 */
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/**
	 * Ӧ������ʱ��������
	 */
	public void contextInitialized(ServletContextEvent arg0) {
	//	Pools.config();
		
	}

}
