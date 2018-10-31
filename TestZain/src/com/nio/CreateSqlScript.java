/*
 * @(#)CreateSqlScript.java
 * Author : zixian.luo001
 * Created Date: 2018年8月23日 
 */
package com.nio;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @title 创建SQL脚本
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 				2018年8月23日 zixian.luo001 create file<br>
 *              Id:CreateSqlScript.java,v1.0 2018年8月23日 下午6:46:24
 */
public class CreateSqlScript {
	public static void main(String[] args) {
		String scriptPath = "E:\\Test\\script";
		String sqlPath = "E:\\SVN\\fude\\ATPDB\\dev_1.2.195\\full";
		getFiles(sqlPath, scriptPath);
	}

	public static void getFiles(String sqlPath, String scriptPath) {
		File file = new File(sqlPath);
		File[] tempList = file.listFiles();
		StringBuffer script = new StringBuffer();
		BufferedOutputStream bos = null;
		if (tempList[0].isFile()) {
			String scriptFileName = sqlPath.substring(0, sqlPath.lastIndexOf("\\"));
			scriptFileName = scriptFileName.substring(scriptFileName.lastIndexOf("\\")+1);
			scriptFileName =scriptFileName+ "-"+ sqlPath.substring(sqlPath.lastIndexOf("\\")+1);
			System.out.println(scriptFileName);
			File scriptFile = new File(scriptPath + "\\" + scriptFileName+".sql");
			try {
				bos = new BufferedOutputStream(new FileOutputStream(scriptFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(scriptFileName);
		}
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[0].isFile()) {
				script.append("@" +   tempList[i].getAbsolutePath() + "\r\n");
			}
			if (tempList[i].isDirectory()) {
				getFiles(tempList[i].getAbsolutePath(), scriptPath);
			}
		}
		
		if(script.length() != 0 && bos != null){
			try {
				bos.write(script.toString().getBytes());
				bos.flush();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
