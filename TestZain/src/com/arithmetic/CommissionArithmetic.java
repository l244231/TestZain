/*
 * @(#)Test.java
 * Author : Zain
 * Created Date: 2016年10月12日 
 */
package com.arithmetic;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @title TODO
 * @author Zain
 * @version 1.0<br>
 *          history<br>
 *          2016年10月12日 Zain create file<br>
 *          Id:Test.java,v1.0 2016年10月12日 下午7:56:50
 */
public class CommissionArithmetic {

	/**
	 * 计算标准值，默认为2000
	 */
	private double standard = 2000d;

	/**
	 * 一维数组下标集合字符串
	 */
	private String indexList = "";
	
	private long count = 0;

	/**
	 * @Title: computeCommission
	 * @author: Zain.Luo
	 * @Description: 计算提成方案，并获取最优方案
	 * @param numArr
	 *            提成方案
	 * @return
	 * @return ResultBean 最优提成方案
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	public ResultBean computeCommission(Double[][] numArr) {

		List<NumBean> numList = new ArrayList<NumBean>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < numArr.length; i++) {
			numList.add(new NumBean(i, numArr[i][0]));
			indexList = indexList + "," + i;
		}
		System.out.println("将二维数组转换成一维数组:"+(System.currentTimeMillis()-start));
		
		start = System.currentTimeMillis();
		 
		List<CheckResultBean> result = checkGroup("", 0, numList);
		System.out.println("求数组集合:"+(System.currentTimeMillis()-start));
		System.out.println("循环次数："+count);
		System.out.println("数组结果数："+result.size());
		
		start = System.currentTimeMillis();
		List<ResultBean> changList = changeArray(result, numArr);
		System.out.println("数组转换为二维数组："+(System.currentTimeMillis()-start));
		System.out.println("去重复后数组结果："+changList.size());
		start = System.currentTimeMillis();
		ResultBean test= getBestCommissionProgram(changList);
		System.out.println("获取最优解："+(System.currentTimeMillis()-start));
		return test;
	}

	/**
	 * @Title: checkGroup
	 * @author: Zain
	 * @Description: 判断数组大于或等于标准数的集合
	 * @param groupStr
	 * @param sum
	 * @param numList
	 * @return
	 * @return List<String>
	 * @throws @history:
	 *             2016年10月13日 created
	 */
	private List<CheckResultBean> checkGroup(String groupStr, double sum, List<NumBean> numList) {
		List<CheckResultBean> tmpResult = null;
		List<CheckResultBean> checkResult = new ArrayList<CheckResultBean>();
		CheckResultBean result = null;
		String tempStr = "";
		String failStr = "";
		long start = 0;
		double tmpSum = 0;
		while (numList.size() != 0) {
			// 新生成一个集合存储数组
			List<NumBean> tmpNumList = new ArrayList<NumBean>(numList); 

			// 描述组合
			tempStr = (groupStr == "" ? groupStr : groupStr + ",") + numList.get(0).getIndex();
			tmpSum = sum + numList.get(0).getValue();
			if (tmpSum >= standard) {
				failStr = "";
				failStr = gatherLastIndex(tempStr, indexList);
				result = new CheckResultBean(tempStr, failStr);
				checkResult.add(result);
			} else {
				// 将数组当前值移除
				tmpNumList.remove(numList.get(0));
				tmpResult = checkGroup(tempStr, tmpSum, tmpNumList);

				// 判断是否存在组合，组合存在，添加到集合中
				if (!tmpResult.isEmpty()) {
					checkResult.addAll(tmpResult);
				}
			}
			numList.remove(numList.get(0));
			count++;
		}

		return checkResult;
	}

