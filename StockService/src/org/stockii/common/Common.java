/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������Common
 * 
 * �������ڣ�2014-09-16
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
 * ���ú�����
 * @author tt
 * @version 14.9.16
 */
public class Common {
	
	public static double lgPositive = Math.log(1.02);
	public static double lgNegetive = Math.log(0.98);
	
  	/**
	 * ���ַ���ת����һ������
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
	  * �޸�properties�ļ�,������map��ֵ����,���ݼ��޸�ֵ,���û�м�ֵ�Ծʹ���
	  * 
	  * @param filePath
	  *            �ļ�·��
	  * @param keyVal
	  *            ���ݲ���
	  * @param over�Ƿ񸲸ǣ�true�Ļ��͸��ǣ�false�Ļ����Ǹ���
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
	   // ������ӵ����ݸ���ԭ��������

	   fos = new FileOutputStream(f.getPath()+filePath);
	   // ��keysת��������
	   // ����ֵ��һ��ӵ�property��
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
	  * ���������
	  * @param avg_value ƽ��ֵ
	  * @param start_price ��ʼ��
	  * @param end_price ��ֹ��
	  * @return ����Ϊ���Ͽ���������Ϊ���¿�����0Ϊ������
	  */
	 public static int getSectionNum(BigDecimal avg_value,BigDecimal start_price,BigDecimal end_price){
		 int start_section = 0;
		 int end_section = 0;
		 
		 if (avg_value == null || start_price == null || end_price == null){
			 return 0;
		 }
		 
		 double avgValue = avg_value.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();//����ΪС�������λ
		 
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
