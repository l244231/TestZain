package com.http;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestSession {

	public static void main(String[] args) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost postMethod = new HttpPost(
				"https://mtrs.sino-life.com/SL_MTRS/app/requestEntrance.do");
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("body", "{\"msg\":{\"type\":\"1\",\"method\":\"chooseBusinessBooks\",\"param\":{\"businessBook\":\"SINO_FDIH_LEDGER\",\"businessBookDesc\":\"富德生命人寿保险股份有限公司\",\"realname\":\"徐治宇\",\"userId\":\"102841\"}}}"));
		HttpResponse response;
		try {
			postMethod.setEntity((HttpEntity) new UrlEncodedFormEntity(params,Consts.UTF_8));
			response = httpclient.execute(postMethod);
			System.out.println(EntityUtils.toString(response.getEntity()));

			Header[] headers = response.getAllHeaders();
			String cookie = null;
			for (Header header : headers) {
				if (header.getName().equals("Set-Cookie"))
					cookie = header.getValue();
			}

			if (cookie != null) {
				String[] paramArray = getParams();
				for(int i=0;i<paramArray.length;i++){
					HttpGet getMethodWithCookie = new HttpGet(
							"https://mtrs.sino-life.com/SL_MTRS/app/infSimulationCall/syncCtripOrderByApplyNo.do?applyNo="
									+ paramArray[i]);
					
					getMethodWithCookie.addHeader("Cookie", cookie);
					response = httpclient.execute(getMethodWithCookie);
					System.out.println("单号："+paramArray[i]+"    "+EntityUtils.toString(response.getEntity(),Consts.UTF_8));
				}
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String[] getParams(){
		String paramStr = "REQ10891000001808000025,REQ20813500001809000010,REQ30813506001809000009,REQ10891000001809000009,REQ30813506001809000010,REQ10891000001809000012,REQ20814800001809000003,REQ10891000001809000017,REQ20814800001809000005,REQ10891000001809000019,REQ20814800001809000008,REQ10891000001809000021,REQ21013500001809000007,REQ10891000001809000024,REQ20813500001809000036,REQ10891000001809000025,REQ10891000001809000026,REQ21014800001809000001,REQ30813506001809000034,REQ30813506001809000035,REQ21013500001809000008,REQ30813506001809000036,REQ10891000001809000027,REQ10891000001809000028,REQ10891000001808000035,REQ10891000001808000036,REQ10891000001808000037,REQ10891000001808000038,REQ10891000001808000039,REQ10891000001808000040,REQ20814800001808000028,REQ10891000001808000048,REQ21013500001809000001,REQ21013500001809000002,REQ20813500001809000001,REQ21013500001809000003,REQ10891000001809000031,REQ10891000001809000032,REQ20814800001809000016,REQ20814800001809000017,REQ20814800001809000019,REQ10891000001809000035,REQ21013500001809000010,REQ10891000001809000042,REQ20814800001809000022,REQ10891000001809000044,REQ20814800001809000023,REQ10891000001809000047,REQ10891000001809000048,REQ21014800001809000002,REQ21013500001809000012,REQ10891000001809000050,REQ10891000001809000051,REQ20814800001809000026,REQ10891000001809000052,REQ21013500001809000014,REQ30813506001809000094,REQ20814800001809000031,REQ20814800001809000032,REQ20814800001809000038,REQ10891000001809000055,REQ10891000001809000056,REQ10891000001809000057";
		return paramStr.split(",");
	}
}