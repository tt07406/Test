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
		ResourceBundle rb = ResourceBundle.getBundle("org.mystock.utils.identity") ; 
		return rb.getString(key) ;
	}
}
