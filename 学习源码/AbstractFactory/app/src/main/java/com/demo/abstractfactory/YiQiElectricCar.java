package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:14
 * 功能：一汽牌电动汽车
 */
public class YiQiElectricCar implements ElectricCar {
	@Override
	public void assembleElectric() {
		System.out.println("一汽牌电动汽车组装完毕");
	}
}
