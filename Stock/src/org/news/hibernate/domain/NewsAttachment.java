package org.news.hibernate.domain;

/**
 * NewsAttachment entity. @author MyEclipse Persistence Tools
 */

public class NewsAttachment implements java.io.Serializable {

	// Fields

	private Integer attachmentId;
	private Integer newsId;
	private String attachmentName;
	private String attachmentContent;

	// Constructors

	/** default constructor */
	public NewsAttachment() {
	}

	/** full constructor */
	public NewsAttachment(Integer newsId, String attachmentName,
			String attachmentContent) {
		this.newsId = newsId;
		this.attachmentName = attachmentName;
		this.attachmentContent = attachmentContent;
	}

	// Property accessors

	public Integer getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentContent() {
		return this.attachmentContent;
	}

	public void setAttachmentContent(String attachmentContent) {
		this.attachmentContent = attachmentContent;
	}

}