/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：AdminLogout
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.action;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于管理员退出登录的Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class AdminLogout extends ActionSupport {


	private static final long serialVersionUID = -7718466490245716891L;

	/**
	 * @return
	 */
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().invalidate();
		return SUCCESS;
	}
}