package com.nio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatedTxt {
	public static void main(String[] args) {
		String message = "上周，苹果已经对外发布邀请函，宣布将于10月27日下周五凌晨一点（北京时间）在库比提诺举行新品发布会。此次发布会的主题为“Hello again（你好，又见面了）”。\r\n";
		
		File file = new File("E:\\Test\\NIO\\test2.txt");

		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			for (int i = 1; i < 10000000; i++) {
				bw.write("行号：" + i + "；" + message);
				if (i % 1000 == 0) {
					bw.flush();
				}
			}
			bw.close();
			bw = null;
			System.out.println("数据生成成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
