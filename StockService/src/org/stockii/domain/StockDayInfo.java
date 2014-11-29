package org.stockii.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 股票每日原始数据PO
 * @author tt
 *
 */
@Entity(name="stock_day_info")
public class StockDayInfo {
	
	@Id
	private int seq_no;//序列号
	private String stock_id;//代码
	private BigDecimal growth_ratio;//涨幅(%)
	private BigDecimal current_price;//现价（元）
	private BigDecimal daily_up_down;//日涨跌
	private BigDecimal bought_price;//买入价
	private BigDecimal sold_price;//卖出价
	private int total_deal_amount;//总量
	private int last_deal_amount;//现量
	private BigDecimal growth_speed;//涨速
	private BigDecimal turnover_ratio;//换手
	private BigDecimal today_begin_price;//今开
	private BigDecimal ytd_end_price;//昨收
	private BigDecimal pe_ratio;//市盈率
	private BigDecimal max;//最高
	private BigDecimal min;//最低
	private BigInteger total_money;//总金额
	private BigDecimal amplitude_ratio;//振幅
	private int cir_of_cap_stock;//流通股本（万）
	private BigDecimal upordown_per_deal;//笔涨跌
	private BigDecimal volume_ratio;//量比
	private BigDecimal avg_price;//均价（元）
	private BigDecimal DaPanWeiBi;//委比
	private int sell;//内盘
	private int buy;//外盘
	private BigDecimal sb_ratio;//内外比
	private int DaPanWeiCha;//委量差
	private int num1_buy;//买量一
	private int num1_sell;//卖量一
	private BigDecimal num1_buy_price;//买价一
	private BigDecimal num1_sell_price;//卖价一
	private BigDecimal num2_sell_price;//卖价二
	private int num2_sell;//卖量二
	private BigDecimal num2_buy_price;//买价二
	private int num2_buy;//买量二
	private BigDecimal num3_buy_price;//买价三
	private int num3_buy;//买量三
	private BigDecimal num3_sell_price;//卖价三
	private int num3_sell;//卖量三
	private String circulation_value;//流通市值
	private BigDecimal bbi_balance;//多空平衡
	private BigDecimal bull_profit;//多头获利
	private BigDecimal bull_stop_losses;//多头止损
	private BigDecimal short_covering;//空头回补
	private BigDecimal bear_stop_losses;//空头止损
	private BigDecimal relative_strength_index;//强弱度
	private int activity;//活跃度
	private BigDecimal num_per_deal;//每笔均量
	private BigDecimal turn_per_deal;//每笔换手
	private Date update_date;//更新日期
	private BigDecimal total_stock;//总股本（万）
	private BigDecimal max_circulation_value;//最高价流通市值
	private BigDecimal current_circulation_value;//现价流通市值
	private BigDecimal min_circulation_value;//最低价流通市值
	private BigDecimal avg_circulation_value;//均价流通市值
	private BigDecimal total_value;//总市值（万）
	private Date created;//创建日期
	
	public StockDayInfo(){}

