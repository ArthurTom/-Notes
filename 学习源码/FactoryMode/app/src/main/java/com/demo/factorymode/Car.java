package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 20:47
 * 功能：抽象产品类：假设汽车由：发动机、车标、变速箱组成
 */
public abstract class Car {

	public Car() {
		engine();
		gearbox();
		logo();
	}

	public abstract void engine(); // 发动机

	public abstract void gearbox();// 变速箱

	public abstract void logo();// 车标

}
