/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInterfaceAction
 * 
 * �������ڣ�2014-09-26
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
 * Ϊǰ�˷����ṩ�ӿڵĵ�Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class NewsInterfaceAction extends ActionSupport {

	private static final long serialVersionUID = 8726165028217895272L;

	private NewsInfoService service;
	private NewsTypeService typeService;
	
	int type; //���������
	List<NewsIndex> allVO; //����Ŀ¼�б�
	String pg;  //URL
	String cp; //Ϊ��ǰ���ڵ�ҳ
	String ls; //ÿ����ʾ�ļ�¼��
	int pid; //����ID
	NewsInfo newsinfo; //����������Ϣ
	List<NewsVO> newsInfos;//���ż��
	long recorders; //��ѯ����ȫ����¼��
	String url;
	int page;
	int size;

	String msg;
	
	List<String> tables = new ArrayList<String>();//���еı��
	List<String> filenames = new ArrayList<String>();//�����ϴ����ļ�
	List<String> uploadfiles = new ArrayList<String>();//��������ͼƬ
	
	String ip;//FTP��ַ
	String username;//FTP�û���
	String password;//FTP����
	boolean valid;//�Ƿ��Զ��ϴ�
		
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
	 * ȡĳһ���͵�����Ŀ¼
	 * @return JSON��ʽ������Ŀ¼
	 */
	@Transactional(readOnly=true)
	public String acquireMenu(){
		String newsType = typeService.getNewsTypeById(type).getNewsTypeName();//��ȡ��Ӧ�������
		List<NewsInfo> all = service.getAllNewsInfoByType(newsType);//��ȡĳ������������
		allVO = new ArrayList<NewsIndex>();
		for (int i = 0; i<all.size(); ++i){
			allVO.add(service.toNewsIndex(all.get(i)));
		}

		return SUCCESS;
	}
	
	/**
	 * ��ȡĳһ���͵������б��������������ݣ�����ָ���������ҳ�ź�ÿҳ��С�����ڷ�ҳ��ʾ
	 * @return ����newsInfos����ʾ�����б�����recorders����ʾ���и��������ŵĸ���������url����ʾ��ѯ���õ�URL��Ϊ����������page����ʾ��ǰ���ڵ�ҳ������size����ʾÿ����ʾ�ļ�¼����
	 */
	public String acquireNewsList(){
		String URL = "/interface/acquireNewsList.action" ;
		
		try {
			int currentPage = 1 ;	// Ϊ��ǰ���ڵ�ҳ��Ĭ���ڵ�1ҳ
			int lineSize = 10;		// ÿ����ʾ�ļ�¼��
			long allRecorders = 0 ;	// ��ʾȫ���ļ�¼��

			String newsType = typeService.getNewsTypeById(type).getNewsTypeName();
			try{
				currentPage = Integer.parseInt(cp) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(ls) ;
			} catch(Exception e) {}
			
			//��ȡ�����ĳһҳ������
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
		
		setMsg("��ȡĳһ���͵������б����");
		return ERROR;
	}

	/**
	 * ��ȡĳһ�����ŵ���ϸ����
	 * @return ����newsinfo����ʾ������Ϣ���飻����attachments����ʾ���������������и����б�
	 */
	public String acquireNewsInfo(){
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(pid);
			if(pro != null) {
				setNewsinfo(pro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMsg("��ȡĳһ�����ŵ���ϸ���ݴ���");
		return ERROR;
	}
	
	/**
	 * ��ȡExcel�б�
	 * @return JSON��ʽ�ı���б�
	 */
	@SuppressWarnings("unchecked")
	public String acquireTablelist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //�ļ�����·��
		
		//��ȡ���б���ļ� 
		Collection<File> xlsFileCol = FileUtils.listFiles(new File(filepath), new String[]{"xls","xlsx"}, true); 
		tables.clear();  
		for (File xlsFileColFile : xlsFileCol) { 
		      String filename = xlsFileColFile.getName();
		      tables.add(filename);
		}
		
		return SUCCESS;
	}
	
	/**
	 * ��ȡ�ϴ��ļ��б�
	 * @return JSON��ʽ���б�
	 */
	@SuppressWarnings("unchecked")
	public String acquireFilelist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //�ļ�����·��
		
		//��ȡ�����ļ� 
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
	 * ��ȡ����ͼƬ�б�
	 * @return JSON��ʽ���б�
	 */
	@SuppressWarnings("unchecked")
	public String acquireNewsPhotolist(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/upload"); //�ļ�����·��
		
		//��ȡ��������ͼƬ
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
	 * �����ļ�
	 * @return JSON��ʽ���б�
	 */
	@SuppressWarnings("unchecked")
	public String uploadFiles(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/files"); //�ļ�����·��
		
		//��ȡ�����ļ� 
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"xls","xlsx","ppt","pptx","doc","docx","chm","pdf","txt","rtf","pps","xml","rdf","wsdl","xpdl","xsl","bmp",
							"png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		filenames.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();
		      filenames.add(filename);
		    //�����ļ���FTP
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
	 * ��������ͼƬ
	 * @return JSON��ʽ���б�
	 */
	@SuppressWarnings("unchecked")
	public String uploadNewsPhoto(){
		String filepath = ServletActionContext.getServletContext().getRealPath("/upload"); //�ļ�����·��
		
		//��ȡ��������ͼƬ
		Collection<File> allFileCol = FileUtils.listFiles(new File(filepath), 
				new String[]{"bmp","png","gif","jpeg","jpg","pjpeg","x-png","jpe"}, true); 
		uploadfiles.clear();  
		for (File allFileColFile : allFileCol) { 
		      String filename = allFileColFile.getName();
		      uploadfiles.add(filename);
		    //�����ļ���FTP
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
