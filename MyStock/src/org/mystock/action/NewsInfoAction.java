/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInfoAction
 * 
 * �������ڣ�2014-09-25
 */
package org.mystock.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.mystock.model.NewsInfo;
import org.mystock.model.NewsType;
import org.mystock.model.NewsVO;
import org.mystock.service.NewsInfoService;
import org.mystock.service.NewsTypeService;
import org.mystock.utils.MessageUtil;
import org.mystock.model.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �������Ų�����Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsInfoAction extends ActionSupport {

	private static final long serialVersionUID = -8036252934049848022L;
	private NewsInfoService service;
	private NewsTypeService typeService;

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

	List<NewsType> types;//��������
	String status;//����״̬
	String msg; //��ʾ��Ϣ
	String pg;  //URL
	String cp; //Ϊ��ǰ���ڵ�ҳ
	String ls; //ÿ����ʾ�ļ�¼��
	int pid; //����ID
	NewsInfo newsinfo; //����������Ϣ
	String[] typeNames; //ѡ�е�����
	String kw; //��ѯ�ؼ���
	List<NewsVO> newsInfos;//���ż��
	long recorders; //��ѯ����ȫ����¼��
	String url;
	int page;
	int size;
	
	String name;
	String author;
	String content;
	String [] typeid;
	

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
	 * ��������
	 * @param smart
	 * @return
	 */
	public String update() {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("admin") ;//��¼�Ĺ���Ա
		String[] newsType = this.typeid;//һ�����ſ������ڶ��Ƶ��
		int newsInfoId = 0;//����ID
		
		setMsg(MessageUtil.get("gettypes.false"));
		
		if (admin == null){
			setMsg(MessageUtil.get("adminlogin.msg"));
			return "forward";
		}else if (newsType != null){
			NewsInfo news = null;
			StringBuffer type = new StringBuffer();
			for (int i = 0; i<newsType.length; i++){
				type.append(newsType[i]+",");
			}
			setMsg(MessageUtil.get("newsinfo.update.false"));
			newsInfoId = pid ;
			news = new NewsInfo(newsInfoId,name,content,
					service.searchNewsInfo(newsInfoId).getNewsInfoTime(),author,type.toString(),admin.getAdminName());//����ʱ�䲻��
			try {//�������ݿ�
				if(service.updateNewsInformation(news)){
					setMsg(MessageUtil.get("newsinfo.update.true"));
				}

				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		return ERROR;
	}
	
	/**
	 * ��������
	 * @param smart
	 * @return
	 */
	public String insert(){
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("admin") ;//��¼�Ĺ���Ա
		String[] newsType = this.typeid;//һ�����ſ������ڶ��Ƶ��
		int newsInfoId = 0;//����ID
		
		setMsg(MessageUtil.get("gettypes.false"));
		
		if (admin == null){
			setMsg(MessageUtil.get("adminlogin.msg"));
			return "forward";
		}else if (newsType != null){
			NewsInfo news = null;
			StringBuffer type = new StringBuffer();
			for (int i = 0; i<newsType.length; i++){
				type.append(newsType[i]+",");
			}
			setMsg(MessageUtil.get("newsinfo.insert.false"));
			List<NewsInfo> infoList = service.getAllNewsInfo();
			newsInfoId = ((infoList.size() == 0)? 1: (service.getAllNewsInfo().get(0).getNewsInfoId()+1));//�µ�ID��������ID��1
			news = new NewsInfo(newsInfoId,name,content,
					new Date(new java.util.Date().getTime()),author,type.toString(),admin.getAdminName());//����ʱ��Ϊ��ǰʱ��
			try {//�������ݿ�
				if(service.addNewsInfo(news)){
					setMsg(MessageUtil.get("newsinfo.insert.true"));			
				}
				return SUCCESS;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		return ERROR;
	}
	
	/**
	 * ����ǰ�Ĳ���
	 * @return
	 */
	public String insertpre(){
		setTypes(typeService.getAllNewsType());	
		return SUCCESS;
	}
	
	/**
	 * �鿴������Ϣ
	 * @return
	 */
	public String show(){
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(pid);
			if(pro != null) {
				setNewsinfo(pro);
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ����ǰ�Ĳ���
	 * @return
	 */
	public String updatepre(){
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(pid);
			String[] typeNames = null;
			setTypes(typeService.getAllNewsType());
			if(pro != null) {
				setNewsinfo(pro);
				typeNames = pro.getNewsType().split(",");
				setTypeNames(typeNames);//��ѡ������
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ɾ��������Ϣ
	 * @return
	 */
	public String delete(){
		int currentPage = 1 ;	// Ϊ��ǰ���ڵ�ҳ��Ĭ���ڵ�1ҳ
		int lineSize = 20;		// ÿ����ʾ�ļ�¼��
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
			
			//������ת�������Դ����¸�ҳ��
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
	 * ��ȡ���е������б�
	 * @return
	 */
	public String list(){
		String URL = "NewsInfo_list.action" ;
		
		try {
			int currentPage = 1 ;	// Ϊ��ǰ���ڵ�ҳ��Ĭ���ڵ�1ҳ
			int lineSize = 20;		// ÿ����ʾ�ļ�¼��
			long allRecorders = 0 ;	// ��ʾȫ���ļ�¼��
			String keyWord = getKw();	// ���ղ�ѯ�ؼ���

			try{
				currentPage = Integer.parseInt(cp) ;
			} catch(Exception e) {}
			try{
				lineSize = Integer.parseInt(ls) ;
			} catch(Exception e) {}
			if(keyWord == null){
				keyWord = "" ;	// ���ģ����ѯû�йؼ��֣����ʾ��ѯȫ��
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