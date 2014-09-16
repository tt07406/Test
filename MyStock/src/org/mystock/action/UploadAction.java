/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：UploadAction
 * 
 * 创建日期：2014-09-16
 */
package org.mystock.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传处理Action，保存上传的文件到tables中
 * @author tt
 * @version 14.9.16
 */
public class UploadAction extends ActionSupport {
	
	private static final Logger log = LoggerFactory.getLogger(UploadAction.class);

	private static final long serialVersionUID = -1154768183800684676L;

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
	 * @return
	 */
	public String execute() throws Exception{

		InputStream is = new FileInputStream(file);
		String root = ServletActionContext.getServletContext().getRealPath("/tables");
		log.info(this.getFileContentType());
		File deskFile = new File(root,this.getFileFileName());
		log.info(this.getFileFileName());
		OutputStream os = new FileOutputStream(deskFile);
		byte [] bytefer = new byte[400];
		int length = 0 ; 
		while((length = is.read(bytefer) )>0)
		{
			os.write(bytefer,0,length);
		}
		os.close();
		is.close();
		return SUCCESS;
	}
}