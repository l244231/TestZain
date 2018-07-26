/*
 * @(#)CtripUseTimeList.java
 * Author : zixian.luo001
 * Created Date: 2018年7月24日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程用车时间段
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月24日 zixian.luo001 create file<br>
 *              Id:CtripUseTimeList.java,v1.0 2018年7月24日 上午11:34:06
 */
public class CtripUseTimeDetail {
	/**
	 * 用车开始时间，格式为HH:mm
	 */
	private String beginUseTime;
	/**
	 * 用车截止时间，格式为HH:mm
	 */
	private String endUseTime;

	public String getBeginUseTime() {
		return beginUseTime;
	}

	@XmlElement(name = "BEGINUSETIME")
	public void setBeginUseTime(String beginUseTime) {
		this.beginUseTime = beginUseTime;
	}

	public String getEndUseTime() {
		return endUseTime;
	}
	@XmlElement(name = "ENDUSETIME")
	public void setEndUseTime(String endUseTime) {
		this.endUseTime = endUseTime;
	}
}
