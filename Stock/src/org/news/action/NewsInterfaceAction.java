/*
 * ϵͳ���ƣ�˹��˿Ƽ��Ż���վ
 * 
 * ������NewsInfoAction
 * 
 * �������ڣ�2014-09-18
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
 * Ϊǰ�˷����ṩ�ӿڵĵ�Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsInterfaceAction extends ActionSupport {

	private static final long serialVersionUID = 8726165028217895272L;

	private NewsInfoService service;
	private NewsTypeService typeService;
	private AttachmentService attiService;
	
	int type; //���������
	List<NewsIndex> allVO; //����Ŀ¼�б�
	List<NewsAttachment> attachments;//������
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
	List<NewsAttachment> softwares;//�����б�
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
	 * ��ȡĳһ���͵������б����������������ݣ�����ָ���������ҳ�ź�ÿҳ��С�����ڷ�ҳ��ʾ
	 * @return ����newsInfos����ʾ�����б�������recorders����ʾ���и��������ŵĸ���������url����ʾ��ѯ���õ�URL��Ϊ����������page����ʾ��ǰ���ڵ�ҳ������size����ʾÿ����ʾ�ļ�¼����
	 */
	@Transactional(readOnly=true)
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
		
		setMsg("��ȡĳһ���͵������б�����");
		return ERROR;
	}

	/**
	 * ��ȡĳһ�����ŵ���ϸ����
	 * @return ����newsinfo����ʾ������Ϣ���飻����attachments����ʾ���������������и����б�
	 */
	@Transactional(readOnly=true)
	public String acquireNewsInfo(){
		try {//��ȡ��ǰ��ԱVO�������¸�ҳ��
			NewsInfo pro = service.searchNewsInfo(pid);
			if(pro != null) {
				setNewsinfo(pro);
				setAttachments(attiService.findNewsAttachmentByNewsId((long)pid));
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		setMsg("��ȡĳһ�����ŵ���ϸ���ݴ���");
		return ERROR;
	}
	
	/**
	 * ��ȡ�����б�
	 * @return JSON��ʽ�������б�
	 */
	@Transactional(readOnly=true)
	public String acquireSoftwarelist(){
		softwares = attiService.findNewsAttachmentByNewsId(0);//�ҵ����е�������Ϣ	
		return SUCCESS;
	}

}