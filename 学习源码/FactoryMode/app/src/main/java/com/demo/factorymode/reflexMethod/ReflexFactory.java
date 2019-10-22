package com.demo.factorymode.reflexMethod;

import com.demo.factorymode.Car;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 21:17
 * 功能：带反射的抽象工厂
 */
public abstract class ReflexFactory {
	public abstract <T extends Car> T createCar(Class<T> clazz);
}
