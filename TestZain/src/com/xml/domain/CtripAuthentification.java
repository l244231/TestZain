/*
 * @(#)CtripAuth.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程接入账号、ticket
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtripAuth.java,v1.0 2018年7月23日 下午7:00:54
 */
public class CtripAuthentification {
	/**
	 * 接入账号 携程分配给客户公司
	 */
	private String appKey;
	/**
	 * 加密身份串 由ticket接口生成
	 */
	private String ticket;

	public String getAppKey() {
		return appKey;
	}
	@XmlElement(name = "APPKEY")
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getTicket() {
		return ticket;
	}

	@XmlElement(name = "TICKET")
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
}
