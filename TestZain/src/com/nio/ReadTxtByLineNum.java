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
import java.util.Arrays;

/**
 * @title 通过行号获取TXT文件中的信息
 * @author Zain.Luo
 * @version 1.0<br>
 *          history<br>
 *          2016年10月24日 Zain.Luo create file<br>
 *          Id:ReadTxtByLineNum.java,v1.0 2016年10月24日 下午4:50:57
 */
public class ReadTxtByLineNum {
	/**
	 * 每次读取文件内容大小
	 */
	private static int length = 1024 * 10;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String result;
		try {
			result = readTxt("E:\\Test\\NIO\\test2.txt", 77777);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(System.currentTimeMillis() - start);
	}

	/**
	 * @Title: readTxt
	 * @author: Zain.Luo
	 * @Description: 读取文件
	 * @param filePath
	 *            文件路径+文件名
	 * @param lineNum
	 *            获取内容行数
	 * @throws Exception
	 * @return String 结果
	 * @throws @history:
	 *             2016年10月25日 created
	 */
	public static String readTxt(String filePath, long lineNum) throws Exception {
		File file = new File(filePath);
		String result = null;
		try {
			FileChannel fc = new RandomAccessFile(file, "r").getChannel();

			ByteBuffer buffer = ByteBuffer.allocate(length);
			int readCount;
			int lines = 0;
			int bufferCount = 0;

			out: while (0 != (readCount = fc.read(buffer))) {
				buffer.flip();
				for (int i = 0; i < readCount; i++) {

					/* 行数判断，捕获到\n时，判断为一行 */
					if ((int) buffer.get(i) == '\n') {
						lines++;
						if (lines == lineNum - 1) {
							result = getResult(fc, bufferCount * length + i + 1);
							break out;
						}
					}
				}
				bufferCount++;
			}
			fc.close();
			if (result == null) {
				throw new Exception("无法找到对应行数内容，请确认行数是否正确");
			}
			return result;

		} catch (FileNotFoundException e) {
			throw new Exception("文件：不存在");
		} catch (IOException e) {
			throw new Exception("文件读取发生异常，请确保文件正确或具有相应权限");
		}
	}

	/**
	 * @Title: getResult
	 * @author: Zain.Luo
	 * @Description: 从上一行结尾开始读取一行数
	 * @param bufferCount
	 *            上一行结果数据位置
	 * @return
	 * @throws IOException
	 * @return String
	 * @throws @history:
	 *             2016年10月25日 created
	 */
	public static String getResult(FileChannel fc, long bufferCount) throws IOException {
		byte[] result = new byte[length];
		String resultStr;
		MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, bufferCount, length);

		/*判断是否读取完一行数据，读取完，将不进行读取数据*/
		for (int i = 0; i < length; i++) {
			if (mbb.get(i) == '\n') {
				bufferCount = 0;
				result = Arrays.copyOfRange(result, 0, i);
				break;
			}
			result[i] = mbb.get(i);
		}
		mbb.clear();

		/* 判断是否读取完一行数据，可能出现：某一行数据太大，大于缓冲区大小length，此时需要进行再次读取 */
		resultStr = new String(result, "UTF-8");
		if (resultStr == null || result.equals("")) {
			return null;
		} else if(bufferCount != 0){
			resultStr = resultStr + getResult(fc, bufferCount + length);
		}
		return resultStr;
	}

}
