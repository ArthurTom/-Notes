package com.demo.singletonmode.layzeMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 15:51
 * 功能：懒汉式(线程不安全)
 */
public class Singleton3 {
	// 1. 私有化的构造器
	private Singleton3() {
	}

	private static Singleton3 singleton3;

	// 提供一个静态的公有方法，当使用该方法时，才去创建instance3
	public static Singleton3 getInstance() {
		if (singleton3 == null) {
			singleton3 = new Singleton3();
		}
		return singleton3;
	}
}
