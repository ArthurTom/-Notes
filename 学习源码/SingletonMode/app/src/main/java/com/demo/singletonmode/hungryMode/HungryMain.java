package com.demo.singletonmode.hungryMode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/20 15:07
 * 功能：
 */
public class HungryMain {
	public static void main(String[] arg) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println("单例模式获取的实例化对象是同一个" + (singleton1.hashCode() == singleton2.hashCode() ? "相同" : "不同"));
	}
}
