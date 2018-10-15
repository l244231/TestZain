/*
 * @(#)Test.java
 * Author : Zain.Luo
 * Created Date: 2016骞�10鏈�25鏃� 
 */
package com.test;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

import com.http.HttpRequest;

/**
 * @title TODO
 * @author Zain.Luo
 * @version 1.0<br>
 *          history<br>
 *          O 2016骞�10鏈�25鏃� Zain.Luo create file<br>
 *          Id:Test.java,v1.0 2016骞�10鏈�25鏃� 涓嬪崍4:28:29
 */
public class Test {
	public static void main(String[] args) {
		Base64Decode();
		
		String str ="1992504467";
		String rulePhoneNo = "^1\\d{10}$";
		System.out.println(str.matches(rulePhoneNo));
		/*
		String url = "http://im.sino-life.com/SL_IM/FileService?tk=1010400001-20171204193457-099107c23fa9465e8d38ee926ca29c96-039::-1:0:1009278979&&df=d";
		// 判断返回的URL是拼接后的URL
		if (url.lastIndexOf("url=") != -1) {
			url = url.substring(url.lastIndexOf("url=") + 4);
		}
		System.out.println(url);

		String tmp = "zixian.luo001@sino-life.com";
		System.out.println(tmp.substring(0, tmp.indexOf("@")));
		*/
	}

