package org.news.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

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
		String root = ServletActionContext.getServletContext().getRealPath("/softwares");
		System.out.println(this.getFileContentType() );
		File deskFile = new File(root,this.getFileFileName());
		System.out.println(this.getFileFileName() );
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