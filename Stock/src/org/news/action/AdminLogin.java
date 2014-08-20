/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AdminLogin
 * 
 * �������ڣ�2014-08-18
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
 * ���ڹ���Ա��¼��Action
 * 
 * @author tt
 * @version 14.8.18
 */
public class AdminLogin extends ActionSupport {

	private static final long serialVersionUID = 2124111050903078657L;
	
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
		List<String> errors = new ArrayList<String>();//�����б�
		
		if (code == null || "".equals(code)) {//��֤��Ϊ��
			errors.add(MessageUtil.get("adminlogin.code.null"));
		} else {
			String rand = (String) ctx.getSession().get("rand"); // ȡ�����ɵ���֤��
			if (!code.equalsIgnoreCase(rand)) {//��֤�벻ƥ��
				errors.add(MessageUtil.get("adminlogin.code.err")) ;
			}
		}
		
		if (adminName == null || "".equals(adminName)) {//�û���Ϊ��
			errors.add(MessageUtil.get("adminlogin.adminid.null"));
		}
		
		if (password == null || "".equals(password)) {//����Ϊ��
			errors.add(MessageUtil.get("adminlogin.password.null"));
		}
		
		if(errors.size()==0){	// ����û���κεĴ�����Ϣ
			Admin admin = new Admin(0,adminName,new MD5Code().getMD5ofStr(password),"Super Admin") ;
			AdminService adminService = new AdminService(); //������һ��ķ�����е�¼
			try {
				if(adminService.findLogin(admin)){//��¼�ɹ�
					admin = adminService.findAdminById(adminName);//�����ݿ��ȡ����
					ctx.getSession().put("admin", admin);// ���ڱ������
					return SUCCESS;
				} else {
					errors.add(MessageUtil.get("adminlogin.false")) ;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ctx.put("errors", errors);//�������
		
		return ERROR;
	}
}