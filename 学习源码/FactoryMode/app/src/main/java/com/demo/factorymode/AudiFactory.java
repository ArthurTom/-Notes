package com.demo.factorymode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 21:00
 * 功能：奥迪工厂
 */
public class AudiFactory extends Factory {
	@Override
	public Car CreateCar() {
		return new AudiCar();
	}
}
