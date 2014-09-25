/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsVO
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.model;

import java.util.Date;

/**
 * ������Ϣ��PO��
 * 
 * @author tt
 * @version 14.9.16
 */
public class NewsVO {
	
	private int newsInfoId;				//����Id
	private String newsInfoTitle;		//���±���
	private Date newsInfoTime;		//����ʱ��
	private String newsAuthor;			//��������
	private String newsType;				//���·���
	private String adminName;			//������
	
	/**
	 * ��ȡ����Id
	 * @return the newsInfoId
	 */
	public int getNewsInfoId() {
		return newsInfoId;
	}
	
	/**
	 * ��������Id
	 * @param newsInfoId the newsInfoId to set
	 */
	public void setNewsInfoId(int newsInfoId) {
		this.newsInfoId = newsInfoId;
	}
	
	/**
	 * ��ȡ���±���
	 * @return the newsInfoTitle
	 */
	public String getNewsInfoTitle() {
		return newsInfoTitle;
	}
	
	/**
	 * �������±���
	 * @param newsInfoTitle the newsInfoTitle to set
	 */
	public void setNewsInfoTitle(String newsInfoTitle) {
		this.newsInfoTitle = newsInfoTitle;
	}
	
	/**
	 * ��ȡ����ʱ��
	 * @return the newsInfoTime
	 */
	public Date getNewsInfoTime() {
		return newsInfoTime;
	}
	
	/**
	 * ���ô���ʱ��
	 * @param newsInfoTime the newsInfoTime to set
	 */
	public void setNewsInfoTime(Date newsInfoTime) {
		this.newsInfoTime = newsInfoTime;
	}
	
	/**
	 * ��ȡ��������
	 * @return the newsAuthor
	 */
	public String getNewsAuthor() {
		return newsAuthor;
	}
	
	/**
	 * ������������
	 * @param newsAuthor the newsAuthor to set
	 */
	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}
	
	/**
	 * ��ȡ���·���
	 * @return the newsType
	 */
	public String getNewsType() {
		return newsType;
	}
	
	/**
	 * �������·���
	 * @param newsType the newsTypeId to set
	 */
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}
