package com.arithmetic;

public class Test {
	public static void main(String[] args) {
		CommissionArithmetic bestCommission =  new CommissionArithmetic();
		bestCommission.setStandard(2000);
		long start = System.currentTimeMillis();
		Double[][] numArr = {
				{150d,0d,7d},
				{750d,0d,37d},
				{200d,0d,2d},
				{900d,0d,45d},
				{300d,0d,6d},
				{150d,0d,7d},
				{750d,0d,37d},
				{200d,0d,2d},
				{900d,0d,45d},
				{300d,0d,6d}
				};
		ResultBean bean = bestCommission.computeCommission(numArr);
		if(null!=bean){
			System.out.println(bean.toString());
		}
		System.out.println(System.currentTimeMillis()-start);

	}
}
