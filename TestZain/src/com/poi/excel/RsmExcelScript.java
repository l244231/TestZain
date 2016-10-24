package com.poi.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @title RSM系统Excel文件读取脚本
 * @author Zain.Luo
 * @version 1.0<br>
 *          history<br>
 *          2016年9月17日 Zain.Luo create file<br>
 *          Id:RsmExcelScript.java,v1.0 2016年9月17日 下午9:10:25
 */
public class RsmExcelScript {
	private static String fileName = "C:\\Users\\luozixian.wb\\Desktop\\info\\集团关键风险指标及其限额设置_整理初稿_1.xlsx";
	private static int sheetNum = 0;

	public static void main(String[] args) {
		// converFormualSqlFromExcel();
		// converSqlDeptFromExcel();
		// test();
		converThresholdSqlFromExcel();
	}

	/**
	 * @Title: converSqlFromExcel
	 * @author: Zain.Luo
	 * @Description: 将Excel文件中的字段转换成SQL语句
	 * @return void
	 * @throws @history:
	 *             2016年9月17日 created
	 */
	public static void converSqlFromExcel() {

		String sqlStr = "insert into indicator_formula(INDICATOR_ID, FORMULA_ID, IS_VALID) values ('#value#', 'FM#value1#', 'Y'); ";
		String indexStr = "8,8";
		String[] cellIndex = indexStr.split(",");
		int rowBegin = 2;
		String valueStr = "#value$index$#";
		List<String> sqlList = new ArrayList<String>();
		try {
			InputStream is = new FileInputStream(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);

			XSSFRow row = null;
			XSSFCell cell = null;
			if (sheet == null) {
				System.out.println("Sheet不存在");
				return;
			}
			String lastIndicator = "";
			String currentIndi = "";
			for (int rowNum = rowBegin; rowNum < sheet.getLastRowNum(); rowNum++) {
				String tmpSql = sqlStr;
				row = sheet.getRow(rowNum);
				currentIndi = row.getCell(Integer.parseInt(cellIndex[0])).toString();
				if (currentIndi == null || currentIndi.equals("")) {
					continue;
				}

				if (currentIndi.equals(lastIndicator)) {
					continue;
				} else {
					lastIndicator = currentIndi;
				}

				for (int i = 0; i < cellIndex.length; i++) {

					tmpSql = tmpSql.replace(valueStr.replace("$index$", i == 0 ? "" : i + ""),
							row.getCell(Integer.parseInt(cellIndex[i])).toString());

				}
				sqlList.add(tmpSql);
			}
			writeSql(sqlList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Title: converSqlFromExcel
	 * @author: Zain.Luo
	 * @Description: 将Excel文件中的字段转换成SQL语句
	 * @return void
	 * @throws @history:
	 *             2016年9月17日 created
	 */
	public static void converSqlDeptFromExcel() {
		String sqlStr = "insert into indicator_dept_rela(RELA_TYPE, INDICATOR_ID, DEPT_ID, IS_VALID) values ('#value1#', '#value#', '#value2#', 'Y'); ";
		String indexStr = "8";
		String[] cellIndex = indexStr.split(",");
		int rowBegin = 2;
		String valueStr = "#value$index$#";
		List<String> sqlList = new ArrayList<String>();
		try {
			InputStream is = new FileInputStream(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);

			XSSFRow row = null;
			XSSFCell cell = null;
			if (sheet == null) {
				System.out.println("Sheet不存在");
				return;
			}
			String lastIndicator = "";
			String currentIndi = "";
			for (int rowNum = rowBegin; rowNum < sheet.getLastRowNum(); rowNum++) {
				String tmpSql = sqlStr;
				row = sheet.getRow(rowNum);
				currentIndi = row.getCell(Integer.parseInt(cellIndex[0])).toString();
				if (currentIndi == null || currentIndi.equals("")) {
					continue;
				}

				if (currentIndi.equals(lastIndicator)) {
					continue;
				} else {
					lastIndicator = currentIndi;
				}

				tmpSql = tmpSql.replace("#value#", row.getCell(8).toString());
				tmpSql = tmpSql.replace("#value1#", "AD");
				tmpSql = tmpSql.replace("#value2#", row.getCell(31).toString());
				sqlList.add(tmpSql);

				tmpSql = sqlStr;
				tmpSql = tmpSql.replace("#value#", row.getCell(8).toString());
				tmpSql = tmpSql.replace("#value1#", "MD");
				tmpSql = tmpSql.replace("#value2#", row.getCell(32).toString());
				sqlList.add(tmpSql);
			}
			writeSql(sqlList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Title: converSqlFromExcel
	 * @author: Zain.Luo
	 * @Description: 将Excel文件中的字段转换成SQL语句
	 * @return void
	 * @throws @history:
	 *             2016年9月17日 created
	 */
	public static void test() {
		String sqlStr = "insert into indicator_dept_rela(RELA_TYPE, INDICATOR_ID, DEPT_ID, IS_VALID) values ('#value1#', '#value#', '#value2#', 'Y'); ";
		String indexStr = "8";
		String[] cellIndex = indexStr.split(",");
		int rowBegin = 2;
		String valueStr = "#value$index$#";
		List<String> sqlList = new ArrayList<String>();
		try {
			InputStream is = new FileInputStream(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);

			XSSFRow row = null;
			XSSFCell cell = null;
			if (sheet == null) {
				System.out.println("Sheet不存在");
				return;
			}
			String lastIndicator = "";
			String currentIndi = "";
			for (int rowNum = rowBegin; rowNum < sheet.getLastRowNum(); rowNum++) {
				String tmpSql = sqlStr;
				row = sheet.getRow(rowNum);
				currentIndi = row.getCell(2).toString();
				if (currentIndi == null || currentIndi.equals("")) {
					continue;
				}

				if (currentIndi.equals(lastIndicator)) {
					continue;
				} else {
					lastIndicator = currentIndi;
				}

				if (row.getCell(21).toString() == null || row.getCell(21).toString().equals("")) {
					sqlList.add(row.getCell(2).toString());
				}

			}
			writeSql(sqlList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Title: converThresholdSqlFromExcel
	 * @author: Zain.Luo
	 * @Description: 将Excel文件中的字段转换成SQL语句
	 * @return void
	 * @throws @history:
	 *             2016年9月17日 created
	 */
	public static void converThresholdSqlFromExcel() {
		fileName = "D:\\Download\\info\\indicator_dml_p-罗梓贤.xlsx";
		sheetNum = 6;

		String sqlStr = "insert into indicator_threshold_info(INDICATOR_ID, STATUS_ID, LOWER_VALUE, UPPER_VALUE, THRESHOLD_FORMULA, EFFECT_DATE_START, EFFECT_DATE_END, IS_VALID) values ('#value#', '#value1#', '#value2#', '#value3#', '#value4#', SYSDATE, NULL, 'Y'); ";
		String indexStr = "0,1,2,3,4";
		String[] cellIndex = indexStr.split(",");
		int rowBegin = 1;
		String valueStr = "#value$index$#";
		List<String> sqlList = new ArrayList<String>();
		try {
			InputStream is = new FileInputStream(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);
			XSSFCell cell = null;
			XSSFRow row = null;
			if (sheet == null) {
				System.out.println("Sheet不存在");
				return;
			}

			for (int rowNum = rowBegin; rowNum < sheet.getLastRowNum(); rowNum++) {
				String tmpSql = sqlStr;
				row = sheet.getRow(rowNum);
				for (int i = 0; i < cellIndex.length; i++) {
					cell = row.getCell(Integer.parseInt(cellIndex[i]));
					if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
						tmpSql = tmpSql.replace(valueStr.replace("$index$", i == 0 ? "" : i + ""),
								cell.getStringCellValue());
					} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						tmpSql = tmpSql.replace(valueStr.replace("$index$", i == 0 ? "" : i + ""),
								cell.getNumericCellValue() + "");
					} else {
						tmpSql = tmpSql.replace(valueStr.replace("$index$", i == 0 ? "" : i + ""),
								cell.toString() + "");
					}
				}
				sqlList.add(tmpSql);

			}
			writeSql(sqlList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Title: converFormualSqlFromExcel
	 * @author: Zain.Luo
	 * @Description: 将Excel文件中的字段转换成SQL语句
	 * @return void
	 * @throws @history:
	 *             2016年9月17日 created
	 */
	public static void converFormualSqlFromExcel() {
		String sqlStr = "insert into formula_info(FORMULA_ID, FORMULA_EXPRESSION, CALC_REMARK, IS_VALID) values ('#value#', '#value1#', '#value2#', 'Y'); ";
		String indexStr = "8,21,22";
		String[] cellIndex = indexStr.split(",");
		int rowBegin = 2;
		String valueStr = "#value$index$#";
		List<String> sqlList = new ArrayList<String>();
		try {
			InputStream is = new FileInputStream(new File(fileName));
			XSSFWorkbook wb = new XSSFWorkbook(is);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);

			XSSFRow row = null;
			XSSFCell cell = null;
			if (sheet == null) {
				System.out.println("Sheet不存在");
				return;
			}
			String lastIndicator = "";
			String currentIndi = "";
			String tmpSql = "";
			for (int rowNum = rowBegin; rowNum < sheet.getLastRowNum(); rowNum++) {
				row = sheet.getRow(rowNum);
				currentIndi = row.getCell(Integer.parseInt(cellIndex[0])).toString();
				if (currentIndi == null || currentIndi.equals("")) {
					currentIndi = lastIndicator;
				}

				if (!currentIndi.equals(lastIndicator)) {
					sqlList.add(tmpSql);
					tmpSql = sqlStr;
					for (int i = 0; i < cellIndex.length; i++) {

						tmpSql = tmpSql.replace(valueStr.replace("$index$", i == 0 ? "" : i + ""),
								row.getCell(Integer.parseInt(cellIndex[i])).toString());
					}
				}
				tmpSql = tmpSql.replace(row.getCell(36).toString(), "#" + row.getCell(6).toString() + "#");
			}
			writeSql(sqlList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeSql(List<String> list) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter("E:\\Test\\test.txt"));
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
				bw.newLine();
			}
			System.out.println("SQL转换成功！");
			bw.flush();
			bw.close();
			bw = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
