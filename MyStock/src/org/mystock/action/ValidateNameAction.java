/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：ValidateNameAction
 * 
 * 创建日期：2014-09-25
 */
package org.mystock.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.mystock.service.NewsTypeService;

import com.opensymphony.xwork2.ActionSupport;
import org.mystock.utils.Constant.Type;
import org.mystock.service.AdminService;

/**
 * 验证重复性输入的Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class ValidateNameAction extends ActionSupport {

	private static final long serialVersionUID = 7238313406542433777L;

	private NewsTypeService newstypeService;
	private AdminService adminService;
	
	/**
	 * @param newstypeService the newstypeService to set
	 */
	public void setNewstypeService(NewsTypeService newstypeService) {
		this.newstypeService = newstypeService;
	}
	/**
	 * @param adminService the adminService to set
	 */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	
	private String userName;//注册的用户账号
	private String tip;//返回的提示
	private int type = 0;//0为会员，1为管理员，3为新闻类别，4为新闻标题

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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public InputStream getTip() throws IOException{
		return new ByteArrayInputStream(tip.getBytes("utf-8"));
	}
	public String execute() {
		Type style = Type.values()[this.type];
		
		switch (style){
			case NEWSTYPE:
				if (newstypeService.findNewsTypeName(userName)){
					tip = "<span style='color:red'>" + userName + "已存在，请重新输入</span>";
				}else{
					tip = "";
				}
				break;
			case ADMIN:
				if (adminService.findAdminName(userName)){
					tip = "<span style='color:red'>" + userName + "已存在，请重新输入</span>";
				}else{
					tip = "";
				}
				break;
			default:
				break;
		}
	
		
		return SUCCESS;
	}
}