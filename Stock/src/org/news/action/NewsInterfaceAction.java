/*
 * 系统名称：斯多克科技门户网站
 * 
 * 类名：NewsInfoAction
 * 
 * 创建日期：2014-09-18
 */
package org.news.action;

import java.util.ArrayList;
import java.util.List;

import org.news.model.NewsAttachment;
import org.news.model.NewsIndex;
import org.news.model.NewsInfo;
import org.news.model.NewsVO;
import org.news.service.AttachmentService;
import org.news.service.NewsInfoService;
import org.news.service.NewsTypeService;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 为前端访问提供接口的的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsInterfaceAction extends ActionSupport {

	private static final long serialVersionUID = 8726165028217895272L;

	private NewsInfoService service;
	private NewsTypeService typeService;
	private AttachmentService attiService;
	
	int type; //新闻类别编号
	List<NewsIndex> allVO; //新闻目录列表
	List<NewsAttachment> attachments;//附件表
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
	List<NewsAttachment> softwares;//软件列表
	String msg;

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
	 * @param service the service to set
	 */
	public void setService(NewsInfoService service) {
		this.service = service;
	}

	/**
	 * @param attiService the attiService to set
	 */
	public void setAttiService(AttachmentService attiService) {
		this.attiService = attiService;
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
	@Transactional(readOnly=true)
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
	@Transactional(readOnly=true)
	public String acquireNewsInfo(){
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
		setMsg("获取某一条新闻的详细内容错误");
		return ERROR;
	}
	
	/**
	 * 获取软件列表
	 * @return JSON格式的软件列表
	 */
	@Transactional(readOnly=true)
	public String acquireSoftwarelist(){
		softwares = attiService.findNewsAttachmentByNewsId(0);//找到所有的软件信息	
		return SUCCESS;
	}

}