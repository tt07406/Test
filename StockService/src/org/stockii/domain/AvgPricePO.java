package org.stockii.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 均价PO类
 * @author tt
 *
 */
@Entity(name="stock_avg_price")
public class AvgPricePO{

	@Id
	@GeneratedValue(generator = "generator")
	@GenericGenerator(name = "generator", strategy = "increment")
	private int seq_no;//序列号
	private String stock_id;//股票代码
	private String stock_name;//股票名称
	private Date start_date;//起始日期
	private BigDecimal start_price;//起始价
	private Date end_date;//终止日期
	private BigDecimal end_price;//终止价
	private BigDecimal avg_value;//平均值
	private int section_num;//跨区数
	
	public AvgPricePO(){}

	public AvgPricePO(int seqNo,String stockId, String stockName, Date startDate,
			BigDecimal startPrice, Date endDate, BigDecimal endPrice,
			BigDecimal avgValue, int sectionNum) {
		super();
		seq_no = seqNo;
		stock_id = stockId;
		stock_name = stockName;
		start_date = startDate;
		start_price = startPrice;
		end_date = endDate;
		end_price = endPrice;
		avg_value = avgValue;
		section_num = sectionNum;
	}
	
	public AvgPricePO(String stockId,double avgValue) {
		super();
		stock_id = stockId;
		stock_name = "";
		avg_value = new BigDecimal(avgValue);
		section_num = 0;
	}

	/**
	 * @return the seq_no
	 */
	public int getSeq_no() {
		return seq_no;
	}

	/**
	 * @param seqNo the seq_no to set
	 */
	public void setSeq_no(int seqNo) {
		seq_no = seqNo;
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
	 * @return the start_date
	 */
	public Date getStart_date() {
		return start_date;
	}

	/**
	 * @param startDate the start_date to set
	 */
	public void setStart_date(Date startDate) {
		start_date = startDate;
	}

	/**
	 * @return the start_price
	 */
	public BigDecimal getStart_price() {
		return start_price;
	}

	/**
	 * @param startPrice the start_price to set
	 */
	public void setStart_price(BigDecimal startPrice) {
		start_price = startPrice;
	}

	/**
	 * @return the end_date
	 */
	public Date getEnd_date() {
		return end_date;
	}

	/**
	 * @param endDate the end_date to set
	 */
	public void setEnd_date(Date endDate) {
		end_date = endDate;
	}

	/**
	 * @return the end_price
	 */
	public BigDecimal getEnd_price() {
		return end_price;
	}

	/**
	 * @param endPrice the end_price to set
	 */
	public void setEnd_price(BigDecimal endPrice) {
		end_price = endPrice;
	}

	/**
	 * @return the avg_value
	 */
	public BigDecimal getAvg_value() {
		return avg_value;
	}

	/**
	 * @param avgValue the avg_value to set
	 */
	public void setAvg_value(BigDecimal avgValue) {
		avg_value = avgValue;
	}

	/**
	 * @return the section_num
	 */
	public int getSection_num() {
		return section_num;
	}

	/**
	 * @param sectionNum the section_num to set
	 */
	public void setSection_num(int sectionNum) {
		section_num = sectionNum;
	}
	
	
}
