/*
 * @(#)TestTime.java
 * Author : zixian.luo001
 * Created Date: 2017年12月15日 
 */
package com.test;

import java.util.Calendar;

/**
 * @title TODO 
 * @author zixian.luo001
 * @version 1.0<br>
 * @history<br>
 * 2017年12月15日 zixian.luo001 create file<br>
 * Id:TestTime.java,v1.0 2017年12月15日 下午2:55:55
 */
public class TestTime {
	public static void main(String[] args) {
		System.out.println(Calendar.getInstance().getTimeInMillis()+"----"+System.currentTimeMillis());
		System.out.println("自愿退改规则（一）\t航班起飞2小时（含）前：免收退票和改期费费用；升舱费照常收取，多不退少补；若改期后，继续按照该产品直加运价出票，深航仍将支付产品服务费。（二）\t航班起飞2小时内及起飞后：自愿变更：在客票有效期内，按《深航散客客票退改签规定》的相关规定执行。若改期后，继续按照该产品直加运价出票，深航仍将支付产品服务费。自愿退票在客票有效期内，客票按《深航散客客票退改签规定》的相关规定执行，退票费率按照舱位执行，计算基础为票面价；退票后深航不再支付产品服务费。 非自愿变更、退票和签转规定旅客非自愿退票和签转，深航不再支付产品服务费；非自愿变更，深航仍将支付产品服务费。其他操作按照深航客规办理".length());
	}
}
