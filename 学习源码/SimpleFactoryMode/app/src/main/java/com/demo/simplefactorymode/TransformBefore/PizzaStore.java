package com.demo.simplefactorymode.TransformBefore;

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

	public PizzaStore(){

	}

//	public PizzaStore() {
//		Pizza mPizza = null;
//		String PizzaType; // 披萨种类
//		do {
//			PizzaType = getPizzaType();
//			if (PizzaType.equals("APizza")) {
//				mPizza = new APizza();
//				mPizza.setName("APizza");
//			} else if (PizzaType.equals("BPizza")) {
//				mPizza = new BPizza();
//				mPizza.setName("BPizza");
//			} else {
//				break;
//			}
//			mPizza.prepare();
//			mPizza.bake();
//			mPizza.cut();
//			mPizza.box();
//		} while (true);
//
//	}
//
//	public String getPizzaType() { // 获取披萨的种类
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("客户输入Pizza的类型：");
//		String str = null;
//		try {
//			str = bufferedReader.readLine();
//			return str;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return e.getMessage();
//		}
//
//	}
}
