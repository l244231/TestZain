/*
 * @(#)HttpDownload.java
 * Author : zixian.luo001
 * Created Date: 2018年3月5日 
 */
package com.http;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @title 通过http下载图片
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年3月5日 zixian.luo001 create file<br>
 *              Id:HttpDownload.java,v1.0 2018年3月5日 下午5:09:30
 */
public class HttpDownload {
	public static void main(String[] args) {
		download("http://im.sino-life.com/SL_IM/FileService?tk=1010400001-20141119143152-be2479aafb754f3d92763235a1bac153-009::-1:0:1427991409&&df=d");
	}

	public static void download(String url) {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setReadTimeout(30000);
			conn.setConnectTimeout(5000);
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStream inputStream = conn.getInputStream();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\code\\test\\交通费85.pdf"));
				byte[] buffer = new byte[1024];
				int len = -1;
				while ((len = inputStream.read(buffer)) != -1) {
					bos.write(buffer, 0, len);
					bos.flush();
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
