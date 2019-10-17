package com.demo.richterprinciple.transformbefore;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/17 09:04
 * 功能：
 */
public class CaculationMain {
	public static void main(String[] args) {
      Caculation1 caculation1=new Caculation1();
      System.out.println("caculation1的打印："+caculation1.funcation(10,5));
      Caculation2 caculation2=new Caculation2();
      System.out.println("caculation2的打印："+caculation2.funcation(10,5));
	}
}
