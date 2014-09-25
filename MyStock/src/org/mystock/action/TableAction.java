/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������TableAction
 * 
 * �������ڣ�2014-09-25
 */
package org.mystock.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ڱ���ϴ�������Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class TableAction extends ActionSupport {

	private static final long serialVersionUID = -5244341070259281864L;

	String msg = null ;//��ʾ��Ϣ
	List<String> tables = new ArrayList<String>();//���еı��

    String filename;//�����ļ���
    private File file;    
    private String fileFileName;   
    private String fileContentType;   
    	
	public File getFile() {
		return file;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public String getFileFileName() {
		return fileFileName;
	}



	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}



	public String getFileContentType() {
		return fileContentType;
	}



	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
    
    /**
	 * @return the filename
	 */
	public String getFilename() {
		String downFileName = "";
		try {
			downFileName = java.net.URLEncoder.encode(filename, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	    return downFileName;
		//return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		try {
			this.filename = new String(filename.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the tables
	 */
	public List<String> getTables() {
		return tables;
	}



	/**
	 * @param tables the tables to set
	 */
	public void setTables(List<String> tables) {
		this.tables = tables;
	}



	/**
	 * Ĭ���ϴ�
	 * @return
	 * @throws IOException 
	 */
	public void upload() throws IOException {
		InputStream is;

		HttpServletResponse response = ServletActionContext.getResponse(); 
		PrintWriter writer = response.getWriter(); 
		String pageErrorInfo = null;
		msg = "successed";
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			is = new FileInputStream(file);
			String root = ServletActionContext.getServletContext().getRealPath("/tables");//���������Ŀ¼
			File deskFile = new File(root,this.getFileFileName());

			//����������
			OutputStream os = new FileOutputStream(deskFile);
			byte [] bytefer = new byte[400];
			int length = 0 ; 
			while((length = is.read(bytefer) )>0)
			{
				os.write(bytefer,0,length);
			}
			os.close();
			is.close();		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			pageErrorInfo = e.getMessage();
			msg = "failed"+pageErrorInfo;
		} catch (IOException e) {
			e.printStackTrace();
			msg = "failed"+pageErrorInfo;
		}finally{
			writer.print(msg);
			writer.flush();  
			writer.close();
		}


	}

	/**
	 * ����б�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String list(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/") + "tables"; //�ļ�����·��
		        
		//��ȡ����java�ļ� 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 
		tables.clear();  
		for (File xlsFileColFile : xlsFileCol) { 
		      String filename = xlsFileColFile.getName();
		      tables.add(filename);
		}
		
		return SUCCESS;
	}
	
	/**
	 * ɾ�����
	 * @return
	 */
	public String delete(){		
		String filepath = ServletActionContext.getServletContext().getRealPath("/") + "tables" + java.io.File.separator; //�ļ�����·��
		try{
			FileUtils.forceDelete(new File(filepath+filename));
			msg = "ɾ���ɹ�";
		}catch (IOException e) {
			msg = "ɾ��ʧ��";
		}

		return SUCCESS;
	}
	
	/**
	 * �������
	 * @return
	 */
	public InputStream getTargetFile(){
		return ServletActionContext.getServletContext().getResourceAsStream("tables/"+filename);
	}
}
