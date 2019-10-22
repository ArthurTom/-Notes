package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 20:54
 * 功能：帕沙特汽车
 */
public class PassatCar extends Car {
	@Override
	public void engine() {
		System.out.println("组装帕沙特汽车的发动机");

	}

	@Override
	public void gearbox() {
		System.out.println("组装帕沙特汽车的发动机");

	}

	@Override
	public void logo() {
		System.out.println("组装帕沙特汽车的车标");

	}
}
