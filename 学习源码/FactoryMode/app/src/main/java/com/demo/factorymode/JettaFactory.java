package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 20:58
 * 功能：捷达工厂方法
 */
public class JettaFactory extends Factory {
	@Override
	public Car CreateCar() {
		return new JettaCar();
	}
}
