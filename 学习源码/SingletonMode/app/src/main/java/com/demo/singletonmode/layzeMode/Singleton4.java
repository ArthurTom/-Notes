package com.demo.singletonmode.layzeMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 16:03
 * 功能：懒汉式，线程安全，同步方法
 */
public class Singleton4 {
	//1.构造器私有化
	private Singleton4() {
	}

	private static Singleton4 instace;
    // 2. 加入同步代码，解决线程不安全的问题
	public static synchronized Singleton4 getInstance() {
		if (instace == null) {
			instace = new Singleton4();
		}
		return instace;
	}
}
