/*
 * 系统名称：新闻发布系统
 * 
 * 类名：XssHttpServletRequestWrapper
 * 
 * 创建日期：2014-09-02
 */
package org.news.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.StrutsRequestWrapper;

/**
 * 对每个post请求的参数过滤一些关键字，替换成安全的，例如：< > ' " \ /  # & 
 * @author tt
 * @version 14.8.18
 */
public class XssHttpServletRequestWrapper extends StrutsRequestWrapper {

	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	/**
	 * Struts2在自定义的HttpServletRequestWraper中需要重写getParameterMap()方法才行
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String,String[]> getParameterMap() {
		 
        HashMap<String,String[]> paramMap = (HashMap<String,String[]>) super.getParameterMap();
        paramMap = (HashMap<String,String[]>) paramMap.clone();
 
        for (Iterator iterator = paramMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>) iterator.next();
            String [] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                if(values[i] instanceof String){
                    values[i] = cleanXSS(values[i]);
                }
            }
            entry.setValue(values);
        }
        return paramMap;
    }
	/**
	 * 获取参数对应的所有值，然后进行输出转义
	 */
	@Override
	public String[] getParameterValues(String parameter) {

		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);//逐个进行转义
		}
		return encodedValues;//返回转义后的值
	}

	/**
	 * 获取某个参数的值，然后进行转义
	 */
	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		if (value == null) {
			return null;
		}
		return cleanXSS(value);
	}

	/**
	 * 获取请求的头部
	 */
	@Override
	public String getHeader(String name) {

		String value = super.getHeader(name);
		if (value == null)
			return null;
		return cleanXSS(value);
	}

	/**
	 * 对标签内的特殊字符（<、>、"、'等）采用HTML实体转义。
	 * @param value
	 * @return 转义后的值
	 */
	private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
				"\"\"");
		value = value.replaceAll("script", "");

		return value;
	}
}
