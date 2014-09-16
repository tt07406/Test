/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：Common
 * 
 * 创建日期：2014-09-16
 */
package org.mystock.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公用函数类
 * @author tt
 * @version 14.9.16
 */
public class Common {
  	/**
	 * 将字符串转换成一个日期
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
