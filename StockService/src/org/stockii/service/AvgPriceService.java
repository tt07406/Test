package org.stockii.service;

import java.util.Date;
import java.util.List;


import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.stockii.application.AvgPriceAL;
import org.stockii.bean.AvgPrice;
import org.stockii.bean.Stock;
import org.stockii.common.Common;

import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Component
@Path("avgPrice")
public class AvgPriceService {
	
	private static final Logger log = LoggerFactory.getLogger(AvgPriceService.class);
	
	private AvgPriceAL avgPriceAL;

	/**
	 * @param avgPriceAL the avgPriceAL to set
	 */
	public void setAvgPriceAL(AvgPriceAL avgPriceAL) {
		
		this.avgPriceAL = avgPriceAL;
	}


	@Context
	@POST
	@Path("/selectStocks")
	@Produces("text/html")
	/**
	 * ���һ��ʱ��Ĺ�Ʊƽ��ֵ��Ӧ��
	 * @param startDate ��ʼ����
	 * @param endDate ��ֹ����
	 * @return �Ƿ����ɱ��ɹ�
	 */
	public String selectStocks(@FormParam("start") String startDate,
			@FormParam("end") String endDate) {
		log.info(startDate+":"+endDate);
		Date start = Common.getSwitchDate(startDate);
		Date end = Common.getSwitchDate(endDate);
		return avgPriceAL.selectStocks(start, end)+"";
	}


	@Context
	@GET
	@Path("/findAllStockInfo")
	@Produces("application/json")
	/**
	 * ��ȡ��Ʊ������Ϣ
	 */
	public List<Stock> findStockInfo() {
		return avgPriceAL.findAllStock();
	}
	
	@Context
	@GET
	@Path("/findA")
	@Produces("application/json")
	/**
	 * ����A����۱�
	 * @return
	 */
	public List<AvgPrice> findStockA() {
		return avgPriceAL.findA();
	}
	
	@Context
	@GET
	@Path("/findB")
	@Produces("application/json")
	/**
	 * ����B����۱�
	 * @return
	 */
	public List<AvgPrice> findStockB() {
		return avgPriceAL.findB();
	}
	
	@Context
	@GET
	@Path("/findC")
	@Produces("application/json")
	/**
	 * ����C����۱�
	 * @return
	 */
	public List<AvgPrice> findStockC() {
		return avgPriceAL.findC();
	}
}