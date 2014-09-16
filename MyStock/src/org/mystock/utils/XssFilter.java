/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������XssFilter
 * 
 * �������ڣ�2014-09-16
 */
package org.mystock.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * XSS������
 * @author tt
 * @version 14.9.16
 */
public class XssFilter implements Filter {
	FilterConfig filterConfig = null;

	@Override
	public void destroy() {
		 this.filterConfig = null;		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        chain.doFilter(new XssHttpServletRequestWrapper(
                (HttpServletRequest) request), response);
    }

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
