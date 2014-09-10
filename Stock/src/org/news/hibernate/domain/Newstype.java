package org.news.hibernate.domain;

/**
 * Newstype entity. @author MyEclipse Persistence Tools
 */

public class Newstype implements java.io.Serializable {

	// Fields

	private Integer newsTypeId;
	private String newsTypeName;
	private String newsTypeDescripe;

	// Constructors

	/** default constructor */
	public Newstype() {
	}

	/** full constructor */
	public Newstype(String newsTypeName, String newsTypeDescripe) {
		this.newsTypeName = newsTypeName;
		this.newsTypeDescripe = newsTypeDescripe;
	}

	// Property accessors

	public Integer getNewsTypeId() {
		return this.newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public String getNewsTypeName() {
		return this.newsTypeName;
	}

	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}

	public String getNewsTypeDescripe() {
		return this.newsTypeDescripe;
	}

	public void setNewsTypeDescripe(String newsTypeDescripe) {
		this.newsTypeDescripe = newsTypeDescripe;
	}

}