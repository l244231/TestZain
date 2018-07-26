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
 *          history<br>O
 *          2016骞�10鏈�25鏃� Zain.Luo create file<br>
 *          Id:Test.java,v1.0 2016骞�10鏈�25鏃� 涓嬪崍4:28:29
 */
public class Test {
	 public static void main(String[] args){
		String url = "http://im.sino-life.com/SL_IM/FileService?tk=1010400001-20171204193457-099107c23fa9465e8d38ee926ca29c96-039::-1:0:1009278979&&df=d";
		//判断返回的URL是拼接后的URL
				if(url.lastIndexOf("url=") != -1){
					url = url.substring(url.lastIndexOf("url=")+4);
				}
				System.out.println(url);
				
				String tmp = "zixian.luo001@sino-life.com";
				System.out.println(tmp.substring(0,tmp.indexOf("@")));
	 }
	 
	 /** 
	* @Title: Base64Decode 
	* @author: zixian.luo001
	* @Description: base64解密    
	* @return void    
	* @throws 
	* @history: 2017年8月28日 created
	*/
	public static void Base64Decode(){
		 String test = "eyJPcmRlcklkIjo0OTc2MjIxNTk3LCJBdWRpdFR5cGUiOiJUIiwiU3RhdHVzIjp7IlN1Y2Nlc3MiOnRydWUsIk1lc3NhZ2UiOiK2qbWlytrIqLPJuaYiLCJFcnJvckNvZGUiOiIwIn19/7IiwiQXVkaXRTdGF0dXMiOiLK2siot/G+9iIsIlVJRCI6IjIxMTYzMjM5NTMiLCJQcmVFbXBsb3lOYW1lIjoitq2+sNXpIiwiRW1wbG95ZWVJRCI6IjA1OTkxNiIsIkFtb3VudCI6MzY2Ni4wMCwiVHJhdmVsTW9uZXkiOjAsIkNoYW5nZUFtb3VudCI6MCwiUmVmdW5kQW1vdW50IjowLCJDQ2FyZFBheUZlZSI6MCwiU2VuZFRpY2tldEZlZSI6MCwiSW5zdXJhbmNlRmVlIjowLCJDb3JwUGF5VHlwZSI6ItLyuasiLCJQcmVwYXlUeXBlIjoiQUNDTlQiLCJDcmVhdGVUaW1lIjoiMjAxNy0wOC0zMSAxNTowMjowOSIsIkZpbmlzaERhdGUiOiIyMDE3LTA4LTMxIDE1OjA0OjUyIiwiUHJpbnRUaWNrZXRUaW1lIjoiMTkwMC0wMS0wMSAwMDowMDowMCIsIkZsaWdodENsYXNzIjoiTiIsIkZsaWdodFdheSI6IrWls8wiLCJSZW1hcmtzIjoiIiwiUHJlQm9va0RheXMiOjMxLCJDb3N0Q2VudGVyIjoiuLu1wrGjz9W/2LnJucm33dPQz965q8u+IiwiQ29zdENlbnRlcjIiOiKyxs7x18q98NbQ0MQtssbO8bmyz+2yvyIsIkNvc3RDZW50ZXIzIjois/ay7iIsIkNvc3RDZW50ZXI0IjoiIiwiQ29zdENlbnRlcjUiOiIiLCJDb3N0Q2VudGVyNiI6IiIsIkNvbmZpcm1QZXJzb24iOiIiLCJDb25maXJtUGVyc29uMiI6IiIsIkNvbmZpcm1QZXJzb25DQyI6IiIsIkNvbmZpcm1QZXJzb25DQzIiOiIiLCJDb25maXJtVHlwZSI6IkEyO0MwIiwiQ29uZmlybVR5cGUyIjoiIiwiRGVmaW5lRmxhZyI6IrLGzvG5ss/tsr8iLCJEZWZpbmVGbGFnMiI6IratvrDV6bzDxM+z9rLuIiwiVG90YWxTZXJ2aWNlRmVlIjoxNiwiU2VydmljZURldGFpbEluZm8iOnsiQmFzZVNlcnZpY2VGZWUiOjE2LCJCaW5kU2VydmljZUZlZSI6MCwiU3BlY2lhbFNlcnZpY2VGZWUiOjAsIlVuV29ya1RpbWVTZXJ2aWNlRmVlIjowLCJWSVBTZXJ2aWNlRmVlIjowfSwiTkJpbGxpbmdUeXBlIjoiRCIsIlRpY2tldFN0YXR1cyI6IkEiLCJKb3VybmV5UmVhc29uIjoiIiwiUHJvamVjdCI6IiIsIkN1cnJlbmN5IjoiQ05ZIn0sIkRlbGl2ZXJ5SW5mbyI6eyJEZWxpdmVyeUluZm8iOiKyu9Do0NCzzLWlIiwiQ29udGFjdFBob25lIjoiMDE1NzA2NDQyNjg2IiwiQ29udGFjdE1vYmlsZSI6IjAxNTcwNjQ0MjY4NiIsIkNvbnRhY3ROYW1lIjoiyczCw7/Nu6ciLCJEZWxpdmVyeUFkZHJlc3MiOiIifSwiRmxpZ2h0SW5mbyI6W3siU2VxdWVuY2UiOiIxIiwiRmxpZ2h0IjoiQ0EzNzkzIiwiQWlyTGluZUNvZGUiOiJDQSIsIkFpckxpbmVOYW1lIjoi1tC5+rn6ur0iLCJBZ3JlZW1lbnQiOiK3x9Ct0ukiLCJBbW91bnQiOjM2NTAuMDAsIlByaWNlIjozNjAwLCJQcmludFByaWNlIjozNjAwLCJQcmljZVJhdGUiOjEuMDAsIk9pbEZlZSI6MC4wMCwiVGF4Ijo1MCwiQmluZHR5cGUiOiIiLCJCaW5kTnVtIjowLCJCaW5kQW1vdW50IjowLjAwLCJTZXJ2ZXJGZWUiOjE2LCJTdWJzaWR5IjowLjAwLCJBZ2VUeXBlIjoiQURVIiwiQ2xhc3NOYW1lIjoizbe1yLLVIiwiU3ViQ2xhc3MiOiJGIiwiT2ZmaWNlTm8iOiJTWlgyOTEiLCJOb25SZXIiOiLT0Mz1vP64xMbaIiwiUmVyTm90ZXMiOiLG8LfJo6i6rKOpx7DNrLXIstXOu8Pit9G4/LjEo6zG8LfJuvPQ6MrVyKHGscPmvNs1o6W1xLj8uMS30aGjuMTG2rfR0+vGsbzbsu627s2syrG3osn6yrGjrMG91d/Q6M2syrHK1cihoaMiLCJOb25SZWYiOiLT0Mz1vP7Ny8axIiwiUmVmTm90ZXMiOiLG8LfJo6i6rKOpx7DQ6MrVyKHGscPmvNs1o6W1xM3LxrG30aOsxvC3ybrz0OjK1cihxrHD5rzbMTCjpbXEzcvGsbfRo6jTpLb5w+LK1c3LxrG30aOpoaMiLCJOb25FbmQiOiLT0Mz1vP7HqdeqIiwiRW5kTm90ZXMiOiLUytDtx6nXqqOsyOex5Lj8uvOz0NTLyMvKytPDxrG827jf09q5+rq9xrG826Os0Oiyucbrsu627rrzvfjQ0LHkuPyjrMj0tc3T2rn6ur3Gsbzbo6yy7rbusrvNy6GjIiwiUmVtYXJrIjoiIiwiVGFrZW9mZlRpbWUiOiIyMDE3LTEwLTAxIDEzOjAwOjAwIiwiQXJyaXZhbFRpbWUiOiIyMDE3LTEwLTAxIDE1OjUwOjAwIiwiRENpdHlOYW1lIjoiye7b2iIsIkRDaXR5TmFtZV9FTiI6Isnu29oiLCJEQ2l0eUNvZGUiOiJTWlgiLCJEUG9ydE5hbWUiOiKxprCyu/qzoSIsIkRQb3J0Q29kZSI6IlNaWCIsIkRBaXJwb3J0Ijp7Ik5hbWUiOiKxprCyufq8yrv6s6EzusW6vdW+wqUiLCJOYW1lX2VuIjoisaawsrn6vMq7+rOhM7rFur3VvsKlIiwiU2hvcnRuYW1lIjoiVDO6vdW+wqUiLCJTaG9ydG5hbWVfZW4iOiJUM7q91b7CpSJ9LCJBQ2l0eU5hbWUiOiK8w8TPIiwiQUNpdHlOYW1lX0VOIjoivMPEzyIsIkFDaXR5Q29kZSI6IlROQSIsIkFQb3J0TmFtZSI6ItKjx727+rOhIiwiQVBvcnRDb2RlIjoiVE5BIiwiQUFpcnBvcnQiOnsiTmFtZSI6ItKjx725+rzKu/qzobq91b7CpSIsIk5hbWVfZW4iOiLSo8e9ufq8yrv6s6G6vdW+wqUiLCJTaG9ydG5hbWUiOiIiLCJTaG9ydG5hbWVfZW4iOiIifSwiSXNPcGVuVHJhbiI6IiIsIklzU3VyZmFjZSI6IkYiLCJSZWFzb24iOiJBWiIsIlJlYXNvbkRlc2MiOiK4xMepu/LNy8ax0vLL2CIsIlByZUJvb2tSZWFzb24iOiIiLCJQcmVCb29rUmVhc29uRGVzYyI6IiIsIkxvd0ZsaWdodCI6IlpIOTkwMyIsIkxvd0NsYXNzIjoiWSIsIkxvd2VzdFByaWNlIjoxODAwLjAwLCJMb3dSYXRlIjoxLjAwLCJMb3dEVGltZSI6IjIwMTctMTAtMDEgMTM6MDA6MDAiLCJBZHRrIjoiMjAxNy0wOC0zMSAxNzowMjowMCIsIlRwbSI6MTU5OCwiU3RhbmRhcmRQcmljZSI6MzYwMC4wMCwiSGFzTWVhbCI6ZmFsc2UsIkZsaWdodFRpbWUiOjE3MCwiQ2xhc3NSZWFzb24iOiIiLCJDbGFzc1JlYXNvbkRlc2MiOiIiLCJTcGVpY2FsQ2xhc3NUeXBlTmFtZSI6IiIsIlNwZWljYWxDbGFzc1R5cGVEZXNjcmlwdGlvbiI6IiJ9XSwiUGFzc2VuZ2VySW5mbyI6W3siUGFzc2VuZ2VyQmFzaWMiOnsiQ29ycEVpZCI6IjA1OTkxNiIsIlBhc3Nlbmdlck5hbWUiOiK2rb6w1ekiLCJQYXNzZW5nZXJOYW1lUFkiOiIiLCJOYXRpb25hbGl0eUNvZGUiOiJDTiIsIk5hdGlvbmFsaXR5TmFtZSI6ItbQufq088K9IiwiQ2FyZFR5cGVOYW1lIjoiye233dakIiwiQ2FyZFR5cGVOdW1iZXIiOiIzNzA3ODExOTg5MDUyOTQ4MjEiLCJHZW5kZXIiOiJGIiwiQmlydGhkYXkiOiIxOTg5LTA1LTI5IDAwOjAwOjAwIiwiQ29zdENlbnRlciI6Iri7tcKxo8/Vv9i5ybnJt93T0M/euavLviIsIkNvc3RDZW50ZXIyIjoissbO8dfKvfDW0NDELbLGzvG5ss/tsr8iLCJDb3N0Q2VudGVyMyI6IrP2su4iLCJDb3N0Q2VudGVyNCI6IiIsIkNvc3RDZW50ZXI1IjoiIiwiQ29zdENlbnRlcjYiOiIiLCJEZXB0MSI6IiIsIkRlcHQyIjoiIiwiRGVwdDMiOiIiLCJEZXB0NCI6IiIsIkRlcHQ1IjoiIiwiRGVwdDYiOiIiLCJEZXB0NyI6IiIsIkRlcHQ4IjoiIiwiRGVwdDkiOiIiLCJEZXB0MTAiOiIifSwiU2VxdWVuY2VJbmZvIjpudWxsfV0sIlJlZnVuZEluZm8iOm51bGwsIkZsaWdodENoYW5nZUluZm8iOm51bGx9XSwiSG90ZWxPcmRlckluZm9MaXN0IjpudWxsLCJUcmFpbk9yZGVySW5mb0xpc3QiOm51bGwsIkhvdGVsU3VwcGxlbWVudE9yZGVySW5mb0xpc3QiOm51bGwsIlRyYWluU3VwcGxlbWVudE9yZGVySW5mb0xpc3QiOm51bGwsIkNhck9yZGVySW5mb0xpc3QiOm51bGx9XSwiU3RhdHVzIjp7IlN1Y2Nlc3MiOnRydWUsIkVycm9yQ29kZSI6MCwiTWVzc2FnZSI6IrX308OzybmmoaMifX0=";
		 String testStr;
		try {
			testStr = new String(Base64.decodeBase64(test.getBytes("GBK")),"GBK");
			System.out.println(testStr);
			String testStr2 = new String(testStr.getBytes("GBK"),"UTF-8");
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
	* @throws 
	* @history: 2017年8月28日 created
	*/
	public static void sendHttp(){
		 String url = "http://172.16.206.63:8080/mtrs/app/bia/interfaceEntrance.do";
		 String param = "<?xml version=\"1.0\" encoding=\"GBK\"?><REQUEST><PARTNER_ID>mtrs_ctrip</PARTNER_ID><TRAN_CODE>StatePush</TRAN_CODE><data>{\"corpId\":\"FDBX\",\"productType\":\"FlightDomestic\",\"orderId\":\"4483081334\",\"orderStatus\":\"Approving\",\"sign\":\"5B3F1F25FA17A142724541C8E79581EFE0BD0F21\"}</data></REQUEST>";
		 HttpRequest.sendPost(url, param);
	}

}
