/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：TableAction
 * 
 * 创建日期：2014-09-25
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
import org.mystock.utils.FtpUtil;
import org.mystock.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于上传操作的Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class FileUploadAction extends ActionSupport {

	private static final long serialVersionUID = -5244341070259281864L;

	String msg = null ;//提示信息
	List<String> tables = new ArrayList<String>();//所有的表格
	List<String> documents = new ArrayList<String>();//所有文档
	List<String> images = new ArrayList<String>();//所有图片

    String filename;//下载文件名
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
	 * @return the documents
	 */
	public List<String> getDocuments() {
		return documents;
	}



	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(List<String> documents) {
		this.documents = documents;
	}



	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}



	/**
	 * @param images the images to set
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}



	/**
	 * 默认上传
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
			String root = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files");//保存文件的目录
			
			//将后缀名改成小写
			String name =this.getFileFileName();
			int pos = name.lastIndexOf(".");
			String suffix = name.substring(pos);
			String newName = name.substring(0,pos)+suffix.toLowerCase();
			
			File deskFile = new File(root,newName);

			//输出到外存中
			OutputStream os = new FileOutputStream(deskFile);
			byte [] bytefer = new byte[400];
			int length = 0 ; 
			while((length = is.read(bytefer) )>0)
			{
				os.write(bytefer,0,length);
			}
			os.close();
			is.close();		
			
			if (FtpUtil.isValid()){
				//备份文件到FTP
				if(FtpUtil.backupFile(root+File.separatorChar+newName, newName, "files/"+MessageUtil.getID("config.id"))){
					System.out.println("file:"+newName+" backup success");
				}else{
					System.out.println("file:"+newName+" backup fail");
				}
			}
			
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
	 * 图片上传
	 * @return
	 * @throws IOException 
	 */
	public void uploadImage() throws IOException {
		InputStream is;

		HttpServletResponse response = ServletActionContext.getResponse(); 
		PrintWriter writer = response.getWriter(); 
		String pageErrorInfo = null;
		msg = "successed";
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			is = new FileInputStream(file);
			String root = ServletActionContext.getServletContext().getRealPath("/images");//保存图片的目录
			
			//将后缀名改成小写
			String name =this.getFileFileName();
			int pos = name.lastIndexOf(".");
			String suffix = name.substring(pos);
			String newName = name.substring(0,pos)+suffix.toLowerCase();
			
			File deskFile = new File(root,newName);

			//输出到外存中
			OutputStream os = new FileOutputStream(deskFile);
			byte [] bytefer = new byte[400];
			int length = 0 ; 
			while((length = is.read(bytefer) )>0)
			{
				os.write(bytefer,0,length);
			}
			os.close();
			is.close();		
			
			if (FtpUtil.isValid()){
				//备份文件到FTP
				if(FtpUtil.backupFile(root+File.separatorChar+newName, newName, "images/"+MessageUtil.getID("config.id"))){
					System.out.println("image:"+newName+" backup success");
				}else{
					System.out.println("image:"+newName+" backup fail");
				}
			}
			
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
	 * 表格列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String tablelist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //文件保存路径
		
		//获取所有表格文件 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 
		tables.clear();  
		for (File xlsFileColFile : xlsFileCol) { 
		      String filename = xlsFileColFile.getName();
		      tables.add(filename);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 文档列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String documentlist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //文件保存路径
		
		//获取所有文档文件 
		Collection<File> docFileCol = FileUtils.listFiles(new File(filepath), new String[]{"ppt","pptx","doc","docx","chm","pdf","txt","rtf","pps","xml","rdf","wsdl","xpdl","xsl"}, true); 
		documents.clear();  
		for (File docFileColFile : docFileCol) { 
		      String filename = docFileColFile.getName();
		      documents.add(filename);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 图片列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String imagelist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //文件保存路径
		
		//获取所有文档文件 
		Collection<File> imageFileCol = FileUtils.listFiles(new File(filepath), new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		images.clear();  
		for (File imagesFileColFile : imageFileCol) { 
		      String filename = imagesFileColFile.getName();
		      images.add(filename);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 删除文件
	 * @return
	 */
	public String delete(){		
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files") + java.io.File.separator; //文件保存路径
		try{
			FileUtils.forceDelete(new File(filepath+filename));
			msg = "删除成功";
		}catch (IOException e) {
			msg = "删除失败";
		}

		return SUCCESS;
	}
	
	/**
	 * 下载文件
	 * @return
	 */
	public InputStream getTargetFile(){
		return ServletActionContext.getServletContext().getResourceAsStream("WEB-INF/files/"+filename);
	}
}
