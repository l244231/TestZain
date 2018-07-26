/*
 * @(#)DidiWebCallBackInfoDomain.java
 * Author : zixian.luo001
 * Created Date: 2018年5月11日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 滴滴Web对接Token回传自定义字段
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年5月11日 zixian.luo001 create file<br>
 *              Id:DidiWebCallBackInfoDomain.java,v1.0 2018年5月11日 上午11:10:20
 */
public class DidiWebCallBackInfoDomain {
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 员工工号
	 */
	private String employeeNumber;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 接入方系统的订单ID
	 */
	private String clientOrderId;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 用车人组织（所属部门或分公司等）
	 */
	private String organization;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 机场ID
	 */
	private String airportId;
	/**
	 * 数据类型 是否必传</br>
	 * string no 航班号（rule_list包含203时，会将此航班号带入发单页）
	 */
	private String flightNumber;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 航班时间
	 */
	private String flightTime;

	@XmlElement(name = "EMPLOYEE_NUMBER")
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@XmlElement(name = "CLIENT_ORDER_ID")
	public String getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	@XmlElement(name = "ORGANIZATION")
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@XmlElement(name = "AIRPORT_ID")
	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}

	@XmlElement(name = "FLIGHT_NUMBER")
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	@XmlElement(name = "FLIGHT_TIME")
	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
}
