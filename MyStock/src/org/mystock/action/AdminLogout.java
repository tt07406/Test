/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������AdminLogout
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.action;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ڹ���Ա�˳���¼��Action
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