/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：NewsInterfaceAction
 * 
 * 创建日期：2014-09-26
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.mystock.model.FileVO;
import org.mystock.model.NewsIndex;
import org.mystock.model.NewsInfo;
import org.mystock.model.NewsVO;
import org.mystock.service.NewsInfoService;
import org.mystock.service.NewsTypeService;
import org.mystock.service.TableService;
import org.mystock.utils.FtpUtil;
import org.mystock.utils.HibernateMappingManager;
import org.mystock.utils.MessageUtil;
import org.mystock.utils.TimerManager;
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
	private TableService tableService;
	
	int type; //新闻类别编号
	List<NewsIndex> index; //新闻目录列表
	String pg;  //URL
	String cp; //为当前所在的页
	String ls; //每次显示的记录数
	int pid; //新闻ID
	NewsInfo articleInfo; //单个文章信息
	List<NewsVO> articles;//文章简表
	long recorders; //查询到的全部记录数
	String url;
	int page;
	int size;

	String msg;
	
	List<String> tables = new ArrayList<String>();//所有的表格
	List<String> filenames = new ArrayList<String>();//所有上传的文件
	List<String> uploadfiles = new ArrayList<String>();//所有新闻图片
	
	List<FileVO> filelist;//文件信息列表
	
	String ip;//FTP地址
	String username;//FTP用户名
	String password;//FTP密码
	boolean valid;//是否自动上传
		
	private File file;
    private String fileFileName;
    private String fileFileContentType;

    private String message = "你已成功上传图片";
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    public String getFileFileContentType() {
        return fileFileContentType;
    }

    public void setFileFileContentType(String fileFileContentType) {
        this.fileFileContentType = fileFileContentType;
    }
	
	/**
	 * @return the filelist
	 */
	public List<FileVO> getFilelist() {
		return filelist;
	}

	/**
	 * @param filelist the filelist to set
	 */
	public void setFilelist(List<FileVO> filelist) {
		this.filelist = filelist;
	}

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
	 * @return the index
	 */
	public List<NewsIndex> getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(List<NewsIndex> index) {
		this.index = index;
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
	 * @return the articleInfo
	 */
	public NewsInfo getArticleInfo() {
		return articleInfo;
	}

	/**
	 * @param articleInfo the articleInfo to set
	 */
	public void setArticleInfo(NewsInfo articleInfo) {
		this.articleInfo = articleInfo;
	}

	/**
	 * @return the articles
	 */
	public List<NewsVO> getArticles() {
		return articles;
	}

	/**
	 * @param articles the articles to set
	 */
	public void setArticles(List<NewsVO> articles) {
		this.articles = articles;
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
	 * @param tableService the tableService to set
	 */
	public void setTableService(TableService tableService) {
		this.tableService = tableService;
	}

	/**
	 * 取某一类型的文章目录
	 * @return JSON格式的文章目录
	 */
	@Transactional(readOnly=true)
	public String acquireMenu(){
		if (typeService.getNewsTypeById(type)== null){
			return ERROR;
		}
		String newsType = typeService.getNewsTypeById(type).getNewsTypeName();//获取对应的类别名
		List<NewsInfo> all = service.getAllNewsInfoByType(newsType);//获取某类型所有新闻
		index = new ArrayList<NewsIndex>();
		for (int i = 0; i<all.size(); ++i){
			index.add(service.toNewsIndex(all.get(i)));
		}

		return SUCCESS;
	}
	
	/**
	 * 获取某一类型的文章列表，不包含文章内容，可以指定结果集的页号和每页大小，用于翻页显示
	 * @return 属性articles，表示文章列表；属性recorders，表示所有该类型文章的个数；属性url，
	 * 表示查询所用的URL，为常量；属性page，表示当前所在的页；属性size，表示每次显示的记录数。
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
			setArticles(allVO);
			setRecorders(allRecorders);
			setUrl(URL);
			setPage(currentPage);
			setSize(lineSize);
	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setMsg("获取某一类型的文章列表");
		return ERROR;
	}

	/**
	 * 获取某一篇文章的详细内容
	 * @return 属性articleInfo，表示文章详情
	 */
	public String acquireNewsInfo(){
		try {
			NewsInfo pro = service.searchNewsInfo(pid);
			if(pro != null) {
				setArticleInfo(pro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMsg("获取某一篇文章的详细内容错误");
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
		      filelist.add(new FileVO(filename,allFileColFile.length(), new Date(allFileColFile.lastModified())));
		      filenames.add(filename);
		}
		int currentPage = 1 ;	// 为当前所在的页，默认在第1页
		int lineSize = 10;		// 每次显示的记录数
		try{
			currentPage = Integer.parseInt(cp) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(ls) ;
		} catch(Exception e) {}
		
		int end = filenames.size();
		int offset = (currentPage - 1) * lineSize;
		end = lineSize + offset > end ? end : lineSize + offset;
		setFilelist(filelist.subList(offset, end));
		
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
	public String uploadFiles(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //文件保存路径
		
		if (FtpUtil.backupFile(ip, username, password, filepath,"files/"+MessageUtil.getID("config.id"))){
			System.out.println("upladfiles: backup success");
		}else{
			System.out.println("upladfiles: backup fail");
		}
		
		//获取所有文件 
//		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
//				new String[]{"xls","xlsx","ppt","pptx","doc","docx","chm","pdf","txt","rtf","pps","xml","rdf","wsdl","xpdl","xsl","bmp",
//							"png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
//		filenames.clear();  
//		for (File allFileColFile : allFileCol) { 
//		      String filename = allFileColFile.getName();
//		      filenames.add(filename);
//		    //备份文件到FTP
//			if (FtpUtil.backupFile(ip,username,password,filepath + File.separatorChar + filename,
//					"files/" + MessageUtil.getID("config.id")
//							+ File.separatorChar + filename)) {
//				System.out.println("upladfiles:" + filename + " backup success");
//			} else {
//				System.out.println("uploadfiles:" + filename + " backup fail");
//			}
//		}
		ip = null;
		username = null;
		password = null;
		
		return SUCCESS;
	}
	
	/**
	 * 备份新闻图片
	 * @return JSON格式的列表
	 */
	public String uploadNewsPhoto(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/upload"); //文件保存路径
		
		if (FtpUtil.backupFile(ip, username, password, filepath,"upload/"+MessageUtil.getID("config.id"))){
			System.out.println("uploadPhoto: backup success");
		}else{
			System.out.println("uploadPhoto: backup fail");
		}
		
		//获取所有新闻图片
//		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
//				new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
//		uploadfiles.clear();  
//		for (File allFileColFile : allFileCol) { 
//		      String filename = allFileColFile.getName();
//		      uploadfiles.add(filename);
//		    //备份文件到FTP
//			if (FtpUtil.backupFile(ip, username, password, filepath
//					+ File.separatorChar + filename, "upload/"
//					+ MessageUtil.getID("config.id") + File.separatorChar
//					+ filename)) {
//				System.out.println("uploadPhoto:" + filename + " backup success");
//			} else {
//				System.out.println("uploadPhoto:" + filename + " backup fail");
//			}
//		}
		ip = null;
		username = null;
		password = null;
		
		return SUCCESS;
	}
	
	/**
	 * 设置是否自动备份
	 * @return
	 */
	public String changeValid(){
			FtpUtil.setValid(valid);
			TimerManager.isValid=valid;
			if (url!=null&&username!=null&&password!=null){//修改备份配置文件
				if(!HibernateMappingManager.updateHibernateConfig("hibernate_backup.cfg.xml", "connection.url",url)||
						!HibernateMappingManager.updateHibernateConfig("hibernate_backup.cfg.xml", "connection.username",username)||
						!HibernateMappingManager.updateHibernateConfig("hibernate_backup.cfg.xml", "connection.password",password)){
					return ERROR;
				}
			}
		return SUCCESS;
	}
	
	/**
	 * 备份数据库
	 * @return
	 */
	public String backupDatabase(){
		
		if (url!=null&&username!=null&&password!=null){//修改备份配置文件
			if(!HibernateMappingManager.updateHibernateConfig("hibernate_backup.cfg.xml", "connection.url",url)||
					!HibernateMappingManager.updateHibernateConfig("hibernate_backup.cfg.xml", "connection.username",username)||
					!HibernateMappingManager.updateHibernateConfig("hibernate_backup.cfg.xml", "connection.password",password)){
				return ERROR;
			}
		}
		
		System.out.println("start backup..");
		Configuration cfg = new AnnotationConfiguration();
   		SessionFactory sf = cfg.configure("hibernate_backup.cfg.xml").buildSessionFactory();
		service.backup(sf);
		typeService.backup(sf);
		tableService.backup(sf);
		if (sf != null){
				sf.close();
			}
		System.out.println("end backup..");
		
		return SUCCESS;
	}
	
	/**
	 * 查询图片列表
	 * @return 图片地址列表filenames
	 */
	@SuppressWarnings("unchecked")
	public String acquireImagelist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/images"); //文件保存路径
		
		//获取所有图片文件 
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		filenames.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();	     
		      filenames.add(filename);
		}
		int currentPage = 1 ;	// 为当前所在的页，默认在第1页
		int lineSize = 10;		// 每次显示的记录数
		try{
			currentPage = Integer.parseInt(cp) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(ls) ;
		} catch(Exception e) {}
		
		int end = filenames.size();
		int offset = (currentPage - 1) * lineSize;
		end = lineSize + offset > end ? end : lineSize + offset;
		setFilenames(filenames.subList(offset, end));
		
		return SUCCESS;
	}
	
	/**
	 * 上传图片到FTP
	 * @return JSON格式的列表
	 */
	public String uploadImage(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/images"); //文件保存路径
		
		if (FtpUtil.backupFile(ip, username, password, filepath,"images/"+MessageUtil.getID("config.id"))){
			System.out.println("image: backup success");
		}else{
			System.out.println("image: backup fail");
		}
		
		//获取所有图片
//		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
//				new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
//		uploadfiles.clear();  
//		for (File allFileColFile : allFileCol) { 
//		      String filename = allFileColFile.getName();
//		      uploadfiles.add(filename);
//		    //备份文件到FTP
//			if (FtpUtil.backupFile(ip, username, password, filepath
//					+ File.separatorChar + filename, "images/"
//					+ MessageUtil.getID("config.id") + File.separatorChar
//					+ filename)) {
//				System.out.println("image:" + filename + " backup success");
//			} else {
//				System.out.println("image:" + filename + " backup fail");
//			}
//		}
		ip = null;
		username = null;
		password = null;
		
		return SUCCESS;
	}
	
	/**
	 * 上传图片到服务器
	 * @return
	 * @throws Exception
	 */
	public String uploadPhoto() throws Exception {
        
		InputStream is;

		String pageErrorInfo = null;
		message = "successed";
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
			message = "failed"+pageErrorInfo;
			return ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			message = "failed"+pageErrorInfo;
			return ERROR;
		}
        return SUCCESS;
    }

}
