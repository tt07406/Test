/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������PagerModel
 * 
 * �������ڣ�2014-09-26
 */
package org.mystock.model;

import java.util.List; 

/** 
* ��ҳģ�� 
* @author WinLive 
* 
*/ 

public class PagerModel {

	// �ܼ�¼��
	private int total;

	// ��ǰҳ�Ľ����
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
