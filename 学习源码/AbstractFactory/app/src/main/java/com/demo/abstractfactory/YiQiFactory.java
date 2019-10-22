package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:08
 * 功能：一汽汽车制造厂
 */
public class YiQiFactory extends AbstractFactory {
	@Override
	public GasCar createGasCar() {
		return new YiQiGasCar();
	}

	@Override
	public ElectricCar createElectricCar() {
		return new YiQiElectricCar();
	}
}
