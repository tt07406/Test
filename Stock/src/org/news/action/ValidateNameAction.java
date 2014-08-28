/*
 * 系统名称：新闻发布系统
 * 
 * 类名：ValidateNameAction
 * 
 * 创建日期：2014-08-27
 */
package org.news.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.news.service.AdminService;
import org.news.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 验证重复性输入的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class ValidateNameAction extends ActionSupport {

	private static final long serialVersionUID = 7238313406542433777L;
	private UserService userService = new UserService();
	private AdminService adminService = new AdminService();
	
	private String userName;//注册的用户账号
	private String tip;//返回的提示
	private int type = 0;//0为会员，1为管理员

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

		if (type == 0){
			if (userService.findUserName(userName)){
				tip = "<span style='color:red'>" + userName + "已存在，请重新输入</span>";
			}else{
				tip = "";
			}
		}else{
			if (adminService.findAdminName(userName)){
				tip = "<span style='color:red'>" + userName + "已存在，请重新输入</span>";
			}else{
				tip = "";
			}
		}
		
		return SUCCESS;
	}
}