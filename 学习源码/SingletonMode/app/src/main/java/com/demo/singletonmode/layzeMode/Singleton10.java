package com.demo.singletonmode.layzeMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 19:34
 * 功能：枚举
 */
public class Singleton10 {
	public static void main(String[] args) {
		Singleton singleton = Singleton.INSTANCE;
		singleton.printMsg();
		Singleton singleton1 = Singleton.INSTANCE;
		System.out.println("singleton和singleton1是一个对象" + (singleton.hashCode() == singleton1.hashCode()));
	}
	enum Singleton {
		INSTANCE;
		public void printMsg() {
			System.out.println("枚举单例模式，打印");
		}
	}
}
