package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:12
 * 功能：上海牌燃油汽车
 */
public class ShangHaiGasCar implements GasCar {

	@Override
	public void assembleGas() {
		System.out.println("上海牌燃油汽车组装完成");
	}
}
