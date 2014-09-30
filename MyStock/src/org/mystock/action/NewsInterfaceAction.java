/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsInterfaceAction
 * 
 * 创建日期：2014-09-26
 */
package org.mystock.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.mystock.model.NewsIndex;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsVO;
import org.mystock.service.NewsInfoService;
import org.mystock.service.NewsTypeService;
import org.mystock.utils.FtpUtil;
import org.mystock.utils.MessageUtil;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 为前端访问提供接口的的Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class NewsInterfaceAction extends ActionSupport {

	private static final long serialVersionUID = 8726165028217895272L;

	private NewsInfoService service;
	private NewsTypeService typeService;
	
	int type; //新闻类别编号
	List<NewsIndex> allVO; //新闻目录列表
	String pg;  //URL
	String cp; //为当前所在的页
	String ls; //每次显示的记录数
	int pid; //新闻ID
	NewsInfo newsinfo; //单个新闻信息
	List<NewsVO> newsInfos;//新闻简表
	long recorders; //查询到的全部记录数
	String url;
	int page;
	int size;

	String msg;
	
	List<String> tables = new ArrayList<String>();//所有的表格
	List<String> filenames = new ArrayList<String>();//所有上传的文件
	List<String> uploadfiles = new ArrayList<String>();//所有新闻图片
	
	String ip;//FTP地址
	String username;//FTP用户名
	String password;//FTP密码
	boolean valid;//是否自动上传
		
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean isValid() {
		return FtpUtil.isValid();
	}

	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<String> getFilenames() {
		return filenames;
	}



	public void setFilenames(List<String> filenames) {
		this.filenames = filenames;
	}



	public List<String> getUploadfiles() {
		return uploadfiles;
	}



	public void setUploadfiles(List<String> uploadfiles) {
		this.uploadfiles = uploadfiles;
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}



	/**
	 * @return the allVO
	 */
	public List<NewsIndex> getAllVO() {
		return allVO;
	}



	/**
	 * @param allVO the allVO to set
	 */
	public void setAllVO(List<NewsIndex> allVO) {
		this.allVO = allVO;
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
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}



	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}



	/**
	 * @return the newsinfo
	 */
	public NewsInfo getNewsinfo() {
		return newsinfo;
	}



	/**
	 * @param newsinfo the newsinfo to set
	 */
	public void setNewsinfo(NewsInfo newsinfo) {
		this.newsinfo = newsinfo;
	}



	/**
	 * @return the newsInfos
	 */
	public List<NewsVO> getNewsInfos() {
		return newsInfos;
	}



	/**
	 * @param newsInfos the newsInfos to set
	 */
	public void setNewsInfos(List<NewsVO> newsInfos) {
		this.newsInfos = newsInfos;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}



	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}



	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}



	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}



	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}



	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}


	/**
	 * @param service the service to set
	 */
	public void setService(NewsInfoService service) {
		this.service = service;
	}

	/**
	 * @param typeService the typeService to set
	 */
	public void setTypeService(NewsTypeService typeService) {
		this.typeService = typeService;
	}

	/**
	 * 取某一类型的新闻目录
	 * @return JSON格式的新闻目录
	 */
	@Transactional(readOnly=true)
	public String acquireMenu(){
		String newsType = typeService.getNewsTypeById(type).getNewsTypeName();//获取对应的类别名
		List<NewsInfo> all = service.getAllNewsInfoByType(newsType);//获取某类型所有新闻
		allVO = new ArrayList<NewsIndex>();
		for (int i = 0; i<all.size(); ++i){
			allVO.add(service.toNewsIndex(all.get(i)));
		}

		return SUCCESS;
	}
	
	/**
	 * 获取某一类型的新闻列表，不包含新闻内容，可以指定结果集的页号和每页大小，用于翻页显示
	 * @return 属性newsInfos，表示新闻列表；属性recorders，表示所有该类型新闻的个数；属性url，表示查询所用的URL，为常量；属性page，表示当前所在的页；属性size，表示每次显示的记录数。
	 */
	public String acquireNewsList(){
		String URL = "/interface/acquireNewsList.action" ;
		
		try {
			int currentPage = 1 ;	// 为当前所在的页，默认在第1页
			int lineSize = 10;		// 每次显示的记录数
			long allRecorders = 0 ;	// 表示全部的记录数

			String newsType = typeService.getNewsTypeById(type).getNewsTypeName();
			try{
				currentPage = Integer.parseInt(cp) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(ls) ;
			} catch(Exception e) {}
			
			//获取该类别某一页的数据
			List<NewsInfo> all = service.getAllNewsInfoByType(newsType,currentPage,lineSize) ;
			List<NewsVO> allVO = new ArrayList<NewsVO>();
			for (int i = 0; i<all.size(); ++i){
				allVO.add(service.toNewsVO(all.get(i)));
			}
			
			allRecorders = service.getAllNewsInfoByType(newsType).size() ;
			setNewsInfos(allVO);
			setRecorders(allRecorders);
			setUrl(URL);
			setPage(currentPage);
			setSize(lineSize);
	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setMsg("获取某一类型的新闻列表错误");
		return ERROR;
	}

	/**
	 * 获取某一条新闻的详细内容
	 * @return 属性newsinfo，表示新闻信息详情；属性attachments，表示该新闻所带的所有附件列表
	 */
	public String acquireNewsInfo(){
		try {//获取当前会员VO，传给下个页面
			NewsInfo pro = service.searchNewsInfo(pid);
			if(pro != null) {
				setNewsinfo(pro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMsg("获取某一条新闻的详细内容错误");
		return ERROR;
	}
	
	/**
	 * 获取Excel列表
	 * @return JSON格式的表格列表
	 */
	@SuppressWarnings("unchecked")
	public String acquireTablelist(){
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
	 * 获取上传文件列表
	 * @return JSON格式的列表
	 */
	@SuppressWarnings("unchecked")
	public String acquireFilelist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //文件保存路径
		
		//获取所有文件 
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"xls","xlsx","ppt","pptx","doc","docx","chm","pdf","txt","rtf","pps","xml","rdf","wsdl","xpdl","xsl","bmp",
							"png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		filenames.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();
		      filenames.add(filename);
		}
		
		return SUCCESS;
	}

	/**
	 * 获取新闻图片列表
	 * @return JSON格式的列表
	 */
	@SuppressWarnings("unchecked")
	public String acquireNewsPhotolist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/upload"); //文件保存路径
		
		//获取所有新闻图片
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		uploadfiles.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();
		      uploadfiles.add(filename);
		}
		
		return SUCCESS;
	}
	
	/**
	 * 备份文件
	 * @return JSON格式的列表
	 */
	@SuppressWarnings("unchecked")
	public String uploadFiles(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //文件保存路径
		
		//获取所有文件 
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"xls","xlsx","ppt","pptx","doc","docx","chm","pdf","txt","rtf","pps","xml","rdf","wsdl","xpdl","xsl","bmp",
							"png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		filenames.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();
		      filenames.add(filename);
		    //备份文件到FTP
			if (FtpUtil.backupFile(ip,username,password,filepath + File.separatorChar + filename,
					"files/" + MessageUtil.getID("config.id")
							+ File.separatorChar + filename)) {
				System.out.println("upladfiles:" + filename + " backup success");
			} else {
				System.out.println("uploadfiles:" + filename + " backup fail");
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 备份新闻图片
	 * @return JSON格式的列表
	 */
	@SuppressWarnings("unchecked")
	public String uploadNewsPhoto(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/upload"); //文件保存路径
		
		//获取所有新闻图片
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		uploadfiles.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();
		      uploadfiles.add(filename);
		    //备份文件到FTP
			if (FtpUtil.backupFile(ip, username, password, filepath
					+ File.separatorChar + filename, "upload/"
					+ MessageUtil.getID("config.id") + File.separatorChar
					+ filename)) {
				System.out.println("uploadPhoto:" + filename + " backup success");
			} else {
				System.out.println("uploadPhoto:" + filename + " backup fail");
			}
		}
		
		return SUCCESS;
	}
	
	public String changeValid(){
			FtpUtil.setValid(valid);
		return SUCCESS;
	}
}
