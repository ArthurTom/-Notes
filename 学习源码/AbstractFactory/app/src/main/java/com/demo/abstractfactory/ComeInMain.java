package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:16
 * 功能：汽车生产入口
 */
public class ComeInMain {
	public static void main(String[] args) {
		AbstractFactory mFactory = new ShaiFactory();
		mFactory.createElectricCar().assembleElectric();
		mFactory.createGasCar().assembleGas();

		AbstractFactory yiqiFactory = new YiQiFactory();
		yiqiFactory.createElectricCar().assembleElectric();
		yiqiFactory.createGasCar().assembleGas();
	}
}