	/**
	 * @Title: Base64Decode
	 * @author: zixian.luo001
	 * @Description: base64解密
	 * @return void
	 * @throws @history:
	 *             2017年8月28日 created
	 */
	public static void Base64Decode() {
		String test = "eyJJdGluZXJhcnlMaXN0IjpbeyJKb3VybmV5Tk8iOm51bGwsIkZsaWdodE9yZGVySW5mb0xpc3QiOm51bGwsIkhvdGVsT3JkZXJJbmZvTGlzdCI6bnVsbCwiVHJhaW5PcmRlckluZm9MaXN0IjpudWxsLCJIb3RlbFN1cHBsZW1lbnRPcmRlckluZm9MaXN0IjpudWxsLCJUcmFpblN1cHBsZW1lbnRPcmRlckluZm9MaXN0IjpudWxsLCJDYXJPcmRlckluZm9MaXN0IjpudWxsLCJDYXJRdWlja09yZGVySW5mb0xpc3QiOlt7IkJhc2ljSW5mbyI6eyJPcmRlcklkIjo2Nzg4MjAxOTc4LCJFc3RpbWF0ZUFtb3VudCI6MzcuMCwiT3JkZXJBbW91bnQiOjAuMCwiRGVhbEFtb3VudCI6MC4wLCJPcmRlclN0YXR1cyI6IkNhbmNlbGVkIiwiUGF5bWVudFN0YXR1cyI6IldQIiwiUGF5bWVudFR5cGUiOiJDQ0FSRCIsIkZlZVR5cGUiOiJDIiwiVUlEIjoiMjE2MDgzMjI0MyIsIlByZUVtcGxveWVlTmFtZSI6ItHut6siLCJQcmVFbXBsb3llZUlEIjoiMDEyODEwIiwiUG9saWN5SWQiOiIyMTYwODMyMjQzIiwiQ29ycElkIjoiRkRCWCIsIkNvcnBOYW1lIjoiuLu1wrGjz9W/2LnJucm33dPQz965q8u+IiwiQWNjb3VudElkIjoxMzY2NDAsIlN1YkFjY291bnRJZCI6MTkwODI2LCJDb250YWN0TmFtZSI6ItHut6siLCJJbnRsQ29kZSI6Ijg2IiwiQ29udGFjdE1vYmlsZSI6IjE4NjVrYXUxODU4IiwiQ29udGFjdEVtYWlsIjoiIiwiTmVlZEludm9pY2UiOmZhbHNlLCJFeHRyYU9yZGVycyI6MSwiQ3JlYXRlVGltZSI6IjIwMTgtMDgtMDcgMTA6MzI6NDMiLCJDb3N0Q2VudGVyMSI6Iri7tcLJ+sP8yMvK2bGjz9W5ybfd09DP3rmry77J7tvat9a5q8u+IiwiQ29zdENlbnRlcjIiOiKyxs7xsr8iLCJDb3N0Q2VudGVyMyI6IrzTsODTw7O1IiwiQ29zdENlbnRlcjQiOm51bGwsIkNvc3RDZW50ZXI1IjpudWxsLCJDb3N0Q2VudGVyNiI6bnVsbCwiSm91cm5leVJlYXNvbiI6bnVsbCwiUHJvamVjdCI6bnVsbCwiSm91bmVyeUlEIjpudWxsLCJEZWZpbmVWYWx1ZTEiOiLJ7tvat9a5q8u+ssbO8bK/IiwiRGVmaW5lVmFsdWUyIjoiuauz9iIsIlNlcnZlckZyb20iOiJBcHAiLCJJc09mZmljaWFsQ2FyZCI6bnVsbH0sIk9yZGVyUHJvZHVjdCI6eyJWZW5kb3JPcmRlcklkIjoiQjc1MzM2MDkxNjM4MzE3NjMiLCJCb29raW5nVHlwZSI6MSwiVXNlVGltZSI6IjIwMTgtMDgtMDcgMTA6MzI6NDMiLCJEZXBhcnRBZGRyZXNzIjp7IkFkZHJlc3MiOiLJ+sP8saPP1bTzz8MozvfDxSkiLCJBZGRyZXNzRGV0YWlsIjoiyfrD/LGjz9W088/DKM73w8UpIiwiQ2l0eUlkIjoiMTAwMiIsIkNpdHlOYW1lIjoiye7b2iIsIkxhdGl0dWRlIjoiMjIuNTQ1NzQ1IiwiTG9uZ2l0dWRlIjoiMTE0LjA2MzM0OCIsIk1hcFR5cGUiOjF9LCJQYXNzZW5nZXJQb3NpdGlvbiI6eyJMYXRpdHVkZSI6IjIyLjU0NDYxMTUxMDY2MyIsIkxvbmdpdHVkZSI6IjExNC4wNjQyNjAxOTYwOTYiLCJNYXBUeXBlIjoxfSwiQXJyaXZlQWRkcmVzcyI6eyJBZGRyZXNzIjoiuqOwtrPHtqvX+SIsIkFkZHJlc3NEZXRhaWwiOiK6o7C2s8e2q9f5IiwiQ2l0eUlkIjoiMTAwMiIsIkNpdHlOYW1lIjoiye7b2iIsIkxhdGl0dWRlIjoiMjIuNTE4MDg0IiwiTG9uZ2l0dWRlIjoiMTEzLjkzNzgzNiIsIk1hcFR5cGUiOjF9LCJWZW5kb3IiOnsiVmVuZG9yQ29kZSI6IlNRIiwiVmVuZG9ySWQiOjQsIlZlbmRvck5hbWUiOiLK18b7In0sIlZlaGljbGUiOnsiVmVoaWNsZUlkIjoxLCJWZWhpY2xlTmFtZSI6Ir6tvMPQzSIsIkNhckNvbG9yIjoisNfJqyIsIlBsYXRlTnVtYmVyIjpudWxsLCJTZWF0Q291bnQiOjQsIkNhclJpYWdlTnVtIjoyfSwiRHJpdmVyIjp7IkRyaXZlck5hbWUiOiLW7NPQusMiLCJEcml2ZXJNb2JpbGVJbnRlbENvZGUiOiI4NiIsIkRyaXZlck1vYmlsZVJlYWwiOiIxMzY4Njg5MzM5NyIsIkRyaXZlck1vYmxpZSI6IjEzNjg2ODkzMzk3IiwiUGxhdGVOdW1iZXIiOiLUwUIzM1owOCIsIkRyaXZlclZlaGljbGVOYW1lIjoiwejFySIsIkRyaXZlckltYWdlVXJsIjoiIiwiQ2FyQ29sb3IiOiKw18mrIn0sIlNlcnZpY2VCZWdpblRpbWUiOm51bGwsIlNlcnZpY2VFbmRUaW1lIjpudWxsLCJOb3JtYWxEaXN0YW5jZSI6IiIsIk5vcm1hbFRpbWUiOiIiLCJEZWxheVRpbWVTdGFydCI6bnVsbCwiT3JkZXJUaW1lIjoiMjAxOC0wOC0wNyAxMDozMjo0MyIsIkVzdGltYXRlVGltZUxlbmd0aCI6MTY4MCwiRXN0aW1hdGVEaXN0YW5jZSI6MTQwMDAsIkRyaXZlckFycml2ZVRpbWUiOm51bGx9LCJDYXJRdWlja0NvbnRyb2xMaXN0IjpudWxsLCJPcmRlckZlZUxpc3QiOlt7IkNvc3RTY2VuZSI6IkNBTkNFTEVEIiwiRmVlVHlwZUNvZGUiOiJDYW5jZWxGZWUiLCJGZWVOYW1lIjoizqXUvLfRIiwiQW1vdW50IjowLjAsIk9yZGVyRmVlSWQiOiIwZjYzNWUxNC1iODc3LTRmOWItYTE1Ni01OGEyYzVkYjEwZjAifV0sIk9yZGVySW5zdXJhbmNlIjp7IlByb2R1Y3RDb2RlIjpudWxsLCJDb21wYW55SWQiOm51bGwsIlBvbGljeU5vIjpudWxsLCJQb2xpY3lTdGF0dXMiOm51bGwsIlBvbGljeVVybCI6bnVsbCwiSW5zdXJlZE5hbWUiOm51bGwsIkVmZmVjdFRpbWUiOm51bGwsIkV4cGlyeVRpbWUiOm51bGwsIk1hcmsiOm51bGwsIkNvdW50IjpudWxsLCJQcmVtaXVtIjpudWxsfSwiT3JkZXJJbnZvaWNlIjp7Ikludm9pY2VJZCI6bnVsbCwiQ3VzdG9tZXJUYXhOdW1iZXIiOm51bGwsIkRldGFpbCI6bnVsbCwiRUludm9pY2VJbmZvIjpudWxsLCJJbnZvaWNlVGl0bGVUeXBlIjpudWxsLCJJbnZvaWNlVHlwZSI6bnVsbCwiUGFwZXJJbnZvaWNlSW5mbyI6bnVsbCwiVGl0bGUiOm51bGwsIlJlbWFyayI6bnVsbH0sIlBhc3NlbmdlckluZm8iOnsiQ29ycFVzZXJJZCI6IjIxNjA4MzIyNDMiLCJFbXBsb3llZUlkIjoiMDEyODEwIiwiSW50bENvZGUiOiI4NiIsIlBhc3NlbmdlcklkIjoiNDM1YTcwODMtOTk4NS00ZWUyLTg0NjktMDVmMGJjOWU0NjVkIiwiUGFzc2VuZ2VyTmFtZSI6ItHut6siLCJQYXNzZW5nZXJQaG9uZSI6IjE4NjVrYXUxODU4IiwiUGFzc2VuZ2VyRW1haWwiOiJ5dXVraS55YW5nQHNpbm8tbGlmZS5jb20iLCJDb3N0Q2VudGVyMSI6Iri7tcLJ+sP8yMvK2bGjz9W5ybfd09DP3rmry77J7tvat9a5q8u+IiwiQ29zdENlbnRlcjIiOiKyxs7xsr8iLCJDb3N0Q2VudGVyMyI6IrzTsODTw7O1IiwiQ29zdENlbnRlcjQiOm51bGwsIkNvc3RDZW50ZXI1IjpudWxsLCJDb3N0Q2VudGVyNiI6bnVsbCwiRGVwdDEiOiIiLCJEZXB0MiI6IiIsIkRlcHQzIjoiIiwiRGVwdDQiOiIiLCJEZXB0NSI6IiIsIkRlcHQ2IjoiIiwiRGVwdDciOiIiLCJEZXB0OCI6IiIsIkRlcHQ5IjoiIiwiRGVwdDEwIjoiIn0sIlBheW1lbnRJbmZvTGlzdCI6bnVsbCwiUGF5bWVudFNldHRsZW1lbnRMaXN0IjpudWxsfV0sIkRvbVBpY2tVcE9yZGVySW5mb0xpc3QiOm51bGwsIkRvbUNoYXJ0ZXJDYXJPcmRlckluZm9MaXN0IjpudWxsfV0sIlN0YXR1cyI6eyJTdWNjZXNzIjp0cnVlLCJFcnJvckNvZGUiOjAsIk1lc3NhZ2UiOiK199PDs8m5pqGjIn19";
		
		String testStr;
		try {
			testStr = new String(Base64.decodeBase64(test.getBytes("GBK")), "GBK");
			System.out.println(testStr);
			String testStr2 = new String(testStr.getBytes("GBK"), "UTF-8");
			System.out.println(testStr2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @Title: sendHttp
	 * @author: zixian.luo001
	 * @Description: 发送HTTP请求
	 * @return void
	 * @throws @history:
	 *             2017年8月28日 created
	 */
	public static void sendHttp() {
		String url = "http://172.16.206.63:8080/mtrs/app/bia/interfaceEntrance.do";
		String param = "<?xml version=\"1.0\" encoding=\"GBK\"?><REQUEST><PARTNER_ID>mtrs_ctrip</PARTNER_ID><TRAN_CODE>StatePush</TRAN_CODE><data>{\"corpId\":\"FDBX\",\"productType\":\"FlightDomestic\",\"orderId\":\"4483081334\",\"orderStatus\":\"Approving\",\"sign\":\"5B3F1F25FA17A142724541C8E79581EFE0BD0F21\"}</data></REQUEST>";
		HttpRequest.sendPost(url, param,"UTF-8");
	}

}
