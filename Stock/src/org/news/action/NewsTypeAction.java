/*
 * 系统名称：新闻发布系统
 * 
 * 类名：NewsTypeAction
 * 
 * 创建日期：2014-08-20
 */
package org.news.action;

import java.util.List;

import org.news.model.NewsType;
import org.news.service.NewsTypeService;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于新闻类别操作的Action
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

	List<NewsType> all;//所示新闻类别
	String name;//类别名
	String note;//类别描述
	String msg;//提示信息
	String url;//URL
	int typeid;//类别ID
	NewsType type;//具体类别

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
	 * 获取所有的文章频道列表
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
	 * 插入频道
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
	 * 更新频道
	 * @return
	 */
	public String update(){

		//根据修改的值新建VO
		NewsType type = new NewsType(0,"","");
		type.setNewsTypeName(name);
		type.setNewsTypeDescripe(note);
		type.setNewsTypeId(typeid);
		try {//更新数据库
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
	 * 更新前的操作
	 * @return
	 */
	public String updatepre(){
		try {//找了ID对应的频道信息
			NewsType type = newstypeService.getNewsTypeById(typeid);
			setType(type);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ERROR;
	}
	
	/**
	 * 删除频道
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
	 * 查看频道信息
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