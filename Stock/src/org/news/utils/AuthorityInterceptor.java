/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������AuthorityInterceptor
 * 
 * �������ڣ�2014-08-27
 */
package org.news.utils;

import java.util.Map;

import org.news.model.Admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Ȩ�޼��������
 * 
 * @author tt
 * @version 14.8.18
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	private String allowAction;//����ͨ����Actions�ַ���

	/**
	 * @return the allowAction
	 */
	public String getAllowAction() {
		return allowAction;
	}

	/**
	 * @param allowAction the allowAction to set
	 */
	public void setAllowAction(String allowAction) {
		this.allowAction = allowAction;
	}

	private static final long serialVersionUID = 2197667712503801071L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	
		//ȡ��������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//ȡ����Ϊadmin��Session����
		Admin admin = (Admin)session.get("admin");
		
		//��ȡ��ǰ�����õ�Action
		String currentActionName = ctx.getName();
		for(String name : allowAction.split(",")){
			//�����ǰ������Action����Ҫ���е�Action
			if (name.equals(currentActionName)){
				
				return invocation.invoke();//�����������
			}
		}
		
		//���û�е�¼���򷵻����µ�¼
		if (admin != null){
			return invocation.invoke();
		}
		ctx.put("tip", "����û�е�¼�����ȵ�¼ϵͳ");
		
		
		return Action.LOGIN;
	}

}