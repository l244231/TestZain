/*
 * @(#)Test.java
 * Author : zixian.luo001
 * Created Date: 2017年9月21日 
 */
package com.annotation.test;

import java.util.Date;

import com.annotation.intf.TestAnnotation;

/**
 * @title TODO 
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 2017年9月21日 zixian.luo001 create file<br>
 * Id:Test.java,v1.0 2017年9月21日 下午5:58:12
 */
public class Test {
	public static void main(String[] args) {
		TestDomain test = new TestDomain();
		TestAnnotation testA;
		try {
			testA = test.getClass().getDeclaredField("showTime").getAnnotation(TestAnnotation.class);
			test.setDate(new Date());
			System.out.println(test.getDate());
			System.out.println(testA.showTime());
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
