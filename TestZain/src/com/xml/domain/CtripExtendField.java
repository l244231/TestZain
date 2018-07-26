/*
 * @(#)CtripExtendField.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程扩展字段
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtripExtendField.java,v1.0 2018年7月23日 下午7:02:07
 */
public class CtripExtendField {
	/**
	 * 成本中心1
	 */
	private String CostCenter1;
	/**
	 * 成本中心2
	 */
	private String CostCenter2;
	/**
	 * 成本中心3
	 */
	private String CostCenter3;
	/**
	 * 自定义字段1
	 */
	private String DefineFlag1;
	/**
	 * 自定义字段2
	 */
	private String DefineFlag2;

	public String getCostCenter1() {
		return CostCenter1;
	}

	@XmlElement(name = "COSTCENTER1")
	public void setCostCenter1(String costCenter1) {
		CostCenter1 = costCenter1;
	}

	public String getCostCenter2() {
		return CostCenter2;
	}

	@XmlElement(name = "COSTCENTER2")
	public void setCostCenter2(String costCenter2) {
		CostCenter2 = costCenter2;
	}

	public String getCostCenter3() {
		return CostCenter3;
	}

	@XmlElement(name = "COSTCENTER3")
	public void setCostCenter3(String costCenter3) {
		CostCenter3 = costCenter3;
	}

	public String getDefineFlag1() {
		return DefineFlag1;
	}

	@XmlElement(name = "DEFINEFLAG1")
	public void setDefineFlag1(String defineFlag1) {
		DefineFlag1 = defineFlag1;
	}

	public String getDefineFlag2() {
		return DefineFlag2;
	}

	@XmlElement(name = "DEFINEFLAG2")
	public void setDefineFlag2(String defineFlag2) {
		DefineFlag2 = defineFlag2;
	}
}
