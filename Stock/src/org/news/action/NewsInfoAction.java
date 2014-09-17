/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsInfoAction
 * 
 * 创建日期：2014-08-19
 */
package org.news.action;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.news.model.Admin;
import org.news.model.NewsAttachment;
import org.news.model.NewsInfo;
import org.news.model.NewsType;
import org.news.model.NewsVO;
import org.news.service.AttachmentService;
import org.news.service.NewsInfoService;
import org.news.service.NewsTypeService;
import org.news.utils.Logger;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于新闻操作的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsInfoAction extends ActionSupport {

	private static final long serialVersionUID = -8036252934049848022L;
	private NewsInfoService service;
	private NewsTypeService typeService;
	private AttachmentService attiService;

	/**
	 * @param attiService the attiService to set
	 */
	public void setAttiService(AttachmentService attiService) {
		this.attiService = attiService;
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

	List<NewsType> types;//所有种类
	String status;//动作状态
	String msg; //提示信息
	String pg;  //URL
	String cp; //为当前所在的页
	String ls; //每次显示的记录数
	int pid; //新闻ID
	NewsInfo newsinfo; //单个新闻信息
	List<NewsAttachment> attachments; //附件表
	String[] typeNames; //选中的种类
	String kw; //查询关键字
	List<NewsVO> newsInfos;//新闻简表
	long recorders; //查询到的全部记录数
	String url;
	int page;
	int size;
	
	String name;
	String describe;
	String author;
	String content;
	String [] typeid;
	
	 // 上传多个文件的集合文本
    private List<File> attachment;
    // /多个上传文件的类型集合
    private List<String> attachmentContextType;
   // 多个上传文件的文件名集合
    private List<String> attachmentFileName;
	
	/**
	 * @return the attachment
	 */
	public List<File> getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(List<File> attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the attachmentContextType
	 */
	public List<String> getAttachmentContextType() {
		return attachmentContextType;
	}

	/**
	 * @param attachmentContextType the attachmentContextType to set
	 */
	public void setAttachmentContextType(List<String> attachmentContextType) {
		this.attachmentContextType = attachmentContextType;
	}

	/**
	 * @return the attachmentFileName
	 */
	public List<String> getAttachmentFileName() {
		return attachmentFileName;
	}

	/**
	 * @param attachmentFileName the attachmentFileName to set
	 */
	public void setAttachmentFileName(List<String> attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * @param describe the describe to set
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the typeid
	 */
	public String[] getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(String[] typeid) {
		this.typeid = typeid;
	}

	/**
	 * @return the uRL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param uRL the uRL to set
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
	 * @return the allRecorders
	 */
	public long getRecorders() {
		return recorders;
	}

	/**
	 * @param allRecorders the allRecorders to set
	 */
	public void setRecorders(long recorders) {
		this.recorders = recorders;
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
	 * @return the typeNames
	 */
	public String[] getTypeNames() {
		return typeNames;
	}

	/**
	 * @param typeNames the typeNames to set
	 */
	public void setTypeNames(String[] typeNames) {
		this.typeNames = typeNames;
	}

	/**
	 * @return the attachments
	 */
	public List<NewsAttachment> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<NewsAttachment> attachments) {
		this.attachments = attachments;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the types
	 */
	public List<NewsType> getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(List<NewsType> types) {
		this.types = types;
	}
	
	/**
	 * 更新新闻
	 * @param smart
	 * @return
	 */
	public String update() {				
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("admin") ;//登录的管理员
		String[] newsType = this.typeid;//一个新闻可能属于多个频道
		int newsInfoId = 0;//新闻ID
		
		setMsg("无法获取类别");
		
		if (admin == null){
			setMsg("您未登录请登录！");
			return "forward";
		}else if (newsType != null){
			NewsInfo news = null;
			StringBuffer type = new StringBuffer();
			for (int i = 0; i<newsType.length; i++){
				type.append(newsType[i]+",");
			}
			setMsg("新闻修改失败！");
			newsInfoId = pid ;
			news = new NewsInfo(newsInfoId,name,describe,content,
					service.searchNewsInfo(newsInfoId).getNewsInfoTime(),author,admin.getAdminId(),type.toString(),1);//创建时间不变
			try {//更新数据库
				if(service.updateNewsInformation(news,attachment,attachmentFileName)){
					setMsg("新闻修改成功！");
					if (attachment!= null){
						attachment.clear();
					}
				}

				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		return ERROR;
	}
	
	/**
	 * 增加新闻
	 * @param smart
	 * @return
	 */
	public String insert(){
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("admin") ;//登录的管理员
		String[] newsType = this.typeid;//一个新闻可能属于多个频道
		int newsInfoId = 0;//新闻ID
		
		setMsg("无法获取类别");
		
		if (admin == null){
			setMsg("您未登录请登录！");
			return "forward";
		}else if (newsType != null){
			NewsInfo news = null;
			StringBuffer type = new StringBuffer();
			for (int i = 0; i<newsType.length; i++){
				type.append(newsType[i]+",");
			}
			setMsg("新闻增加失败！");
			List<NewsInfo> infoList = service.getAllNewsInfo();
			newsInfoId = ((infoList.size() == 0)? 1: (service.getAllNewsInfo().get(0).getNewsInfoId()+1));//新的ID等于最大的ID加1
			news = new NewsInfo(newsInfoId,name,describe,content,
					new Date(new java.util.Date().getTime()),author,admin.getAdminId(),type.toString(),0);//创建时间为当前时间
			try {//更新数据库
				if(service.addNewsInfo(news,attachment,attachmentFileName)){
					setMsg("新闻增加成功！");
					if (attachment!= null){
						attachment.clear();
					}					
				}
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return ERROR;
	}
	
	/**
	 * 新增前的操作
	 * @return
	 */
	public String insertpre(){
		setTypes(typeService.getAllNewsType());	
		return SUCCESS;
	}
	
	/**
	 * 查看新闻信息
	 * @return
	 */
	public String show(){
		try {//获取当前会员VO，传给下个页面
			NewsInfo pro = service.searchNewsInfo(pid);
			if(pro != null) {
				setNewsinfo(pro);

				setAttachments(attiService.findNewsAttachmentByNewsId((long)pid));
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 更新前的操作
	 * @return
	 */
	public String updatepre(){
		try {//获取当前会员VO，传给下个页面
			NewsInfo pro = service.searchNewsInfo(pid);
			String[] typeNames = null;
			setTypes(typeService.getAllNewsType());
			if(pro != null) {
				setNewsinfo(pro);
				typeNames = pro.getNewsType().split(",");
				setTypeNames(typeNames);//被选的种类

				setAttachments(attiService.findNewsAttachmentByNewsId((long)pid));
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 删除新闻信息
	 * @return
	 */
	public String delete(){
		int currentPage = 1 ;	// 为当前所在的页，默认在第1页
		int lineSize = 20;		// 每次显示的记录数
		String page = pg;
		try{
			currentPage = Integer.parseInt(cp) ;
		} catch(Exception e) {}
		try{
			lineSize = Integer.parseInt(ls) ;
		} catch(Exception e) {}
		
		int[] newsId = new int[1];
		newsId[0] = pid;
		try {
			if (service.deleteNewsInfo(newsId)) {
				setMsg(MessageUtil
						.get("newsinfo.delete.true"));
			} else {
				setMsg(MessageUtil
						.get("newsinfo.delete.false"));
			}
			
			//将参数转化成属性传给下个页面
			setPg(page);
			setCp(""+currentPage);
			setLs(""+lineSize);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ERROR;
	}
	
	/**
	 * 获取所有的新闻列表
	 * @return
	 */
	public String list(){
		String URL = "NewsInfo_list.action" ;
		
		try {
			int currentPage = 1 ;	// 为当前所在的页，默认在第1页
			int lineSize = 20;		// 每次显示的记录数
			long allRecorders = 0 ;	// 表示全部的记录数
			String keyWord = getKw();	// 接收查询关键字
			
			Logger.log(keyWord, Logger.INFO);
			try{
				currentPage = Integer.parseInt(cp) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(ls) ;
			} catch(Exception e) {}
			if(keyWord == null){
				keyWord = "" ;	// 如果模糊查询没有关键字，则表示查询全部
			}
			
			List<NewsInfo> all = service.getAllNewsInfo(keyWord,currentPage,lineSize) ;
			List<NewsVO> allVO = new ArrayList<NewsVO>();
			for (int i = 0; i<all.size(); ++i){
				allVO.add(service.toNewsVO(all.get(i)));
			}
			
			allRecorders = service.getAllCount(keyWord) ;
			setNewsInfos(allVO);
			setRecorders(allRecorders);
			setUrl(URL);
			setPage(currentPage);
			setSize(lineSize);
	
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}

}