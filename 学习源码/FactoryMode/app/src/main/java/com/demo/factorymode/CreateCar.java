package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 21:02
 * 功能：汽车制造工厂（多工厂方法模板）
 */
public class CreateCar {
	public static void main(String[] args) {
		Factory jettaFactory = new JettaFactory();
		jettaFactory.CreateCar();
		Factory passatFactory = new PassatFactory();
		passatFactory.CreateCar();
		Factory audiFactory = new AudiFactory();
		audiFactory.CreateCar();
	}
}
