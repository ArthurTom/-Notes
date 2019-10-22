package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:08
 * 功能：上海汽车制造厂
 */
public class ShaiFactory extends AbstractFactory {
	@Override
	public GasCar createGasCar() {
		return new ShangHaiGasCar();
	}

	@Override
	public ElectricCar createElectricCar() {
		return new ShangHaiElectricCar();
	}
}
