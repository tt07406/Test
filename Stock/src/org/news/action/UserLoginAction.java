/*
 * 系统名称：新闻发布系统
 * 
 * 类名：UserLoginAction
 * 
 * 创建日期：2014-08-21
 */
package org.news.action;

import org.news.model.Users;
import org.news.service.UserService;
import org.news.utils.MD5Code;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用于会员登录的Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class UserLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1557983232383880770L;
	private UserService userService;
	
	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	String code;//验证码
	String info;//提示信息
	String mid;//会员账号
	String password;//密码

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
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}

	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
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
		
		String rand = (String) ctx.getSession().get("rand") ;	// 从session中取出验证码
		
		if(!rand.equalsIgnoreCase(code)){//验证码不正确
			setInfo("请输入正确的验证码！") ;
			return LOGIN;
		}
		
		Users user = new Users(0,mid,new MD5Code().getMD5ofStr(password),"","","","","","") ;
		try {
			if(userService.findLogin(user)){//登录成功
				ctx.getSession().put("id",mid) ;	// 保存mid
				return SUCCESS;
			} else {
				setInfo("错误的用户名或密码！") ;
				return LOGIN;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LOGIN;
	}
}