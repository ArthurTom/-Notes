package com.demo.singletonmode.layzeMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 17:14
 * 功能：双重检查
 */
public class Singleton6 {
	//
	private static volatile Singleton6 instance;

	private Singleton6() {
	}

	public Singleton6 getInstance() {
		if (instance == null) {
			synchronized (Singleton6.class) {
				if (instance == null) {
					instance = new Singleton6();
				}
			}
		}
		return instance;
	}
}
