/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：Common
 * 
 * 创建日期：2014-09-16
 */
package org.stockii.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/**
 * 公用函数类
 * @author tt
 * @version 14.9.16
 */
public class Common {
	
	public static double lgPositive = Math.log(1.02);
	public static double lgNegetive = Math.log(0.98);
	
  	/**
	 * 将字符串转换成一个日期
	 * @param startDate
	 * @return
	 */
	public static Date getSwitchDate(String startDate){
		Date dt=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (startDate.equals("")){
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
	
	/**
	  * 修改properties文件,参数是map键值集合,根据键修改值,如果没有键值对就创建
	  * 
	  * @param filePath
	  *            文件路径
	  * @param keyVal
	  *            内容参数
	  * @param over是否覆盖，true的话就覆盖，false的话就是更新
	  * @return
	  * @throws IOException 
	  */
	 public static boolean writeProperties(String filePath,
	   Map<String, String> keyVal, boolean over) throws IOException {

	  File f = new File(Common.class.getResource("/").getPath());
	  boolean flag = false;
	  Properties props = new Properties();
	  InputStream ips = null;
	  ips = new BufferedInputStream(new FileInputStream(f.getPath()+filePath));
	  
	  if (ips == null){
		  return flag;
	  }
	  props.load(ips);
	  
	  ips.close();
	  
	  OutputStream fos = null;
	  if (over) {
	   // 将新添加的内容覆盖原来的内容

	   fos = new FileOutputStream(f.getPath()+filePath);
	   // 将keys转换成数组
	   // 将键值逐一添加到property中
	   for (Object str : keyVal.keySet().toArray()) {
	    
	    props.setProperty(str.toString(), keyVal.get(str));
	   }
	   props.store(fos, "set");
	   flag = true;
	  
	   fos.close();
	   
	  } else {

	   fos = new FileOutputStream(f.getPath()+filePath);
	   for (Object key : keyVal.keySet().toArray()) {
	    props.setProperty(key.toString(), keyVal.get(key));
	   }
	   props.store(fos, "");
	   flag = true;
	  
	   fos.close();
	    
	  }
	  return flag;
	 }
	 
	 /**
	  * 计算跨区数
	  * @param avg_value 平均值
	  * @param start_price 起始价
	  * @param end_price 终止价
	  * @return 正数为向上跨区，负数为向下跨区，0为不跨区
	  */
	 public static int getSectionNum(BigDecimal avg_value,BigDecimal start_price,BigDecimal end_price){
		 int start_section = 0;
		 int end_section = 0;
		 
		 if (avg_value == null || start_price == null || end_price == null){
			 return 0;
		 }
		 
		 double avgValue = avg_value.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();//精度为小数点后四位
		 
		 double lgbase = Math.log(start_price.doubleValue())-Math.log(avgValue);
		  if (start_price.compareTo(avg_value) > 0){
			  start_section = (int) (lgbase / lgPositive);
		  }else if (start_price.compareTo(avg_value) < 0){
			  start_section = (int) (lgbase / lgNegetive)*(-1);
		  }
		  
		lgbase = Math.log(end_price.doubleValue())-Math.log(avgValue);
		if (end_price.compareTo(avg_value) > 0){
			end_section = (int) (lgbase / lgPositive);
		  }else if (end_price.compareTo(avg_value) < 0){
			  end_section = (int) (lgbase / lgNegetive)*(-1);
		  }
		 
		return end_section - start_section;	 
	 }
}
