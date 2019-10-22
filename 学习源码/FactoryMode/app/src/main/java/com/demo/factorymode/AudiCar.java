package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 20:55
 * 功能：奥迪汽车
 */
public class AudiCar extends Car {
	@Override
	public void engine() {
		System.out.println("组装奥迪汽车的发动机");

	}

	@Override
	public void gearbox() {
		System.out.println("组装奥迪汽车的变速箱");

	}

	@Override
	public void logo() {
		System.out.println("组装奥迪汽车的车标");

	}
}
