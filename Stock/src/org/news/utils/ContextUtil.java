package org.news.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextUtil implements ApplicationContextAware {
	
	public static ApplicationContext applicationContext;
	
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		ContextUtil.applicationContext = applicationContext;
	}
	
}