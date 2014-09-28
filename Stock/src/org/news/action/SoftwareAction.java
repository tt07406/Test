/*
 * 系统名称：新闻发布系统
 * 
 * 类名：SoftwareAction
 * 
 * 创建日期：2014-08-22
 */
package org.news.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.news.model.NewsAttachment;
import org.news.service.AttachmentService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于软件操作的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class SoftwareAction extends ActionSupport{

	private static final long serialVersionUID = 4362240508650937317L;
	private AttachmentService service;
	
	/**
	 * @param service the service to set
	 */
	public void setService(AttachmentService service) {
		this.service = service;
	}

	String msg = null ;//提示信息
	String kw; //查询关键字
	String cp; //当前页
	String ls; //页的大小
	String pg = "Software_list.action"; //URL
	List<NewsAttachment> softwares;//软件列表
	long recorders; //软件数
	int softwareid;//软件ID
	Long sid; //下载软件ID
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
		this.filename = filename;
	}

	/**
	 * @return the sid
	 */
	public Long getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(Long sid) {
		this.sid = sid;
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
	 * @return the kw
	 */
	public String getKw() {
		return kw;
	}

	/**
	 * @param kw the kw to set
	 */
	public void setKw(String kw) {
		this.kw = kw;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the ls
	 */
	public String getLs() {
		return ls;
	}

	/**
	 * @param ls the ls to set
	 */
	public void setLs(String ls) {
		this.ls = ls;
	}

	/**
	 * @return the pg
	 */
	public String getPg() {
		return pg;
	}

	/**
	 * @param pg the pg to set
	 */
	public void setPg(String pg) {
		this.pg = pg;
	}

	/**
	 * @return the softwares
	 */
	public List<NewsAttachment> getSoftwares() {
		return softwares;
	}

	/**
	 * @param softwares the softwares to set
	 */
	public void setSoftwares(List<NewsAttachment> softwares) {
		this.softwares = softwares;
	}

	/**
	 * @return the recorders
	 */
	public long getRecorders() {
		return recorders;
	}

	/**
	 * @param recorders the recorders to set
	 */
	public void setRecorders(long recorders) {
		this.recorders = recorders;
	}

	/**
	 * @return the softwareid
	 */
	public int getSoftwareid() {
		return softwareid;
	}

	/**
	 * @param softwareid the softwareid to set
	 */
	public void setSoftwareid(int softwareid) {
		this.softwareid = softwareid;
	}
	
	/**
	 * 默认上传
	 * @return
	 * @throws IOException 
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void upload() throws IOException {
		InputStream is;

		HttpServletResponse response = ServletActionContext.getResponse(); 
		PrintWriter writer = response.getWriter(); 
		String pageErrorInfo = null;
		msg = "successed";
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
			is = new FileInputStream(file);
			String root = ServletActionContext.getServletContext().getRealPath("/WEB-INF/softwares");//保存软件的目录
			File deskFile = new File(root,this.getFileFileName());

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
			
			//软件在附件中newsid为0,且只保存名称
			NewsAttachment newsAttachment=new NewsAttachment();
			newsAttachment.setNewsId((long)0);
			newsAttachment.setAttachmentName(filename);
			if (!service.addNewsAttachment(newsAttachment)){
				service.deleteFile(root+File.separator+filename);//插入失败，删除文件
				msg = "failed"+pageErrorInfo;
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
	 * 软件列表
	 * @return
	 */
	@Transactional(readOnly=true)
	public String list(){
		int currentPage = 1 ;	// 为当前所在的页，默认在第1页
		int lineSize = 20;		// 每次显示的记录数
		long allRecorders = 0 ;	// 表示全部的记录数
		String keyWord = kw ;	// 接收查询关键字
		
		try{
			currentPage = Integer.parseInt(cp) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(ls) ;
		} catch(Exception e) {}
		if(keyWord == null){
			keyWord = "" ;	// 如果模糊查询没有关键字，则表示查询全部
		}
		
		List<NewsAttachment> attachments = service.getAllSoftwares(keyWord, currentPage, lineSize);
		allRecorders = service.getCount(keyWord);
		setSoftwares(attachments);
		setRecorders(allRecorders);
		
		setCp(""+currentPage);
		setLs(""+lineSize);
		
		return SUCCESS;
	}
	
	/**
	 * 删除软件
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public String delete(){		
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/softwares") + java.io.File.separator; //文件保存路径
		String name = service.findNewsAttachmentById(softwareid).getAttachmentName();
		if (service.deleteAttachment(softwareid)&&service.deleteFile(filepath+name)){//同时删除数据库和文件夹里的数据					
			msg = "删除成功";
		}else{
			msg = "删除失败";
		}

		return SUCCESS;
	}
	
	/**
	 * 下载软件
	 * @return
	 */
	public InputStream getTargetFile(){
		NewsAttachment attachment = service.findNewsAttachmentById(sid);
		//String filepath = ServletActionContext.getServletContext().getRealPath("/")+"softwares"+File.separator; //文件保存路径
	    filename = attachment.getAttachmentName();

		return ServletActionContext.getServletContext().getResourceAsStream("WEB-INF/softwares/"+filename);
	}

}