/*
 * @(#)CtripSetapproval.java
 * Author : zixian.luo001
 * Created Date: 2018年7月23日 
 */
package com.xml.domain;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @title 携程提前审批
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年7月23日 zixian.luo001 create file<br>
 *              Id:CtripSetapproval.java,v1.0 2018年7月23日 下午7:02:46
 */
@XmlRootElement(name = "REQUEST")
public class CtripSetapproval extends BiaInterfaceBaseDomain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6323920776743635436L;

	/**
	 * 审批单马上用车信息。目前只支持一条马上用车信息，如果有多条，只取第一条
	 */
	private List<CtripCarQuickEndorsementDetail> carQuickEndorsementDetails;

	/**
	 * 审批单国内接送机信息。目前支持一条国内接机、一条国内送机、一条国内接火车、一条国内送火车，如果一个类型下面有多条，只取该类型下第一条
	 */
	private List<CtipCarPickUpEndorsementDetail> CarPickUpEndorsementDetails;

	/**
	 * 审批单过期时间 格式：2017-01-01
	 */
	private String expiredTime;

	/**
	 * 接入账号、ticket
	 */
	private CtripAuthentification Auth;

	/**
	 * 成本中心等扩展字段列表，非必填，如无该需求则不需要传
	 */
	private CtripExtendField extendFieldList;

	/**
	 * 备注,最长支持500
	 */
	private String remark;

	/**
	 * 职级信息
	 */
	private CtripRankInfo RankInfo;

	public List<CtripCarQuickEndorsementDetail> getCarQuickEndorsementDetails() {
		return carQuickEndorsementDetails;
	}

	@XmlElement(name = "CARQUICKENDORSEMENTDETAILS")
	public void setCarQuickEndorsementDetails(List<CtripCarQuickEndorsementDetail> carQuickEndorsementDetails) {
		this.carQuickEndorsementDetails = carQuickEndorsementDetails;
	}

	public List<CtipCarPickUpEndorsementDetail> getCarPickUpEndorsementDetails() {
		return CarPickUpEndorsementDetails;
	}

	@XmlElement(name = "CARPICKUPENDORSEMENTDETAILS")
	public void setCarPickUpEndorsementDetails(List<CtipCarPickUpEndorsementDetail> carPickUpEndorsementDetails) {
		CarPickUpEndorsementDetails = carPickUpEndorsementDetails;
	}

	public String getExpiredTime() {
		return expiredTime;
	}

	@XmlElement(name = "EXPIREDTIME")
	public void setExpiredTime(String expiredTime) {
		this.expiredTime = expiredTime;
	}

	public CtripAuthentification getAuth() {
		return Auth;
	}

	@XmlElement(name = "AUTH")
	public void setAuth(CtripAuthentification auth) {
		Auth = auth;
	}

	public CtripExtendField getExtendFieldList() {
		return extendFieldList;
	}
	@XmlElement(name = "EXTENDFIELDLIST")
	public void setExtendFieldList(CtripExtendField extendFieldList) {
		this.extendFieldList = extendFieldList;
	}

	public String getRemark() {
		return remark;
	}

	@XmlElement(name = "REMARK")
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public CtripRankInfo getRankInfo() {
		return RankInfo;
	}

	@XmlElement(name = "RANKINFO")
	public void setRankInfo(CtripRankInfo rankInfo) {
		RankInfo = rankInfo;
	}
}
