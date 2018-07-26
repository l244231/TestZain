/*
 * @(#)DidiWebTokenReqDomain.java
 * Author : zixian.luo001
 * Created Date: 2018年5月11日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @title 滴滴WEB页面对接TOKEN实体类
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年5月11日 zixian.luo001 create file<br>
 *              Id:DidiWebTokenReqDomain.java,v1.0 2018年5月11日 上午10:56:23
 */
@XmlRootElement(name="REQUEST")
public class DidiWebTokenReqDomain extends BiaInterfaceBaseDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2439562659824884103L;

	/**
	 * 数据类型 是否必传</br>
	 * string yes </br>
	 * 申请应用时分配的client_id
	 */
	private String clientId;
	/**
	 * 数据类型 是否必传</br>
	 * string yes </br>
	 * 申请应用时分配的client_secret
	 */
	private String clientSecret;
	/**
	 * 数据类型 是否必传</br>
	 * string yes </br>
	 * 管理员手机号（作为统一叫车人）
	 */
	private String masterPhone;
	/**
	 * 数据类型 是否必传</br>
	 * string yes </br>
	 * 乘客手机号(当前用户)
	 */
	private String passengerPhone;
	/**
	 * 数据类型 是否必传</br>
	 * int yes </br>
	 * 授权类型：0-非发单（无发单权限）；1-发单（有发单权限及其他所有权限）； 此处传1；
	 */
	private String authType;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 用车城市(出发地城市ID)，如不传，则不限制城市；传了城市ID，限制本次叫车只允许在该城市发单；
	 */
	private String cityId;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 目的地城市ID，如不传，则不限制目的地城市；传了城市ID，限制本次叫车目的地城市；
	 */
	private String toCityId;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 是 否禁止跨城（出发地和目的地不在同一城市）：0-否，1-是，默认0
	 */
	private String forbidCityCross;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 允许用车方式。不传则不限制车方式，如"301,201,203,204"; 301－单次快车；201-单次专车;203-专车接机；204-专车送机
	 */
	private String ruleList;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 允许可选车型，不传则不限制可选车型，如
	 * "600,900";600-普通快车；900-快车优享；100-专车舒适型；200-专车行政级；400-专车商务型；
	 */
	private String requireLevelList;
	/**
	 * 数据类型 是否必传</br>
	 * float no </br>
	 * 当前位置纬度（建议接入方从端获取当前位置，并转换为腾讯地图坐标），提升用户发单体验
	 */
	private String clat;
	/**
	 * 数据类型 是否必传</br>
	 * float no </br>
	 * 当前位置经度（建议接入方从端获取当前位置，并转换为腾讯地图坐标），提升用户发单体验
	 */
	private String clng;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 是否限制出发地（0-否，1-是；默认0）
	 */
	private String restrictFromPoint;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 出发地名称
	 */
	private String fromName;
	/**
	 * 数据类型 是否必传</br>
	 * float no </br>
	 * 出发地纬度
	 */
	private String flat;
	/**
	 * 数据类型 是否必传</br>
	 * float no </br>
	 * 出发地经度
	 */
	private String flng;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 是否限制目的地（0-否，1-是；默认0）
	 */
	private String restrictToPoint;
	/**
	 * 数据类型 是否必传</br>
	 * string no </br>
	 * 目的地名称
	 */
	private String toName;
	/**
	 * 数据类型 是否必传</br>
	 * float no </br>
	 * 目的地纬度
	 */
	private String tlat;
	/**
	 * 数据类型 是否必传</br>
	 * float no </br>
	 * 目的地经度
	 */
	private String tlng;
	/**
	 * 数据类型 是否必传</br>
	 * datetime no </br>
	 * 出发时间，格式：2017-09-20 21:00:00，出发时间大于当前10分钟，发预约单；如果小于10分钟或不传该字段，发实时单。
	 */
	private String departureTime;
	/**
	 * 数据类型 是否必传</br>
	 * int no </br>
	 * 是否隐藏个人中心入口（0-不隐藏，1-隐藏；默认0）
	 */
	private String personalCenterHide;
	/**
	 * 数据类型 是否必传</br>
	 * object no </br>
	 * 用车自定义信息，透传内容。在对账单中会展示该字段
	 */

	private DidiWebCallBackInfoDomain callbackInfo;

	@XmlElement(name = "CLIENT_ID")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@XmlElement(name = "CLIENT_SECRET")
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	@XmlElement(name = "MASTER_PHONE")
	public String getMasterPhone() {
		return masterPhone;
	}

	public void setMasterPhone(String masterPhone) {
		this.masterPhone = masterPhone;
	}

	@XmlElement(name = "PASSENGER_PHONE")
	public String getPassengerPhone() {
		return passengerPhone;
	}

	public void setPassengerPhone(String passengerPhone) {
		this.passengerPhone = passengerPhone;
	}

	@XmlElement(name = "AUTH_TYPE")
	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	@XmlElement(name = "CITY_ID")
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	@XmlElement(name = "TO_CITY_ID")
	public String getToCityId() {
		return toCityId;
	}

	public void setToCityId(String toCityId) {
		this.toCityId = toCityId;
	}

	@XmlElement(name = "FORBID_CITY_CROSS")
	public String getForbidCityCross() {
		return forbidCityCross;
	}

	public void setForbidCityCross(String forbidCityCross) {
		this.forbidCityCross = forbidCityCross;
	}

	@XmlElement(name = "RULE_LIST")
	public String getRuleList() {
		return ruleList;
	}

	public void setRuleList(String ruleList) {
		this.ruleList = ruleList;
	}

	@XmlElement(name = "REQUIRE_LEVEL_LIST")
	public String getRequireLevelList() {
		return requireLevelList;
	}

	public void setRequireLevelList(String requireLevelList) {
		this.requireLevelList = requireLevelList;
	}

	@XmlElement(name = "CLAT")
	public String getClat() {
		return clat;
	}

	public void setClat(String clat) {
		this.clat = clat;
	}

	@XmlElement(name = "CLNG")
	public String getClng() {
		return clng;
	}

	public void setClng(String clng) {
		this.clng = clng;
	}

	@XmlElement(name = "RESTRICT_FROM_POINT")
	public String getRestrictFromPoint() {
		return restrictFromPoint;
	}

	public void setRestrictFromPoint(String restrictFromPoint) {
		this.restrictFromPoint = restrictFromPoint;
	}

	@XmlElement(name = "FROM_NAME")
	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	@XmlElement(name = "FLAT")
	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	@XmlElement(name = "FLNG")
	public String getFlng() {
		return flng;
	}

	public void setFlng(String flng) {
		this.flng = flng;
	}

	@XmlElement(name = "RESTRICT_TO_POINT")
	public String getRestrictToPoint() {
		return restrictToPoint;
	}

	public void setRestrictToPoint(String restrictToPoint) {
		this.restrictToPoint = restrictToPoint;
	}

	@XmlElement(name = "TO_NAME")
	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	@XmlElement(name = "TLAT")
	public String getTlat() {
		return tlat;
	}

	public void setTlat(String tlat) {
		this.tlat = tlat;
	}

	@XmlElement(name = "TLNG")
	public String getTlng() {
		return tlng;
	}

	public void setTlng(String tlng) {
		this.tlng = tlng;
	}

	@XmlElement(name = "DEPARTURE_TIME")
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@XmlElement(name = "PERSONAL_CENTER_HIDE")
	public String getPersonalCenterHide() {
		return personalCenterHide;
	}

	public void setPersonalCenterHide(String personalCenterHide) {
		this.personalCenterHide = personalCenterHide;
	}

	@XmlElement(name = "CALLBACK_INFO")
	public DidiWebCallBackInfoDomain getCallbackInfo() {
		return callbackInfo;
	}

	public void setCallbackInfo(DidiWebCallBackInfoDomain callbackInfo) {
		this.callbackInfo = callbackInfo;
	}

}
