/*
 * @(#)CtripCompanyAddressDetail.java
 * Author : zixian.luo001
 * Created Date: 2018年7月24日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程公司地址
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月24日 zixian.luo001 create file<br>
 *              Id:CtripCompanyAddressDetail.java,v1.0 2018年7月24日 下午2:49:25
 */
public class CtripCompanyAddressDetail {
	/**
	 * 公司地址名称
	 */
	private String addressName;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

	/**
	 * 允许半径，单位：米
	 */
	private String allowRadius;

	public String getAddressName() {
		return addressName;
	}

	@XmlElement(name = "ADDRESSNAME")
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getLongitude() {
		return longitude;
	}

	@XmlElement(name = "LONGITUDE")
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	@XmlElement(name = "LATITUDE")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAllowRadius() {
		return allowRadius;
	}

	@XmlElement(name = "ALLOWRADIUS")
	public void setAllowRadius(String allowRadius) {
		this.allowRadius = allowRadius;
	}
}
