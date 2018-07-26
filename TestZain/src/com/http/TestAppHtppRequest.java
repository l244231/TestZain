/*
 * @(#)TestAppHtppRequest.java
 * Author : luozixian.wb
 * Created Date: 2017年6月5日 
 */
package com.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @title TODO
 * @author luozixian.wb
 * @version 1.0<br>
 * @history<br>
 * 				2017年6月5日 luozixian.wb create file<br>
 *              Id:TestAppHtppRequest.java,v1.0 2017年6月5日 上午9:38:43
 */
public class TestAppHtppRequest {
	public static void main(String[] args) {
		String params = loadJson("D:\\code\\http\\test.txt");
		params = params.replaceAll("[\\s\\p{Zs}]", "");
		params = params.replaceAll("\\\\", "");
		params = params.replaceAll("\\[\"|\"\\]", "");
		System.out.println(params);
		// sendHttp(loadJson("D:\\code\\http\\testJson.txt"));
		sendHttp(params);
	}

	public static void sendHttp(String parmas) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameStr = "http://localhost:8080/mtrs/app/requestEntrance.do?body="
					+ URLEncoder.encode(parmas, "UTF-8");
			System.out.println(urlNameStr);
			URL url = new URL(urlNameStr);
			URLConnection connection = url.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			connection.connect();
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String loadJson(String path) {
		File file = new File(path);
		StringBuffer rs = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				rs.append(tmp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rs.toString();
	}
}
