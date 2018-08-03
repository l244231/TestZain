/*
 * @(#)TestHttp.java
 * Author : zixian.luo001
 * Created Date: 2018年6月4日 
 */
package com.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSONObject;

/**
 * @title 云问智能客户模拟调用接口
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年6月4日 zixian.luo001 create file<br>
 *              Id:TestHttp.java,v1.0 2018年6月4日 下午2:39:23
 */
public class RobotTestHttp {
	public static void main(String[] args) {
		 getResult();
//		 getResultTest();
	}

	public static String getToken() {
		String param = "appId=g2DOENcrWOm90icfuD&secret=13O9bHN2V87225915454";
		String url = "http://robot.sino-life.com/token/getToken";
		String result = HttpRequest.sendPost(url, param, "UTF-8");
		JSONObject json = JSONObject.parseObject(result);
		return json.get("access_token").toString();
	}

	public static void getResult() {
		try {
			String param = "s=p&clientId=102841_SINO_FDIH_LEDGER&access_token=" + getToken();
			String question = "视同销售及代扣代缴个税有什么要求？";
			param = param + "&question=" + URLEncoder.encode(question, "UTF-8");
			String url = "http://robot.sino-life.com/servlet/ApiChat";

			String result = HttpRequest.sendPost(url, param, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getTokenTest() {
		String param = "appId=u7jkzyxPUeBZyFhLGs&secret=ReeNPtG2Gq32F1E9D70A";
		String url = "http://int2-robot.sino-life.com/token/getToken";
		String result = HttpRequest.sendPost(url, param, "UTF-8");
		JSONObject json = JSONObject.parseObject(result);
		return json.get("access_token").toString();
	}

	public static void getResultTest() {
		try {
			String param = "s=aq&clientId=083833_SINO_FDIH_LEDGER&access_token=" + getTokenTest();
			String question = "视同销售及代扣代缴个税有什么要求？";
			param = param + "&question=" + URLEncoder.encode(question, "UTF-8");
			String url = "http://int2-robot.sino-life.com/servlet/ApiChat";

			String result = HttpRequest.sendPost(url, param, "UTF-8");
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
