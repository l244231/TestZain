/*
 * @(#)CityInfo.java
 * Author : zixian.luo001
 * Created Date: 2018年8月7日 
 */
package com.test;

/**
 * @title TODO
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年8月7日 zixian.luo001 create file<br>
 *              Id:CityInfo.java,v1.0 2018年8月7日 下午3:56:54
 */
public class CityInfo {
	private String CityId;
	private String CityName;
	private String CityNameEn;

	public String getCityId() {
		return CityId;
	}

	public void setCityId(String cityId) {
		CityId = cityId;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getCityNameEn() {
		return CityNameEn;
	}

	public void setCityNameEn(String cityNameEn) {
		CityNameEn = cityNameEn;
	}

}
