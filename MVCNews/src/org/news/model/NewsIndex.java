/*
 * ϵͳ���ƣ����ŷ���ϵͳ
 * 
 * ������NewsIndex
 * 
 * �������ڣ�2014-07-07
 */
package org.news.model;

/**
 * ��������VO
 * 
 * @author tt
 * @version 14.6.18
 */
public class NewsIndex {

	private int newsInfoId;				//����Id
	private String newsInfoTitle;		//���±���
	private String newsInfoDescribe;	//��������
	private String newsInfoTime;		//����ʱ��
	private String newsAuthor;			//��������
	
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
	 * ��ȡ ��������
	 * @return the newsInfoDescribe
	 */
	public String getNewsInfoDescribe() {
		return newsInfoDescribe;
	}
	
	/**
	 * ������������
	 * @param newsInfoDescribe the newsInfoDescribe to set
	 */
	public void setNewsInfoDescribe(String newsInfoDescribe) {
		this.newsInfoDescribe = newsInfoDescribe;
	}
	/**
	 * ��ȡ����ʱ��
	 * @return the newsInfoTime
	 */
	public String getNewsInfoTime() {
		return newsInfoTime;
	}
	/**
	 * ���ô���ʱ��
	 * @param newsInfoTime the newsInfoTime to set
	 */
	public void setNewsInfoTime(String newsInfoTime) {
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
}
