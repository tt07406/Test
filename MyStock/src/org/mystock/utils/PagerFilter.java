package org.mystock.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.Filter;

public class PagerFilter implements Filter {

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest =(HttpServletRequest)request;
		SystemContext.setOffset(getOffset(httpRequest));
		SystemContext.setPageSize(getPageSize(httpRequest));
		try{
			chain.doFilter(request, response);
		}finally{
			//清空ThreadLocal中的值
			SystemContext.removeOffset();
			SystemContext.removePageSize();
		}			
	}
	public void init(FilterConfig arg0) throws ServletException {
	}
	public int getOffset(HttpServletRequest request){
		int offset = 0;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (NumberFormatException ignore) {
		}
		return offset;
	}	
        //设置每页显示多少条记录
	public int getPageSize(HttpServletRequest request){
		int pagesize = 0;

		try {
			pagesize = Integer.parseInt(request.getParameter("pagesize"));
		} catch (Exception ignore) {
		}

		if (pagesize == 0) {

			pagesize = 10;

		}
		// System.out.println(pagesize);
		return pagesize;
	}
}
