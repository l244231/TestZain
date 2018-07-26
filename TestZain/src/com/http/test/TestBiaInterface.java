/*
 * @(#)TestBiaInterface.java
 * Author : zixian.luo001
 * Created Date: 2017年11月19日 
 */
package com.http.test;

import com.http.HttpRequest;

/**
 * @title 测试BIA接口
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2017年11月19日 zixian.luo001 create file<br>
 *              Id:TestBiaInterface.java,v1.0 2017年11月19日 上午10:45:25
 */
public class TestBiaInterface {
	public static void main(String[] args) {
		String url = "http://127.0.0.1:8080/mtrs/app/bia/interfaceEntrance.do";
		String data = "{\"corpId\":\"FDBX\",\"productType\":\"FlightDomestic\",\"orderId\":\"5134696329\",\"orderStatus\":\"Cancelled\",\"sign\":\"5F6BE268531665034528B536E14109FAAA57DF2C\"}";
		String params = "<?xml version=\"1.0\" encoding=\"GBK\"?><REQUEST>	<TRAN_CODE>StatePush</TRAN_CODE>		<PARTNER_ID>mtrs_ctrip</PARTNER_ID>	<BUSINESS_NO>5130828186</BUSINESS_NO>	<data>"+data+"</data></REQUEST>";
		String result = HttpRequest.sendPost(url, params);
		System.out.println(result);
	}
}
