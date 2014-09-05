/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������UserLoginAction
 * 
 * �������ڣ�2014-08-21
 */
package org.news.action;

import org.news.model.Users;
import org.news.service.UserService;
import org.news.utils.MD5Code;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ڻ�Ա��¼��Action
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

	String code;//��֤��
	String info;//��ʾ��Ϣ
	String mid;//��Ա�˺�
	String password;//����

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
		
		String rand = (String) ctx.getSession().get("rand") ;	// ��session��ȡ����֤��
		
		if(!rand.equalsIgnoreCase(code)){//��֤�벻��ȷ
			setInfo("��������ȷ����֤�룡") ;
			return LOGIN;
		}
		
		Users user = new Users(0,mid,new MD5Code().getMD5ofStr(password),"","","","","","") ;
		try {
			if(userService.findLogin(user)){//��¼�ɹ�
				ctx.getSession().put("id",mid) ;	// ����mid
				return SUCCESS;
			} else {
				setInfo("������û��������룡") ;
				return LOGIN;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LOGIN;
	}
}