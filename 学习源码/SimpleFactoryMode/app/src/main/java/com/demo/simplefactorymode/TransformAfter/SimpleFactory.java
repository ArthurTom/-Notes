package com.demo.simplefactorymode.TransformAfter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 16:21
 * 功能：简单工厂模式--静态工厂模式
 */
public class SimpleFactory {

	// 1. 创建对象方法：根据用户的输入类型，来创建对象
	public static Pizza createPizza(String PizzaType) {
		System.out.println("开始使用简单工厂模式创建对应的对象");
		Pizza mPizza = null;
		if (PizzaType.equals("APizza")) {
			mPizza = new APizza();
		} else if (PizzaType.equals("BPizza")) {
			mPizza = new BPizza();
		} else if (PizzaType.equals("CPizza")) {
			mPizza = new CPizza();
		} else {
			System.out.println("输入的类型没有，请重新输入");
		}
		return mPizza;
	}
}
