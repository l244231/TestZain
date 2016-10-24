package com.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadSelectedLine {
	/**
	 * 读取文件指定行。
	 */
	public static void main(String[] args) throws Exception {
		// 指定读取的行号,行号从1开始
		long start = System.currentTimeMillis();
		// 行号
		int lineNumber = 784145;
		// 读取文件，
		File sourceFile = new File("E:\\Test\\NIO\\test.txt");
		// 读取指定的行
		String s = readAppointedLineNumber(sourceFile, lineNumber);
		System.out.println(s);
		// 按照指定格式解析,并保留空值，如||需要分割出“”空置
		System.out.println(Arrays.toString(s.split("\\|", -1)));
		// 执行总时间
		System.out.println(System.currentTimeMillis() - start);
	}

	private static String readAppointedLineNumber(File sourceFile, int lineNumber) throws Exception {
		if (!(sourceFile.isFile() && sourceFile.exists())) {
			throw new Exception("指定文件:" + sourceFile.getAbsolutePath() + "不存在");
		}
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(sourceFile));
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		long fileLine = bufferedReader.lines().count();
		System.out.println(lineNumber >= fileLine);
		
		if (lineNumber <= 0 || lineNumber >= fileLine) {
			throw new Exception("不在文件的行数范围之内");
		}
		String lineNumberString = null;
		
		for (int i = 0; i < lineNumber; i++) {
			lineNumberString = bufferedReader.readLine();
		}
		inputStreamReader.close();
		bufferedReader.close();
		return lineNumberString;
	}

	// 文件内容的总行数。
	static int getTotalLines(File file) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int lines = 0;
		while (bufferedReader.readLine() != null) {
			lines++;
		}
		inputStreamReader.close();
		bufferedReader.close();
		return lines;
	}
}