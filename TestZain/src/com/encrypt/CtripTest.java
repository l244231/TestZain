/*
 * @(#)CtripTest.java
 * Author : zixian.luo001
 * Created Date: 2017年7月5日 
 */
package com.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * @title 携程加密码测试
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2017年7月5日 zixian.luo001 create file<br>
 *              Id:CtripTest.java,v1.0 2017年7月5日 下午2:35:44
 */
public class CtripTest {
	public static void main(String[] args) {
		// 生成MD5加密签名
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			StringBuffer appSecurity = new StringBuffer();

			for (byte b : md5.digest()) {
				appSecurity.append(String.format("%02x", b & 0xff));
			}

			String str = "obk_test" + "test" + "public" + "costcenter1" + "costcenter2" + "costcenter3" + appSecurity.toString();
			StringBuffer md5Str = new StringBuffer();
			

			for (byte b : md5.digest(str.getBytes())) {
				md5Str.append(String.format("%02x", b & 0xff));
			}
			
			System.out.println(md5Str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
