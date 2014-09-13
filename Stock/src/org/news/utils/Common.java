/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������Common
 * 
 * �������ڣ�2014-09-13
 */
package org.news.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ú�����
 * @author tt
 * @version 14.8.18
 */
public class Common {
  	/**
	 * ���ַ���ת����һ������
	 * @param startDate
	 * @return
	 */
	public static Date getSwitchDate(String startDate){
		Date dt=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		if (startDate.endsWith("")){
			return new Date();
		}
		try{
			dt = sdf.parse(startDate);;
		}catch(Exception e){
			e.printStackTrace();
			return new Date();
		}
		return dt;
	}
}