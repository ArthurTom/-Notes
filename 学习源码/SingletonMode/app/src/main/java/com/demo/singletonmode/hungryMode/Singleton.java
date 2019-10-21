package com.demo.singletonmode.hungryMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 15:04
 * 功能：饿汉式静态变量
 */
public class Singleton {
	// 1.构造函数私有化
	private Singleton() {
	}
    // 2.本类内部创建对象实例
	private final static Singleton instance = new Singleton();
    //3. 提供一个公共的静态方法，返回实例对象
	public static Singleton getInstance() {
		return instance;
	}
}
