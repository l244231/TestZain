/*
 * @(#)Test.java
 * Author : zixian.luo001
 * Created Date: 2018年5月7日 
 */
package com.nio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
 

import sun.misc.BASE64Decoder;

/**
 * @title TODO 
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 2018年5月7日 zixian.luo001 create file<br>
 * Id:Test.java,v1.0 2018年5月7日 上午11:02:45
 */
public class Base64ToImgTest {
	public static void main(String[] args) {
		String data = "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";
		try {
			base64ToMultipartFile(data);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: base64ToMultipartFile
	 * @author: zixian.luo001
	 * @Description: 将base64转化为MultipartFile数组
	 * @param data
	 *            base64文件json数组
	 * @return MultipartFile[]
	 * @throws IOException 
	 * @throws @history:
	 *             2017年10月10日 created
	 */
	public static void base64ToMultipartFile(String data) throws RuntimeException, IOException {
		 
		byte[] file = new BASE64Decoder().decodeBuffer(data);
		OutputStream out = new FileOutputStream(new File("E:\\Test\\CarDeluxe.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(out);
		bos.write(file);
		bos.flush();
		bos.close();
	}
}
