/*
 * 系统名称：新闻发布系统
 * 
 * 类名：AdminLogin
 * 
 * 创建日期：2014-08-18
 */
package org.news.action;

import java.util.ArrayList;
import java.util.List;

import org.news.model.Admin;
import org.news.service.AdminService;
import org.news.utils.MD5Code;
import org.news.utils.MessageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于管理员登录的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class AdminLogin extends ActionSupport {

	private static final long serialVersionUID = 2124111050903078657L;
	AdminService adminService;
	
	/**
	 * @param adminService the adminService to set
	 */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	private String adminName;
	private String code;
	private String password;

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String execute() {
		ActionContext ctx = ActionContext.getContext();
		List<String> errors = new ArrayList<String>();//错误列表
		
		if (code == null || "".equals(code)) {//验证码为空
			errors.add(MessageUtil.get("adminlogin.code.null"));
		} else {
			String rand = (String) ctx.getSession().get("rand"); // 取得生成的验证码
			if (!code.equalsIgnoreCase(rand)) {//验证码不匹配
				errors.add(MessageUtil.get("adminlogin.code.err")) ;
			}
		}
		
		if (adminName == null || "".equals(adminName)) {//用户名为空
			errors.add(MessageUtil.get("adminlogin.adminid.null"));
		}
		
		if (password == null || "".equals(password)) {//密码为空
			errors.add(MessageUtil.get("adminlogin.password.null"));
		}
		
		if(errors.size()==0){	// 现在没有任何的错误信息
			Admin admin = new Admin(0,adminName,new MD5Code().getMD5ofStr(password),"Super Admin") ;

			try {
				if(adminService.findLogin(admin)){//登录成功
					admin = adminService.findAdminById(adminName);//从数据库获取对象
					ctx.getSession().put("admin", admin);// 现在保存对象
					return SUCCESS;
				} else {
					errors.add(MessageUtil.get("adminlogin.false")) ;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ctx.put("errors", errors);//保存错误
		
		return ERROR;
	}
}