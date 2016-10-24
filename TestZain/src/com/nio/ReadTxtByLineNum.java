/*
 * @(#)ReadTxtByLineNum.java
 * Author : Zain.Luo
 * Created Date: 2016年10月24日 
 */
package com.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @title 通过行号获取TXT文件中的信息 
 * @author Zain.Luo
 * @version 1.0<br>
 * history<br>
 * 2016年10月24日 Zain.Luo create file<br>
 * Id:ReadTxtByLineNum.java,v1.0 2016年10月24日 下午4:50:57
 */
public class ReadTxtByLineNum {
	private static int length = 1024*1024*10;
	public static void main(String[] args) {
		
	}
	
	public static void readTxt(){
		File file = new File("E:\\Test\\NIO\\test.txt");
		
		try {
			FileChannel fc = new RandomAccessFile(file, "r").getChannel();
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, length);
			ByteBuffer buffer = ByteBuffer.allocate(length);
			int readCount;
			for(0!=(readCount = )){
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
