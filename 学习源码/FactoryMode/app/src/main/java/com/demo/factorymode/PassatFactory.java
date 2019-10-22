package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 20:59
 * 功能：帕萨特工厂
 */
public class PassatFactory extends Factory {
	@Override
	public Car CreateCar() {
		return new PassatCar();
	}
}
