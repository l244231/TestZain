/*
 * @(#)CtripRankInfo.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * @title 携程职级信息
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtripRankInfo.java,v1.0 2018年7月23日 下午7:07:04
 */
public class CtripRankInfo {
	/**
	 * 职级ID
	 */
	private String rankID;

	/**
	 * 职级名称
	 */
	private String rankName;

	public String getRankID() {
		return rankID;
	}

	@XmlElement(name = "RANKID")
	public void setRankID(String rankID) {
		this.rankID = rankID;
	}

	public String getRankName() {
		return rankName;
	}
	@XmlElement(name = "RANKNAME")
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

}
