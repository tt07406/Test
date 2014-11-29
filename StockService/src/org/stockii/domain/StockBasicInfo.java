package org.stockii.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 股票基本信息PO
 * @author tt
 *
 */
@Entity(name="stock_basic_info")
public class StockBasicInfo {
	
	@Id
	private String stock_id;//股票代码
	private String stock_name;//股票名称
	private Date list_date;//上市日期
	
	public StockBasicInfo(){}

	public StockBasicInfo(String stockId, String stockName, Date listDate) {
		super();
		stock_id = stockId;
		stock_name = stockName;
		list_date = listDate;
	}

	/**
	 * @return the stock_id
	 */
	public String getStock_id() {
		return stock_id;
	}

	/**
	 * @param stockId the stock_id to set
	 */
	public void setStock_id(String stockId) {
		stock_id = stockId;
	}

	/**
	 * @return the stock_name
	 */
	public String getStock_name() {
		return stock_name;
	}

	/**
	 * @param stockName the stock_name to set
	 */
	public void setStock_name(String stockName) {
		stock_name = stockName;
	}

	/**
	 * @return the list_date
	 */
	public Date getList_date() {
		return list_date;
	}

	/**
	 * @param listDate the list_date to set
	 */
	public void setList_date(Date listDate) {
		list_date = listDate;
	}
	
	
}
