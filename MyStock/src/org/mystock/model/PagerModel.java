/*
 * 系统名称：斯多克个人网站自助系统
 * 
 * 类名：PagerModel
 * 
 * 创建日期：2014-09-26
 */
package org.mystock.model;

import java.util.List; 

/** 
* 分页模型 
* @author WinLive 
* 
*/ 

public class PagerModel {

	// 总记录数
	private int total;

	// 当前页的结果集
	private List datas;

	public List getDatas() {
		return datas;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
} 
