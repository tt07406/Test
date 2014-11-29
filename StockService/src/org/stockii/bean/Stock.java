package org.stockii.bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stock")
public class Stock {

	private String id;
	private String name;
	private Date listDate;
	
	public Stock(){}

	public Stock(String id, String name, Date listDate) {
		super();
		this.id = id;
		this.name = name;
		this.listDate = listDate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the listDate
	 */
	public Date getListDate() {
		return listDate;
	}

	/**
	 * @param listDate the listDate to set
	 */
	public void setListDate(Date listDate) {
		this.listDate = listDate;
	}
	
	
}
