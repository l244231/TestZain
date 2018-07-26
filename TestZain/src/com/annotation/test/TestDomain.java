/*
 * @(#)TestDomain.java
 * Author : zixian.luo001
 * Created Date: 2017年9月21日 
 */
package com.annotation.test;

import java.util.Date;

import com.annotation.intf.TestAnnotation;

/**
 * @title TODO 
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 2017年9月21日 zixian.luo001 create file<br>
 * Id:TestDomain.java,v1.0 2017年9月21日 下午5:54:14
 */
public class TestDomain {
	
	
	private Date date;

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	@TestAnnotation(showTime=true)
	private boolean showTime;
	
	@TestAnnotation(showTime=true)
	private boolean showTime2;


	public boolean isShowTime() {
		return showTime;
	}

	public void setShowTime(boolean showTime) {
		this.showTime = showTime;
	}

	public boolean isShowTime2() {
		return showTime2;
	}

	public void setShowTime2(boolean showTime2) {
		this.showTime2 = showTime2;
	} 
	
}