	public StockDayInfo(int seqNo, String stockId, BigDecimal growthRatio,
			BigDecimal currentPrice, BigDecimal dailyUpDown,
			BigDecimal boughtPrice, BigDecimal soldPrice, int totalDealAmount,
			int lastDealAmount, BigDecimal growthSpeed,
			BigDecimal turnoverRatio, BigDecimal todayBeginPrice,
			BigDecimal ytdEndPrice, BigDecimal peRatio, BigDecimal max,
			BigDecimal min, BigInteger totalMoney, BigDecimal amplitudeRatio,
			int cirOfCapStock, BigDecimal upordownPerDeal,
			BigDecimal volumeRatio, BigDecimal avgPrice, BigDecimal daPanWeiBi,
			int sell, int buy, BigDecimal sbRatio, int daPanWeiCha,
			int num1Buy, int num1Sell, BigDecimal num1BuyPrice,
			BigDecimal num1SellPrice, BigDecimal num2SellPrice, int num2Sell,
			BigDecimal num2BuyPrice, int num2Buy, BigDecimal num3BuyPrice,
			int num3Buy, BigDecimal num3SellPrice, int num3Sell,
			String circulationValue, BigDecimal bbiBalance,
			BigDecimal bullProfit, BigDecimal bullStopLosses,
			BigDecimal shortCovering, BigDecimal bearStopLosses,
			BigDecimal relativeStrengthIndex, int activity,
			BigDecimal numPerDeal, BigDecimal turnPerDeal, Date updateDate,
			BigDecimal totalStock, BigDecimal maxCirculationValue,
			BigDecimal currentCirculationValue, BigDecimal minCirculationValue,
			BigDecimal avgCirculationValue, BigDecimal totalValue, Date created) {
		super();
		seq_no = seqNo;
		stock_id = stockId;
		growth_ratio = growthRatio;
		current_price = currentPrice;
		daily_up_down = dailyUpDown;
		bought_price = boughtPrice;
		sold_price = soldPrice;
		total_deal_amount = totalDealAmount;
		last_deal_amount = lastDealAmount;
		growth_speed = growthSpeed;
		turnover_ratio = turnoverRatio;
		today_begin_price = todayBeginPrice;
		ytd_end_price = ytdEndPrice;
		pe_ratio = peRatio;
		this.max = max;
		this.min = min;
		total_money = totalMoney;
		amplitude_ratio = amplitudeRatio;
		cir_of_cap_stock = cirOfCapStock;
		upordown_per_deal = upordownPerDeal;
		volume_ratio = volumeRatio;
		avg_price = avgPrice;
		DaPanWeiBi = daPanWeiBi;
		this.sell = sell;
		this.buy = buy;
		sb_ratio = sbRatio;
		DaPanWeiCha = daPanWeiCha;
		num1_buy = num1Buy;
		num1_sell = num1Sell;
		num1_buy_price = num1BuyPrice;
		num1_sell_price = num1SellPrice;
		num2_sell_price = num2SellPrice;
		num2_sell = num2Sell;
		num2_buy_price = num2BuyPrice;
		num2_buy = num2Buy;
		num3_buy_price = num3BuyPrice;
		num3_buy = num3Buy;
		num3_sell_price = num3SellPrice;
		num3_sell = num3Sell;
		circulation_value = circulationValue;
		bbi_balance = bbiBalance;
		bull_profit = bullProfit;
		bull_stop_losses = bullStopLosses;
		short_covering = shortCovering;
		bear_stop_losses = bearStopLosses;
		relative_strength_index = relativeStrengthIndex;
		this.activity = activity;
		num_per_deal = numPerDeal;
		turn_per_deal = turnPerDeal;
		update_date = updateDate;
		total_stock = totalStock;
		max_circulation_value = maxCirculationValue;
		current_circulation_value = currentCirculationValue;
		min_circulation_value = minCirculationValue;
		avg_circulation_value = avgCirculationValue;
		total_value = totalValue;
		this.created = created;
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
	 * @return the growth_ratio
	 */
	public BigDecimal getGrowth_ratio() {
		return growth_ratio;
	}

	/**
	 * @param growthRatio the growth_ratio to set
	 */
	public void setGrowth_ratio(BigDecimal growthRatio) {
		growth_ratio = growthRatio;
	}

	/**
	 * @return the current_price
	 */
	public BigDecimal getCurrent_price() {
		return current_price;
	}

	/**
	 * @param currentPrice the current_price to set
	 */
	public void setCurrent_price(BigDecimal currentPrice) {
		current_price = currentPrice;
	}

	/**
	 * @return the daily_up_down
	 */
	public BigDecimal getDaily_up_down() {
		return daily_up_down;
	}

	/**
	 * @param dailyUpDown the daily_up_down to set
	 */
	public void setDaily_up_down(BigDecimal dailyUpDown) {
		daily_up_down = dailyUpDown;
	}

	/**
	 * @return the bought_price
	 */
	public BigDecimal getBought_price() {
		return bought_price;
	}

	/**
	 * @param boughtPrice the bought_price to set
	 */
	public void setBought_price(BigDecimal boughtPrice) {
		bought_price = boughtPrice;
	}

	/**
	 * @return the sold_price
	 */
	public BigDecimal getSold_price() {
		return sold_price;
	}

	/**
	 * @param soldPrice the sold_price to set
	 */
	public void setSold_price(BigDecimal soldPrice) {
		sold_price = soldPrice;
	}

	/**
	 * @return the total_deal_amount
	 */
	public int getTotal_deal_amount() {
		return total_deal_amount;
	}

	/**
	 * @param totalDealAmount the total_deal_amount to set
	 */
	public void setTotal_deal_amount(int totalDealAmount) {
		total_deal_amount = totalDealAmount;
	}

	/**
	 * @return the last_deal_amount
	 */
	public int getLast_deal_amount() {
		return last_deal_amount;
	}

	/**
	 * @param lastDealAmount the last_deal_amount to set
	 */
	public void setLast_deal_amount(int lastDealAmount) {
		last_deal_amount = lastDealAmount;
	}

	/**
	 * @return the growth_speed
	 */
	public BigDecimal getGrowth_speed() {
		return growth_speed;
	}

	/**
	 * @param growthSpeed the growth_speed to set
	 */
	public void setGrowth_speed(BigDecimal growthSpeed) {
		growth_speed = growthSpeed;
	}

	/**
	 * @return the turnover_ratio
	 */
	public BigDecimal getTurnover_ratio() {
		return turnover_ratio;
	}

	/**
	 * @param turnoverRatio the turnover_ratio to set
	 */
	public void setTurnover_ratio(BigDecimal turnoverRatio) {
		turnover_ratio = turnoverRatio;
	}

	/**
	 * @return the today_begin_price
	 */
	public BigDecimal getToday_begin_price() {
		return today_begin_price;
	}

	/**
	 * @param todayBeginPrice the today_begin_price to set
	 */
	public void setToday_begin_price(BigDecimal todayBeginPrice) {
		today_begin_price = todayBeginPrice;
	}

	/**
	 * @return the ytd_end_price
	 */
	public BigDecimal getYtd_end_price() {
		return ytd_end_price;
	}

	/**
	 * @param ytdEndPrice the ytd_end_price to set
	 */
	public void setYtd_end_price(BigDecimal ytdEndPrice) {
		ytd_end_price = ytdEndPrice;
	}

	/**
	 * @return the pe_ratio
	 */
	public BigDecimal getPe_ratio() {
		return pe_ratio;
	}

	/**
	 * @param peRatio the pe_ratio to set
	 */
	public void setPe_ratio(BigDecimal peRatio) {
		pe_ratio = peRatio;
	}

	/**
	 * @return the max
	 */
	public BigDecimal getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(BigDecimal max) {
		this.max = max;
	}

	/**
	 * @return the min
	 */
	public BigDecimal getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(BigDecimal min) {
		this.min = min;
	}

	/**
	 * @return the total_money
	 */
	public BigInteger getTotal_money() {
		return total_money;
	}

	/**
	 * @param totalMoney the total_money to set
	 */
	public void setTotal_money(BigInteger totalMoney) {
		total_money = totalMoney;
	}

	/**
	 * @return the amplitude_ratio
	 */
	public BigDecimal getAmplitude_ratio() {
		return amplitude_ratio;
	}

	/**
	 * @param amplitudeRatio the amplitude_ratio to set
	 */
	public void setAmplitude_ratio(BigDecimal amplitudeRatio) {
		amplitude_ratio = amplitudeRatio;
	}

	/**
	 * @return the cir_of_cap_stock
	 */
	public int getCir_of_cap_stock() {
		return cir_of_cap_stock;
	}

	/**
	 * @param cirOfCapStock the cir_of_cap_stock to set
	 */
	public void setCir_of_cap_stock(int cirOfCapStock) {
		cir_of_cap_stock = cirOfCapStock;
	}

	/**
	 * @return the upordown_per_deal
	 */
	public BigDecimal getUpordown_per_deal() {
		return upordown_per_deal;
	}

	/**
	 * @param upordownPerDeal the upordown_per_deal to set
	 */
	public void setUpordown_per_deal(BigDecimal upordownPerDeal) {
		upordown_per_deal = upordownPerDeal;
	}

	/**
	 * @return the volume_ratio
	 */
	public BigDecimal getVolume_ratio() {
		return volume_ratio;
	}

	/**
	 * @param volumeRatio the volume_ratio to set
	 */
	public void setVolume_ratio(BigDecimal volumeRatio) {
		volume_ratio = volumeRatio;
	}

	/**
	 * @return the avg_price
	 */
	public BigDecimal getAvg_price() {
		return avg_price;
	}

	/**
	 * @param avgPrice the avg_price to set
	 */
	public void setAvg_price(BigDecimal avgPrice) {
		avg_price = avgPrice;
	}

	/**
	 * @return the daPanWeiBi
	 */
	public BigDecimal getDaPanWeiBi() {
		return DaPanWeiBi;
	}

	/**
	 * @param daPanWeiBi the daPanWeiBi to set
	 */
	public void setDaPanWeiBi(BigDecimal daPanWeiBi) {
		DaPanWeiBi = daPanWeiBi;
	}

	/**
	 * @return the sell
	 */
	public int getSell() {
		return sell;
	}

	/**
	 * @param sell the sell to set
	 */
	public void setSell(int sell) {
		this.sell = sell;
	}

	/**
	 * @return the buy
	 */
	public int getBuy() {
		return buy;
	}

	/**
	 * @param buy the buy to set
	 */
	public void setBuy(int buy) {
		this.buy = buy;
	}

	/**
	 * @return the sb_ratio
	 */
	public BigDecimal getSb_ratio() {
		return sb_ratio;
	}

	/**
	 * @param sbRatio the sb_ratio to set
	 */
	public void setSb_ratio(BigDecimal sbRatio) {
		sb_ratio = sbRatio;
	}

	/**
	 * @return the daPanWeiCha
	 */
	public int getDaPanWeiCha() {
		return DaPanWeiCha;
	}

	/**
	 * @param daPanWeiCha the daPanWeiCha to set
	 */
	public void setDaPanWeiCha(int daPanWeiCha) {
		DaPanWeiCha = daPanWeiCha;
	}

	/**
	 * @return the num1_buy
	 */
	public int getNum1_buy() {
		return num1_buy;
	}

	/**
	 * @param num1Buy the num1_buy to set
	 */
	public void setNum1_buy(int num1Buy) {
		num1_buy = num1Buy;
	}

	/**
	 * @return the num1_sell
	 */
	public int getNum1_sell() {
		return num1_sell;
	}

	/**
	 * @param num1Sell the num1_sell to set
	 */
	public void setNum1_sell(int num1Sell) {
		num1_sell = num1Sell;
	}

	/**
	 * @return the num1_buy_price
	 */
	public BigDecimal getNum1_buy_price() {
		return num1_buy_price;
	}

	/**
	 * @param num1BuyPrice the num1_buy_price to set
	 */
	public void setNum1_buy_price(BigDecimal num1BuyPrice) {
		num1_buy_price = num1BuyPrice;
	}

	/**
	 * @return the num1_sell_price
	 */
	public BigDecimal getNum1_sell_price() {
		return num1_sell_price;
	}

	/**
	 * @param num1SellPrice the num1_sell_price to set
	 */
	public void setNum1_sell_price(BigDecimal num1SellPrice) {
		num1_sell_price = num1SellPrice;
	}

	/**
	 * @return the num2_sell_price
	 */
	public BigDecimal getNum2_sell_price() {
		return num2_sell_price;
	}

	/**
	 * @param num2SellPrice the num2_sell_price to set
	 */
	public void setNum2_sell_price(BigDecimal num2SellPrice) {
		num2_sell_price = num2SellPrice;
	}

	/**
	 * @return the num2_sell
	 */
	public int getNum2_sell() {
		return num2_sell;
	}

	/**
	 * @param num2Sell the num2_sell to set
	 */
	public void setNum2_sell(int num2Sell) {
		num2_sell = num2Sell;
	}

	/**
	 * @return the num2_buy_price
	 */
	public BigDecimal getNum2_buy_price() {
		return num2_buy_price;
	}

	/**
	 * @param num2BuyPrice the num2_buy_price to set
	 */
	public void setNum2_buy_price(BigDecimal num2BuyPrice) {
		num2_buy_price = num2BuyPrice;
	}

	/**
	 * @return the num2_buy
	 */
	public int getNum2_buy() {
		return num2_buy;
	}

	/**
	 * @param num2Buy the num2_buy to set
	 */
	public void setNum2_buy(int num2Buy) {
		num2_buy = num2Buy;
	}

	/**
	 * @return the num3_buy_price
	 */
	public BigDecimal getNum3_buy_price() {
		return num3_buy_price;
	}

	/**
	 * @param num3BuyPrice the num3_buy_price to set
	 */
	public void setNum3_buy_price(BigDecimal num3BuyPrice) {
		num3_buy_price = num3BuyPrice;
	}

	/**
	 * @return the num3_buy
	 */
	public int getNum3_buy() {
		return num3_buy;
	}

	/**
	 * @param num3Buy the num3_buy to set
	 */
	public void setNum3_buy(int num3Buy) {
		num3_buy = num3Buy;
	}

	/**
	 * @return the num3_sell_price
	 */
	public BigDecimal getNum3_sell_price() {
		return num3_sell_price;
	}

	/**
	 * @param num3SellPrice the num3_sell_price to set
	 */
	public void setNum3_sell_price(BigDecimal num3SellPrice) {
		num3_sell_price = num3SellPrice;
	}

	/**
	 * @return the num3_sell
	 */
	public int getNum3_sell() {
		return num3_sell;
	}

	/**
	 * @param num3Sell the num3_sell to set
	 */
	public void setNum3_sell(int num3Sell) {
		num3_sell = num3Sell;
	}

	/**
	 * @return the circulation_value
	 */
	public String getCirculation_value() {
		return circulation_value;
	}

	/**
	 * @param circulationValue the circulation_value to set
	 */
	public void setCirculation_value(String circulationValue) {
		circulation_value = circulationValue;
	}

	/**
	 * @return the bbi_balance
	 */
	public BigDecimal getBbi_balance() {
		return bbi_balance;
	}

	/**
	 * @param bbiBalance the bbi_balance to set
	 */
	public void setBbi_balance(BigDecimal bbiBalance) {
		bbi_balance = bbiBalance;
	}

	/**
	 * @return the bull_profit
	 */
	public BigDecimal getBull_profit() {
		return bull_profit;
	}

	/**
	 * @param bullProfit the bull_profit to set
	 */
	public void setBull_profit(BigDecimal bullProfit) {
		bull_profit = bullProfit;
	}

	/**
	 * @return the bull_stop_losses
	 */
	public BigDecimal getBull_stop_losses() {
		return bull_stop_losses;
	}

	/**
	 * @param bullStopLosses the bull_stop_losses to set
	 */
	public void setBull_stop_losses(BigDecimal bullStopLosses) {
		bull_stop_losses = bullStopLosses;
	}

	/**
	 * @return the short_covering
	 */
	public BigDecimal getShort_covering() {
		return short_covering;
	}

	/**
	 * @param shortCovering the short_covering to set
	 */
	public void setShort_covering(BigDecimal shortCovering) {
		short_covering = shortCovering;
	}

	/**
	 * @return the bear_stop_losses
	 */
	public BigDecimal getBear_stop_losses() {
		return bear_stop_losses;
	}

	/**
	 * @param bearStopLosses the bear_stop_losses to set
	 */
	public void setBear_stop_losses(BigDecimal bearStopLosses) {
		bear_stop_losses = bearStopLosses;
	}

	/**
	 * @return the relative_strength_index
	 */
	public BigDecimal getRelative_strength_index() {
		return relative_strength_index;
	}

	/**
	 * @param relativeStrengthIndex the relative_strength_index to set
	 */
	public void setRelative_strength_index(BigDecimal relativeStrengthIndex) {
		relative_strength_index = relativeStrengthIndex;
	}

	/**
	 * @return the activity
	 */
	public int getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(int activity) {
		this.activity = activity;
	}

	/**
	 * @return the num_per_deal
	 */
	public BigDecimal getNum_per_deal() {
		return num_per_deal;
	}

	/**
	 * @param numPerDeal the num_per_deal to set
	 */
	public void setNum_per_deal(BigDecimal numPerDeal) {
		num_per_deal = numPerDeal;
	}

	/**
	 * @return the turn_per_deal
	 */
	public BigDecimal getTurn_per_deal() {
		return turn_per_deal;
	}

	/**
	 * @param turnPerDeal the turn_per_deal to set
	 */
	public void setTurn_per_deal(BigDecimal turnPerDeal) {
		turn_per_deal = turnPerDeal;
	}

	/**
	 * @return the update_date
	 */
	public Date getUpdate_date() {
		return update_date;
	}

	/**
	 * @param updateDate the update_date to set
	 */
	public void setUpdate_date(Date updateDate) {
		update_date = updateDate;
	}

	/**
	 * @return the total_stock
	 */
	public BigDecimal getTotal_stock() {
		return total_stock;
	}

	/**
	 * @param totalStock the total_stock to set
	 */
	public void setTotal_stock(BigDecimal totalStock) {
		total_stock = totalStock;
	}

	/**
	 * @return the max_circulation_value
	 */
	public BigDecimal getMax_circulation_value() {
		return max_circulation_value;
	}

	/**
	 * @param maxCirculationValue the max_circulation_value to set
	 */
	public void setMax_circulation_value(BigDecimal maxCirculationValue) {
		max_circulation_value = maxCirculationValue;
	}

	/**
	 * @return the current_circulation_value
	 */
	public BigDecimal getCurrent_circulation_value() {
		return current_circulation_value;
	}

	/**
	 * @param currentCirculationValue the current_circulation_value to set
	 */
	public void setCurrent_circulation_value(BigDecimal currentCirculationValue) {
		current_circulation_value = currentCirculationValue;
	}

	/**
	 * @return the min_circulation_value
	 */
	public BigDecimal getMin_circulation_value() {
		return min_circulation_value;
	}

	/**
	 * @param minCirculationValue the min_circulation_value to set
	 */
	public void setMin_circulation_value(BigDecimal minCirculationValue) {
		min_circulation_value = minCirculationValue;
	}

	/**
	 * @return the avg_circulation_value
	 */
	public BigDecimal getAvg_circulation_value() {
		return avg_circulation_value;
	}

	/**
	 * @param avgCirculationValue the avg_circulation_value to set
	 */
	public void setAvg_circulation_value(BigDecimal avgCirculationValue) {
		avg_circulation_value = avgCirculationValue;
	}

	/**
	 * @return the total_value
	 */
	public BigDecimal getTotal_value() {
		return total_value;
	}

	/**
	 * @param totalValue the total_value to set
	 */
	public void setTotal_value(BigDecimal totalValue) {
		total_value = totalValue;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
