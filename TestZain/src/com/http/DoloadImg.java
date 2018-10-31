/*
 * @(#)DoloadImg.java
 * Author : zixian.luo001
 * Created Date: 2018年9月12日 
 */
package com.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @title 下载网络图片
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年9月12日 zixian.luo001 create file<br>
 *              Id:DoloadImg.java,v1.0 2018年9月12日 下午4:05:54
 */
public class DoloadImg {
	public static void main(String[] args) {
		try {
            downLoadFromUrl("https://www.didiglobal.com/dist/media/logo-zh.a7abd90d.svg", "didi_log.svg",
                    "D:/");
        } catch (Exception e) {
           e.printStackTrace();
        }
	}

	/**
	 * 从网络Url中下载文件
	 * 
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		// 得到输入流
		InputStream inputStream = conn.getInputStream();
		// 获取自己数组
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		byte[] getData = bos.toByteArray();
		// 文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}

		System.out.println("info:" + url + " download success");

	}
}