	/**
	 * @Title: getBestCommissionProgram
	 * @author: Zain.Luo
	 * @Description: 获取最优提成方案
	 * @param resultList
	 * @return void
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private ResultBean getBestCommissionProgram(List<ResultBean> resultList) {
		if (resultList.isEmpty()) {
			return null;
		}

		int index = 0;
		double best = resultList.get(0).sumCommissionAmount();
		for (int i = 1; i < resultList.size(); i++) {
			if (resultList.get(i).sumCommissionAmount() < best) {
				best = resultList.get(i).sumCommissionAmount();
				index = i;
			}
		}

		return resultList.get(index);
	}

	/**
	 * @Title: changeArray
	 * @author: Zain.Luo
	 * @Description: 将匹配后的结果数据转换成数组集合
	 * @param result
	 *            匹配后的结果数据
	 * @param baseArray
	 *            基本数组（原始）
	 * @return List<ResultBean> 数组集合
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private List<ResultBean> changeArray(List<CheckResultBean> result, Double[][] baseArray) {
		List<ResultBean> resultList = new ArrayList<ResultBean>();
		result = removeRepeatGroup(result);
		for (CheckResultBean tmp : result) {
			resultList.add(resultToArray(tmp, baseArray));
		}
		return resultList;

	}

	/**
	 * @Title: removeRepeatGroup
	 * @author: Zain.Luo
	 * @Description: 将集合中存在包含关系的组合去掉，只留下最简组合
	 * @param groupList
	 * @return
	 * @return List<CheckResultBean>
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private List<CheckResultBean> removeRepeatGroup(List<CheckResultBean> groupList) {
		long start = System.currentTimeMillis();
		List<CheckResultBean> result = new ArrayList<CheckResultBean>(groupList);

		for (int i = 0; i < groupList.size(); i++) {
			result = removeRepeatGroup(groupList.get(i), result);
		}
		System.out.println("去除重复数组："+(System.currentTimeMillis()-start));
		return result;
	}

	/**
	 * @Title: removeRepeatGroup
	 * @author: Zain.Luo
	 * @Description: 判断checkBean的组合是否在集合中被包含，如果被包含，则删除包含的组合
	 * @param checkBean
	 *            待判断组合
	 * @param groupList
	 *            组合集合
	 * @return List<CheckResultBean> 结果
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private List<CheckResultBean> removeRepeatGroup(CheckResultBean checkBean, List<CheckResultBean> groupList) {
		List<CheckResultBean> result = new ArrayList<CheckResultBean>(groupList);
		if(!result.remove(checkBean)){
			return result;
		}

		String[] tmpStr = checkBean.getSuccess().split(",");
		for (int i = 0; i < groupList.size(); i++) {
			if (removeRepeatGroup(tmpStr, groupList.get(i))) {
				result.remove(groupList.get(i));
			}
		}
		result.add(checkBean);
		return result;
	}

	/**
	 * @Title: removeRepeatGroup
	 * @author: Zain.Luo
	 * @Description: 判断两个组合是否重复，如果是返回true,否则返回false
	 * @param checkBean
	 *            判断组合
	 * @param checkedBean
	 *            待判断组合
	 * @return boolean 判断结果
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private boolean removeRepeatGroup(String[] checkBean, CheckResultBean checkedBean) {
		for (int i = 0; i < checkBean.length; i++) {
			if (checkedBean.getSuccess().indexOf(checkBean[i]) == -1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @Title: gatherLastIndex
	 * @author: Zain.Luo
	 * @Description: 根据成功匹配的数组下标，获取剩余不匹配的数组下标字符串
	 * @param successIndex
	 *            成功匹配数组下标集合
	 * @param allIndexStr
	 *            所有数组下标集合
	 * @return String 剩余不匹配的数组下标字符串
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private String gatherLastIndex(String successIndex, String allIndexStr) {
		String result = allIndexStr;
		String[] tmpArr = successIndex.split(",");
		for (int i = 0; i < tmpArr.length; i++) {
			result = result.replace(tmpArr[i], "");
		}
		result = result.replaceAll(",,+", ",");
		result = result.replaceAll("^,|$,", "");
		return result;
	}

	/**
	 * @Title: resultToArray
	 * @author: Zain.Luo
	 * @Description: 将匹配的结果下标，转换成数组
	 * @param result
	 * @param baseArray
	 * @return
	 * @return ResultBean
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	private ResultBean resultToArray(CheckResultBean result, Double[][] baseArray) {
		List<Double[]> successList = new ArrayList<Double[]>();
		List<Double[]> failList = new ArrayList<Double[]>();

		if (result.getSuccess() != null) {
			String[] successStr = result.getSuccess().split(",");
			for (int i = 0; i < successStr.length; i++) {
				successList.add(baseArray[Integer.parseInt(successStr[i])]);
			}
		}
		if (result.getFail() != null) {
			String[] failStr = result.getFail().split(",");
			for (int i = 0; i < failStr.length; i++) {
				failList.add(baseArray[Integer.parseInt(failStr[i])]);
			}
		}
		ResultBean resultBean = new ResultBean(successList, failList);
		return resultBean;

	}

	/**
	 * @Title: setStandard
	 * @author: Zain.Luo
	 * @Description: 设置标准值
	 * @param standard
	 * @return void
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	public void setStandard(double standard) {
		this.standard = standard;
	}

	/**
	 * @Title: getStandard
	 * @author: Zain.Luo
	 * @Description: 获取标准值
	 * @return
	 * @return double 标准值
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	public double getStandard() {
		return this.standard;
	}
}

/**
 * @title 算法元素类，用于记录数组在二维数组中的定位
 * @author Zain
 * @version 1.0<br>
 *          history<br>
 *          2016年10月13日 Zain create file<br>
 *          Id:Test2.java,v1.0 2016年10月13日 下午9:35:19
 */
class NumBean {
	/**
	 * 数组下在二维数组中的下标
	 */
	private int index;
	/**
	 * 数组第一位值。
	 */
	private double value;

