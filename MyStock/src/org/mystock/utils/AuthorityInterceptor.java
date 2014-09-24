/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：AuthorityInterceptor
 * 
 * 创建日期：2014-09-24
 */
package org.mystock.utils;

import java.util.Map;

import org.mystock.model.Admin;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 权限检查拦截器
 * 
 * @author tt
 * @version 14.9.16
 */
public class AuthorityInterceptor extends AbstractInterceptor {

	private String allowAction;//允许通过的Actions字符串

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
	
		//取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		//取出名为admin的Session属性
		Admin admin = (Admin)session.get("admin");
		
		//获取当前被调用的Action
		String currentActionName = ctx.getName();
		for(String name : allowAction.split(",")){
			//如果当前被调用Action属于要放行的Action
			if (name.equals(currentActionName)){
				
				return invocation.invoke();//让其继续处理
			}
		}
		
		//如果没有登录，则返回重新登录
		if (admin != null){
			return invocation.invoke();
		}
		ctx.put("tip", "您还没有登录，请先登录系统");
		
		
		return Action.LOGIN;
	}

}
