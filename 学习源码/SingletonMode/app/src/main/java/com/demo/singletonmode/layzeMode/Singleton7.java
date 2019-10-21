package com.demo.singletonmode.layzeMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 19:23
 * 功能：静态内部类
 */
public class Singleton7 {
	//1.私有的构造器
	private Singleton7() {
	}

	//2 静态内部类，在静态内部类中写一个静态属性
	private static class SingletonInstance {
		private static final Singleton7 instance = new Singleton7();
	}

	// 写一个静态的公有方法，直接返回SingletonInstance.instance
	public static Singleton7 getInstance() {
		return SingletonInstance.instance;
	}

}
