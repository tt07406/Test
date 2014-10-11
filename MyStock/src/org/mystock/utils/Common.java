/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������Common
 * 
 * �������ڣ�2014-09-16
 */
package org.mystock.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
}
