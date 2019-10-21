package com.demo.simplefactorymode.TransformAfter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 11:22
 * 功能：制作披萨的商店
 */
public class PizzaStore {
	// 1. 构造器中调用制作Pizza的步骤方法
	public PizzaStore() {
		PizzaCooker();
	}

	// 2.制作Pizza的步骤方法
	public void PizzaCooker() {
		Pizza mPizza = null;
		String PizzaType; // 披萨种类
		do {
			PizzaType = getPizzaType();
			mPizza = SimpleFactory.createPizza(PizzaType); // 调用工厂的方法创建对象
			mPizza.setName(PizzaType);
			if (mPizza != null) {
				mPizza.prepare();
				mPizza.bake();
				mPizza.cut();
				mPizza.box();
			}else {
				System.out.println("订购的Pizza失败");
				break;
			}
		} while (true);

	}

	//3.获取用户的输入的Pizza的种类
	public String getPizzaType() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("客户输入Pizza的类型：");
		String str = null;
		try {
			str = bufferedReader.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}
}
