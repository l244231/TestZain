/*
 * @(#)CtripCarQuickEndorsementDetail.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程马上用车信息
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtripCarQuickEndorsementDetail.java,v1.0 2018年7月23日 上午9:07:51
 */
public class CtripCarQuickEndorsementDetail {
	/**
	 * 产品类型 马上用车审批单类型。 管控时,首先根据该字段查找对应的审批单,如果查询不到,程序为用户做出提示未找到对应审批单。
	 */
	private int productType;
	/**
	 * 出行人 审批单出行人必须完全包含订单出行人，以中英文名称精确匹对管控
	 */
	private List<CtripPassengerDetail> passengerList;
	/**
	 * 城市ID集合 可多个。半角英文逗号分隔“,”，城市列表长度不能超过200<br>
	 * 根据城市ID管控，马上用车独立使用一套城市ID。订单城市list不得超过审批单城市list范围
	 */
	private String cities;

	/**
	 * 公司地址
	 */
	private List<CtripCompanyAddressDetail> CompanyAddressList;

	/**
	 * 用车开始日期<br>
	 * 管控时,审批单用车起始时间不能晚于订单用车起始时间
	 */
	private String beginUseDate;

	/**
	 * 用车结束日期<br>
	 * 管控时,审批单用车截至时间不能早于订单用车截至时间
	 */
	private String EndUseDate;

	/**
	 * 用车时间段 <br>
	 * 用车日期和时间，产线传一个字段即可。管控时用车日期必须在用车起始日期范围内，用车时间，必须在审批单用车时间范围内
	 */
	private List<CtripUseTimeDetail> useTimeList;

	/**
	 * 币种 默认人民币(CNY) 管控时,审批单币种与订单币种严格匹配.当前不支持外币
	 */
	private String currency;

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
		return productType;
	}

	@XmlElement(name = "PRODUCTTYPE")
	public void setProductType(int productType) {
		this.productType = productType;
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

	public List<CtripCompanyAddressDetail> getCompanyAddressList() {
		return CompanyAddressList;
	}

	@XmlElement(name = "COMPANYADDRESSLIST")
	public void setCompanyAddressList(List<CtripCompanyAddressDetail> companyAddressList) {
		CompanyAddressList = companyAddressList;
	}

	public String getBeginUseDate() {
		return beginUseDate;
	}

	@XmlElement(name = "BEGINUSEDATE")
	public void setBeginUseDate(String beginUseDate) {
		this.beginUseDate = beginUseDate;
	}

	public String getEndUseDate() {
		return EndUseDate;
	}

	@XmlElement(name = "ENDUSEDATE")
	public void setEndUseDate(String endUseDate) {
		EndUseDate = endUseDate;
	}

	public List<CtripUseTimeDetail> getUseTimeList() {
		return useTimeList;
	}

	@XmlElement(name = "USETIMELIST")
	public void setUseTimeList(List<CtripUseTimeDetail> useTimeList) {
		this.useTimeList = useTimeList;
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
