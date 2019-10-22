package com.demo.factorymode.reflexMethod;

import com.demo.factorymode.Car;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 21:19
 * 功能：带反射的工厂方法
 */
public class RealReflexFactory extends ReflexFactory {
	@Override
	public <T extends Car> T createCar(Class<T> clazz) {
		Car mCar = null;
		try {
			mCar = (Car) Class.forName(clazz.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) mCar;
	}
}
