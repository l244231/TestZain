package com.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReadSelectedLine {
	/**
	 * ��ȡ�ļ�ָ���С�
	 */
	public static void main(String[] args) throws Exception {
		// ָ����ȡ���к�,�кŴ�1��ʼ
		long start = System.currentTimeMillis();
		// �к�
		int lineNumber = 784145;
		// ��ȡ�ļ���
		File sourceFile = new File("E:\\Test\\NIO\\test.txt");
		// ��ȡָ������
		String s = readAppointedLineNumber(sourceFile, lineNumber);
		System.out.println(s);
		// ����ָ����ʽ����,��������ֵ����||��Ҫ�ָ����������
		System.out.println(Arrays.toString(s.split("\\|", -1)));
		// ִ����ʱ��
		System.out.println(System.currentTimeMillis() - start);
	}

	private static String readAppointedLineNumber(File sourceFile, int lineNumber) throws Exception {
		if (!(sourceFile.isFile() && sourceFile.exists())) {
			throw new Exception("ָ���ļ�:" + sourceFile.getAbsolutePath() + "������");
		}
		InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(sourceFile));
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		long fileLine = bufferedReader.lines().count();
		System.out.println(lineNumber >= fileLine);
		
		if (lineNumber <= 0 || lineNumber >= fileLine) {
			throw new Exception("�����ļ���������Χ֮��");
		}
		String lineNumberString = null;
		
		for (int i = 0; i < lineNumber; i++) {
			lineNumberString = bufferedReader.readLine();
		}
		inputStreamReader.close();
		bufferedReader.close();
		return lineNumberString;
	}

	// �ļ����ݵ���������
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