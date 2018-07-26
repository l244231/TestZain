/*
 * @(#)Test.java
 * Author : zixian.luo001
 * Created Date: 2018年5月21日 
 */
package com.xml.test;

import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.apache.commons.codec.binary.Base64;

public class DESUtil {
	//
	public static final String KEY_ALGORITHM = "DES";
	////
	// DES-->>ECBCBCCFBOFB
	public static final String CIPHER_ALGORITHM = "DES/CBC/PKCS5Padding";

	/**
	 *
	 * key
	 * 
	 * @param KeyStr
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws Exception
	 */
	private static SecretKey keyGenerator(String keyStr) throws Exception {
		DESKeySpec desKey = new DESKeySpec(keyStr.getBytes("UTF-8"));
		// DESKeySpec
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(desKey);
		return securekey;
	}

	/**
	 *
	 * @param data
	 * @param key
	 * @return
	 */
	public static String encrypt(String data, String key) throws Exception {
		Key deskey = keyGenerator(key);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		// Cipher
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// Cipher
		cipher.init(Cipher.ENCRYPT_MODE, deskey, iv);
		byte[] results = cipher.doFinal(data.getBytes("UTF-8"));
		// Base64
		return new String(Base64.encodeBase64(results));
	}

	/**
	 *
	 * @param data
	 * @param key
	 * @return
	 */
	public static String decrypt(String data, String key) throws Exception {
		Key deskey = keyGenerator(key);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		// Cipher
		cipher.init(Cipher.DECRYPT_MODE, deskey, iv);
		//
		return new String(cipher.doFinal(Base64.decodeBase64(data.getBytes())));
	}

	public static void main(String[] args) throws Exception {
//		String key = "e330B629";//e330B629c9986D600b3e 测试
		String key = "9115E931";//9115E931b83c5380739f 生产
		String request = URLDecoder.decode("PvWtImBEJFgevtmdoqweEDB7Wr4Mn7M%2FwFkuV088%2F2nDzi0mE4oL1Clm3jXPnhDzqn61hPFMTSWeaEyAP5IA25aOru97cpQAuuZ%2BiRtRCxokW9zDcd2ZdVmyc7bAMwI8LVwZQHjW8Ypw4pezlkYnQQOuYUeiTQurJZcZUDrzjI7vwdIYJQotrYiwqZuw0swU3ATsTmRaOjzU%2BkR%2BZDaQm%2FFOdgjId9MY5Ukl%2FB5HzEvuznCqPtVx67rvxv%2BQMsoEYl6wH7qVkfan4%2B4pgoyrDUV9ej%2FtGmvjVSMbzgXJxwBefcntIkdUZYX5yVQ4fMLOK3RyZFQ%2F6ja22ekozAw8Sqkq0yctlfx1OqX4SLito5%2FpS5fJdq5548WmCtT%2FjUjF8RQMHnQ7IzV6xtogtQ%2FEwiZl%2B%2F57kIxRBqdPvR51Sx%2F6hD3pUCvOUX0XgwoHDDUzzLm4k0vn2lvXujXmXEhT5z%2B7V5Z9AuU186XiwtQWbOqpF1d9nLO1MYBWz%2BkVtfa4FpilQZg6taRkIEhcKPfA5kKz1cz7TDfQ8mcXs5rRq%2B5KQP%2Bb2OABOdoMwEFP%2FELudbJwH0IG4aYBu%2B4lH2ri2FXs7HoffW%2BdbgM5fT%2Bx0FGZR8Odyji7Nxrb0GoF3iZGsyYWO6nIcVYT0FQhGka7cEE6RXM02Xo4h3gW9OicVQn8zfT5cx1v7CaXGlTq4fyq");
		 String result = decrypt(request, key);
		 System.out.println(result);
	}
}
