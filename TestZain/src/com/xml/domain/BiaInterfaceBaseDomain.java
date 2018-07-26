/*
 * @(#)BiaInterfaceBaseDomain.java
 * Author : zixian.luo001
 * Created Date: 2018年5月11日 
 */
package com.xml.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title BIA接口基类
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年5月11日 zixian.luo001 create file<br>
 *              Id:BiaInterfaceBaseDomain.java,v1.0 2018年5月11日 下午1:54:07
 */
public class BiaInterfaceBaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 538056111075434505L;

	/**
	 * 交易码/接口编码
	 */
	private String tranCode;

	/**
	 * 第三方合作id
	 */
	private String partnerId;

	@XmlElement(name = "TRAN_CODE")
	public String getTranCode() {
		return tranCode;
	}

	public void setTranCode(String tranCode) {
		this.tranCode = tranCode;
	}

	@XmlElement(name = "PARTNER_ID")
	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
}
