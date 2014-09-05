/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsTypeAction
 * 
 * �������ڣ�2014-08-20
 */
package org.news.action;

import java.util.List;

import org.news.model.NewsType;
import org.news.service.NewsTypeService;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ����������������Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class NewsTypeAction extends ActionSupport {

	private static final long serialVersionUID = 3250411979866462436L;
	private NewsTypeService newstypeService;
	
	/**
	 * @param newstypeService the newstypeService to set
	 */
	public void setNewstypeService(NewsTypeService newstypeService) {
		this.newstypeService = newstypeService;
	}

	List<NewsType> all;//��ʾ�������
	String name;//�����
	String note;//�������
	String msg;//��ʾ��Ϣ
	String url;//URL
	int typeid;//���ID
	NewsType type;//�������

	/**
	 * @return the type
	 */
	public NewsType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(NewsType type) {
		this.type = type;
	}

	/**
	 * @return the typeid
	 */
	public int getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid the typeid to set
	 */
	public void setTypeid(int typeid) {
		this.typeid = typeid;
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
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
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
	 * @return the all
	 */
	public List<NewsType> getAll() {
		return all;
	}

	/**
	 * @param all the all to set
	 */
	public void setAll(List<NewsType> all) {
		this.all = all;
	}

	/**
	 * @return
	 */
	public String execute() {
		return SUCCESS;
	}
	
	/**
	 * ��ȡ���е�����Ƶ���б�
	 * @return
	 */
	public String list(){
		try {
			setAll(newstypeService.getAllNewsType());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ����Ƶ��
	 * @return
	 */
	public String insert(){
		try {
			if (newstypeService.addNewsType(name, note)) {
				setMsg(MessageUtil
						.get("newstype.insert.true"));
			} else {
				setMsg(MessageUtil
						.get("newstype.insert.false"));
			}
			setUrl("newstype_insert.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ����Ƶ��
	 * @return
	 */
	public String update(){

		//�����޸ĵ�ֵ�½�VO
		NewsType type = new NewsType(0,"","");
		type.setNewsTypeName(name);
		type.setNewsTypeDescripe(note);
		type.setNewsTypeId(typeid);
		try {//�������ݿ�
			if (newstypeService.updateNewsType(type)) {
				setMsg(MessageUtil
						.get("newstype.update.true"));
			} else {
				setMsg(MessageUtil
						.get("newstype.update.false"));
			}
			setUrl("NewsType_list.action");
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
		try {//����ID��Ӧ��Ƶ����Ϣ
			NewsType type = newstypeService.getNewsTypeById(typeid);
			setType(type);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * ɾ��Ƶ��
	 * @return
	 */
	public String delete(){
		try {
			if(newstypeService.deleteNewsType(typeid)){
				setMsg(MessageUtil
						.get("newstype.delete.true"));
			} else {
				setMsg(MessageUtil
						.get("newstype.delete.false"));
			}
			setUrl("NewsType_list.action");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * �鿴Ƶ����Ϣ
	 * @return
	 */
	public String show(){
		try {
			NewsType type = newstypeService.getNewsTypeById(typeid);
			setType(type);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
}