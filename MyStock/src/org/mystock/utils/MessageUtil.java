/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������CharacterEncodingFilter
 * 
 * �������ڣ�2014-09-16
 */
package org.mystock.utils;

/**
 * ��Ϣ�����࣬������Դ�е���Ϣ�����伯�й���
 * @author tt
 * @version 14.9.16
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class MessageUtil {
	
	/**
	 * �ɹؼ��ֻ�ȡ�����Ϣ
	 * @param key
	 * @return ��Ϣ
	 */
	public static String get(String key){
		ResourceBundle rb = ResourceBundle.getBundle("org.mystock.utils.Message") ; 
		return rb.getString(key) ;
	}
	
	/**
	 * �ɹؼ��ֻ�ȡ��������Ϣ
	 * @param key
	 * @return ��Ϣ
	 */
	public static String getID(String key){
		  File f = new File(Common.class.getResource("/").getPath());

		  
		  try {
			Properties props = new Properties();
			InputStream ips = null;
			ips = new BufferedInputStream(new FileInputStream(f.getPath()+"/org/mystock/utils/identity.properties"));
			  
			if (ips == null){
				  return null;
			}
			
			props.load(ips);
			
			return props.getProperty(key)==null?"":props.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
