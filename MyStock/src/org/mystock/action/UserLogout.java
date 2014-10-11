/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������UserLogout
 * 
 * �������ڣ�2014-10-11
 */
package org.mystock.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �����˳���¼��Action
 * 
 * @author tt
 * @version 14.9.16
 */
public class UserLogout extends ActionSupport {

	private static final long serialVersionUID = -5505610348782046281L;

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().invalidate();

		return SUCCESS;
	}
}
