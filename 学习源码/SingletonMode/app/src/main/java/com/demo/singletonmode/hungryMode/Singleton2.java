package com.demo.singletonmode.hungryMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 15:39
 * 功能：饿汉式（静态变量的另一种写法）
 */
public class Singleton2 {
	private static Singleton2 instance;
	private Singleton2() {}
	static {
		instance = new Singleton2();
	}
	public static Singleton2 getInstance() {
		return instance;
	}
}
