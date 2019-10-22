package com.demo.factorymode.reflexMethod;

import com.demo.factorymode.AudiCar;
import com.demo.factorymode.JettaCar;
import com.demo.factorymode.PassatCar;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 21:25
 * 功能：通过反射的工厂方法模式创建汽车
 */
public class ReflexCreateCar {
	public static void main(String[] args) {
		ReflexFactory jettaReflexFactory = new RealReflexFactory();
		jettaReflexFactory.createCar(JettaCar.class);
		ReflexFactory passtaReflexFactory = new RealReflexFactory();
		passtaReflexFactory.createCar(PassatCar.class);
		ReflexFactory audiReflexFactory = new RealReflexFactory();
		audiReflexFactory.createCar(AudiCar.class);
	}
}
