/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AdminLogout
 * 
 * �������ڣ�2014-08-18
 */
package org.news.action;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ڹ���Ա�˳���¼��Action
 * 
 * @author tt
 * @version 14.8.18
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