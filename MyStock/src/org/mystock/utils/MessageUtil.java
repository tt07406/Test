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
		ResourceBundle rb = ResourceBundle.getBundle("org.mystock.utils.identity") ; 
		return rb.getString(key) ;
	}
}
