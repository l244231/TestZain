/*
 * @(#)CtipCarPickUpEndorsementDetail.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程审批单国内接送机信息
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtipCarPickUpEndorsementDetail.java,v1.0 2018年7月23日 上午9:08:22
 */
public class CtipCarPickUpEndorsementDetail {
	/**
	 * 产品类型 国内接送机审批单类型： 6：国内接送机 目前只支持国内接送机
	 */
	private int ProductType = 6;

	/**
	 * 用车形态，17：接机；18：送机；19：接火车；20：送火车；
	 */
	private int PatternType;

	/**
	 * 出行人
	 */
	private List<CtripPassengerDetail> passengerList;

	/**
	 * 可多个。半角英文逗号分隔“,”，城市列表长度不能超过200 根据城市ID管控，订单城市list不得超过审批单城市list范围
	 */
	private String cities;

	/**
	 * 接机起始日期 管控时,审批单接机起始日期不能晚于订单接机起始时间
	 */
	private String pickUpBeginDate;

	/**
	 * 接机截止日期 管控时,审批单接机截止日期不能早于订单接机截至时间
	 */
	private String pickUpEndDate;

	/**
	 * 送机起始日期,管控时,审批单送机起始日期不能晚于订单送机起始日期
	 */
	private String dropOffBeginDate;

	/**
	 * 币种 默认人民币(CNY) 管控时,审批单币种与订单币种严格匹配.当前不支持外币
	 */
	private String currency = "CNY";

	/**
	 * 价格 为0不管控 向下管控，小于等于审批单金额则视为通过，反之不通过
	 */
	private float price;

	/**
	 * 车型 使用车型ID管控，审批单车型合集必须完全包含订单车型，产线传输整合后的车型类型
	 */
	private String vehicleGroup;

	/**
	 * 不管控字段累加值 传值规则：1.SkipFields必须大于等于0，小于等于所有字段值之和；2.
	 * 币种不管控，则所有的价格相关字段都不能管控；币种管控，则至少有一个价格相关字段管控
	 */
	private long skipFields;

	/**
	 * 前置管控字段累加值 传值规则：
	 * 
	 * 1.PreVerifyFields必须大于等于0，小于等于所有字段值之和；
	 * 
	 * 2.接机起始和截止日期、送机起始和截止日期日期要么都前置管控，要么都不前置管控;
	 */
	private long preVerifyFields;

	public int getProductType() {
		return ProductType;
	}

	@XmlElement(name = "PRODUCTTYPE")
	public void setProductType(int productType) {
		ProductType = productType;
	}

	public int getPatternType() {
		return PatternType;
	}

	@XmlElement(name = "PATTERNTYPE")
	public void setPatternType(int patternType) {
		PatternType = patternType;
	}

	public List<CtripPassengerDetail> getPassengerList() {
		return passengerList;
	}

	@XmlElement(name = "PASSENGERLIST")
	public void setPassengerList(List<CtripPassengerDetail> passengerList) {
		this.passengerList = passengerList;
	}

	public String getCities() {
		return cities;
	}

	@XmlElement(name = "CITIES")
	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getPickUpBeginDate() {
		return pickUpBeginDate;
	}

	@XmlElement(name = "PICKUPBEGINDATE")
	public void setPickUpBeginDate(String pickUpBeginDate) {
		this.pickUpBeginDate = pickUpBeginDate;
	}

	public String getPickUpEndDate() {
		return pickUpEndDate;
	}

	@XmlElement(name = "PICKUPENDDATE")
	public void setPickUpEndDate(String pickUpEndDate) {
		this.pickUpEndDate = pickUpEndDate;
	}

	public String getDropOffBeginDate() {
		return dropOffBeginDate;
	}

	@XmlElement(name = "DROPOFFBEGINDATE")
	public void setDropOffBeginDate(String dropOffBeginDate) {
		this.dropOffBeginDate = dropOffBeginDate;
	}

	public String getCurrency() {
		return currency;
	}

	@XmlElement(name = "CURRENCY")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getPrice() {
		return price;
	}

	@XmlElement(name = "PRICE")
	public void setPrice(float price) {
		this.price = price;
	}

	public String getVehicleGroup() {
		return vehicleGroup;
	}

	@XmlElement(name = "VEHICLEGROUP")
	public void setVehicleGroup(String vehicleGroup) {
		this.vehicleGroup = vehicleGroup;
	}

	public long getSkipFields() {
		return skipFields;
	}

	@XmlElement(name = "SKIPFIELDS")
	public void setSkipFields(long skipFields) {
		this.skipFields = skipFields;
	}

	public long getPreVerifyFields() {
		return preVerifyFields;
	}

	@XmlElement(name = "PREVERIFYFIELDS")
	public void setPreVerifyFields(long preVerifyFields) {
		this.preVerifyFields = preVerifyFields;
	}
}
