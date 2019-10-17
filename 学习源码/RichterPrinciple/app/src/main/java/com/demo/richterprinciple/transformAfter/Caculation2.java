package com.demo.richterprinciple.transformAfter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/17 09:03
 * 功能：
 */
public class Caculation2 extends Caculation1 {
	private Caculation1 caculation1=new Caculation1();
	@Override
	public int funcation(int num1, int num2) {
		return num1-num2;
	}

	public int funcaton2(int num1,int num2){
		return this.caculation1.funcation(num1,num2);// 使用组合
	}
}
