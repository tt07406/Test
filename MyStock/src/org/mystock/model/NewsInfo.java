/*
 * ϵͳ���ƣ�˹��˸�����վ����ϵͳ
 * 
 * ������NewsInfo
 * 
 * �������ڣ�2014-09-24
 */
package org.mystock.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * ������Ϣ��PO��
 * 
 * @author tt
 * @version 14.9.16
 */
@Entity(name="newsinfo")
public class NewsInfo {

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private int newsInfoId;				//����Id
	private String newsInfoTitle;		//���±���
	private String newsInfoContent;		//��������
	private Date newsInfoTime;		//����ʱ��
	private String newsAuthor;			//��������
	private String newsType;				//���·���Id
	
	public NewsInfo() {
	}
	
	/**
	 * ��ʼ������
	 * @param newsInfoId
	 * @param newsInfoTitle
	 * @param newsInfoContent
	 * @param newsInfoTime
	 * @param newsAuthor
	 * @param newsType
	 */
	public NewsInfo(int newsInfoId, String newsInfoTitle,
			String newsInfoContent, Date newsInfoTime, String newsAuthor,
			String newsType) {
		super();
		this.newsInfoId = newsInfoId;
		this.newsInfoTitle = newsInfoTitle;
		this.newsInfoContent = newsInfoContent;
		this.newsInfoTime = newsInfoTime;
		this.newsAuthor = newsAuthor;
		this.newsType = newsType;
	}

	public int getNewsInfoId() {
		return newsInfoId;
	}

	public void setNewsInfoId(int newsInfoId) {
		this.newsInfoId = newsInfoId;
	}

	public String getNewsInfoTitle() {
		return newsInfoTitle;
	}

	public void setNewsInfoTitle(String newsInfoTitle) {
		this.newsInfoTitle = newsInfoTitle;
	}

	public String getNewsInfoContent() {
		return newsInfoContent;
	}

	public void setNewsInfoContent(String newsInfoContent) {
		this.newsInfoContent = newsInfoContent;
	}

	public Date getNewsInfoTime() {
		return newsInfoTime;
	}

	public void setNewsInfoTime(Date newsInfoTime) {
		this.newsInfoTime = newsInfoTime;
	}

	public String getNewsAuthor() {
		return newsAuthor;
	}

	public void setNewsAuthor(String newsAuthor) {
		this.newsAuthor = newsAuthor;
	}

	public String getNewsType() {
		return newsType;
	}

	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	
	
}
