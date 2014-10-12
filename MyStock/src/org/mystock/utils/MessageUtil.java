/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：CharacterEncodingFilter
 * 
 * 创建日期：2014-09-16
 */
package org.mystock.utils;

/**
 * 消息公用类，传递资源中的信息，对其集中管理
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
	 * 由关键字获取相关信息
	 * @param key
	 * @return 消息
	 */
	public static String get(String key){
		ResourceBundle rb = ResourceBundle.getBundle("org.mystock.utils.Message") ; 
		return rb.getString(key) ;
	}
	
	/**
	 * 由关键字获取相关身份信息
	 * @param key
	 * @return 消息
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
