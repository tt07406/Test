/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：AdminLogin
 * 
 * 创建日期：2014-10-11
 */
package org.mystock.action;

import java.util.ArrayList;
import java.util.List;

import org.mystock.model.Admin;
import org.mystock.service.AdminService;
import org.mystock.utils.MD5Code;
import org.mystock.utils.MessageUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于用户登录的Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class UserLogin extends ActionSupport {

	private static final long serialVersionUID = -5491387913076072900L;

AdminService adminService;
	
	/**
	 * @param adminService the adminService to set
	 */
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	private String mid;
	private String code;
	private String password;

	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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
		
		if (mid == null || "".equals(mid)) {//用户名为空
			errors.add(MessageUtil.get("adminlogin.adminid.null"));
		}
		
		if (password == null || "".equals(password)) {//密码为空
			errors.add(MessageUtil.get("adminlogin.password.null"));
		}
		
		if(errors.size()==0){	// 现在没有任何的错误信息
			Admin admin = new Admin(0,mid,new MD5Code().getMD5ofStr(password),"Super Admin") ;

			try {
				if(adminService.findLogin(admin)){//登录成功
					admin = adminService.findAdminById(mid);//从数据库获取对象
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
