package com.demo.abstractfactory;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 15:00
 * 功能：抽象工厂类
 */
public abstract class AbstractFactory {
	public abstract GasCar createGasCar(); // 创建燃油汽车抽象类
	public abstract ElectricCar createElectricCar(); // 创建电动汽车的抽象类
}