	public NumBean(int index, double value) {
		this.index = index;
		this.value = value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

/**
 * @title 组合数大于标准数组合结果类
 * @author Zain
 * @version 1.0<br>
 *          history<br>
 *          2016年10月13日 Zain create file<br>
 *          Id:Test2.java,v1.0 2016年10月13日 下午10:13:50
 */
class CheckResultBean {
	/**
	 * 组合数大于标准数结果下标集合字符串，以","分割
	 */
	private String success;

	/**
	 * 成功组合后，剩余组合下标字符串，以","分割
	 */
	private String fail;

	public CheckResultBean(String success, String fail) {
		this.success = success;
		this.fail = fail;
	}

	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success == "" ? null : success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * @return the fail
	 */
	public String getFail() {
		return fail == "" ? null : fail;
	}

	/**
	 * @param fail
	 *            the fail to set
	 */
	public void setFail(String fail) {
		this.fail = fail;
	}
}

/**
 * @title 组合结果类
 * @author Zain.Luo
 * @version 1.0<br>
 *          history<br>
 *          2016年10月14日 Zain.Luo create file<br>
 *          Id:Test2.java,v1.0 2016年10月14日 下午1:57:10
 */
class ResultBean {
	/**
	 * 组合数大于标准数，数组结果集
	 */
	List<Double[]> success;

	/**
	 * 组合后剩余数组结果集
	 */
	List<Double[]> fail;

	public ResultBean(List<Double[]> success, List<Double[]> fail) {
		this.success = success;
		this.fail = fail;
	}

	/**
	 * @return the success
	 */
	public List<Double[]> getSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(List<Double[]> success) {
		this.success = success;
	}

	/**
	 * @return the fail
	 */
	public List<Double[]> getFail() {
		return fail;
	}

	/**
	 * @param fail
	 *            the fail to set
	 */
	public void setFail(List<Double[]> fail) {
		this.fail = fail;
	}

	/**
	 * @Title: getCommissionAmount
	 * @author: Zain.Luo
	 * @Description: 计算提成金额
	 * @return double
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	public double sumCommissionAmount() {
		double result = 0;
		for (int i = 0; i < fail.size(); i++) {
			result += fail.get(i)[2];
		}
		return result;
	}

	/**
	 * @Title: getSuccessCount
	 * @author: Zain.Luo
	 * @Description: 获取成功组合的组合个数
	 * @return
	 * @return int
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	public int getSuccessCount() {
		return success.size();
	}

	/**
	 * @Title: getFailCount
	 * @author: Zain.Luo
	 * @Description: 获取剩余组合的组合个数
	 * @return
	 * @return int
	 * @throws @history:
	 *             2016年10月14日 created
	 */
	public int getFailCount() {
		return fail.size();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("SUCCESS:" + JSON.toJSONString(success).toString());
		sb.append("\r\n");
		sb.append("FAIL:" + JSON.toJSONString(fail).toString());
		sb.append("\r\n");
		sb.append("SUM:" + sumCommissionAmount());
		sb.append("\r\n");
		sb.append("=====================================");
		return sb.toString();
	}
}
