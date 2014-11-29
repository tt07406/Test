
package org.stockii.model;



/**
 * 股票基本信息
 * @author tt
 *
 */
public class Stock {
	private String id;
	private String name;
	private String startDate;
	private String startValue;
	private String endDate;
	private String endValue;
	private String avgValue;
	private String sectionNum;
	
	public Stock(){}

	public Stock(String id, String name, String startDate, String startValue,
			String endDate, String endValue, String avgValue, String sectionNum) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.startValue = startValue;
		this.endDate = endDate;
		this.endValue = endValue;
		this.avgValue = avgValue;
		this.sectionNum = sectionNum;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the startValue
	 */
	public String getStartValue() {
		return startValue;
	}

	/**
	 * @param startValue the startValue to set
	 */
	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the endValue
	 */
	public String getEndValue() {
		return endValue;
	}

	/**
	 * @param endValue the endValue to set
	 */
	public void setEndValue(String endValue) {
		this.endValue = endValue;
	}

	/**
	 * @return the avgValue
	 */
	public String getAvgValue() {
		return avgValue;
	}

	/**
	 * @param avgValue the avgValue to set
	 */
	public void setAvgValue(String avgValue) {
		this.avgValue = avgValue;
	}

	/**
	 * @return the sectionNum
	 */
	public String getSectionNum() {
		return sectionNum;
	}

	/**
	 * @param sectionNum the sectionNum to set
	 */
	public void setSectionNum(String sectionNum) {
		this.sectionNum = sectionNum;
	}

	
}
