package com.demo.singletonmode.layzeMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 16:26
 * 功能：懒汉式（线程安全，同步代码块--但是不能真正实现线程安全）
 */
public class Singleton5 {
	private Singleton5() {
	}

	private static Singleton5 instance;

	public Singleton5 getInstance() {
		if (instance == null) {
			synchronized (Singleton5.class) {
				instance = new Singleton5();
			}
		}
		return instance;
	}
}
