/*
 * @(#)CtripPassengerDetail.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程出行人
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtripPassengerDetail.java,v1.0 2018年7月23日 下午7:11:46
 */
public class CtripPassengerDetail {
	/**
	 * 姓名
	 * 姓名支持数字、大小写字母、中文以及右斜杠/和空格如果使用英文名，请使用/符号分割lastname/firstname，如中文张三对应Zhang/
	 * San（英文名不区分大小写）
	 */
	private String name;
	/**
	 * 证件类型 暂不管控。
	 */
	private String credentialsType;
	/**
	 * 证件号码
	 * 如果要管控证件号码，则所有乘客证件号码全部不能为空，可传多个证件号码，用英文逗号分割；如果不管控证件号码，则所有乘客证件号码必须全部为空。
	 */
	private String CredentialsNumber;
	/**
	 * 出行人EID
	 */
	private String EID;
	/**
	 * 英文姓名
	 */
	private String nameEn;

	public String getName() {
		return name;
	}

	@XmlElement(name = "NAME")
	public void setName(String name) {
		this.name = name;
	}

	public String getCredentialsType() {
		return credentialsType;
	}
	@XmlElement(name = "CREDENTIALSTYPE")
	public void setCredentialsType(String credentialsType) {
		this.credentialsType = credentialsType;
	}

	public String getCredentialsNumber() {
		return CredentialsNumber;
	}
	@XmlElement(name = "CREDENTIALSNUMBER")
	public void setCredentialsNumber(String credentialsNumber) {
		CredentialsNumber = credentialsNumber;
	}

	public String getEID() {
		return EID;
	}
	@XmlElement(name = "EID")
	public void setEID(String EID) {
		this.EID = EID;
	}

	public String getNameEn() {
		return nameEn;
	}
	@XmlElement(name = "NAMEEN")
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

}
