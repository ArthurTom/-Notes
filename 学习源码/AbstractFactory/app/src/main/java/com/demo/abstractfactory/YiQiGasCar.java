package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:13
 * 功能：一汽燃油汽车
 */
public class YiQiGasCar implements GasCar {
	@Override
	public void assembleGas() {
		System.out.println("一汽 燃油汽车组装完毕");
	}
}
