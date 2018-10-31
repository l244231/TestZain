/*
 * @(#)CtripCity.java
 * Author : zixian.luo001
 * Created Date: 2018年8月7日 
 */
package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;

/**
 * @title TODO
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年8月7日 zixian.luo001 create file<br>
 *              Id:CtripCity.java,v1.0 2018年8月7日 下午4:23:14
 */
public class CtripCity {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("C:\\Users\\Expectation\\Desktop\\用车城市.txt"), "GBK"));
			String tmp;
			int length = 0;
			StringBuffer sb = new StringBuffer();
			while ((tmp = br.readLine()) != null) {
				sb.append(tmp);
			}
			List<CityInfo> citys = new ArrayList<CityInfo>();
			citys = JSONArray.parseArray(sb.toString(), CityInfo.class);
			for (int i = 0; i < citys.size(); i++) {
				System.out.println("insert into didi_city values('" + citys.get(i).getCityId() + "','"
						+ citys.get(i).getCityName() + "','1','1','440300','zixian.luo001',sysdate,'zixian.luo001',sysdate);");
			}
			System.out.println(citys.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
