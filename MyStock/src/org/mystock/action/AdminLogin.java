/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：AdminLogin
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.mystock.service.UserService;
import org.mystock.service.PermissionService;
import org.mystock.model.Admin;
import org.mystock.model.Users;
import org.mystock.utils.MD5Code;
import org.mystock.utils.MessageUtil;

/**
 * 用于管理员登录的Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class AdminLogin extends ActionSupport {

	private static final long serialVersionUID = -602385738754427947L;
	UserService userService;
	PermissionService permissionService;
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * @param permissionService the permissionService to set
	 */
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
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
			Admin admin = new Admin(adminName,new MD5Code().getMD5ofStr(password),0) ;
			Users user = new Users();
			user.setUsersName(adminName);
			user.setUsersPass(new MD5Code().getMD5ofStr(password));
			try {
				Users result = userService.findLogin(user);
				if (result != null){//用户列表中找得到该用户，则查找权限表获取权限
					admin.setAdminLevel(permissionService.getPermissionLevel(result.getUserIdNum(), result.getUsersInfo()));

					if (admin.getAdminLevel()>0){//有权限
						ctx.getSession().put("admin", admin);// 现在保存对象
						return SUCCESS;
					}
				}
				errors.add(MessageUtil.get("adminlogin.false")) ;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ctx.put("errors", errors);//保存错误
		
		return ERROR;
	}
}
