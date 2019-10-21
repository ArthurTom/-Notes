package com.demo.simplefactorymode.TransformBefore;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 11:21
 * 功能：B种Pizza
 */
public class BPizza extends Pizza {
	@Override
	void prepare() {
		System.out.println("给B类pizza制作准备材料");
	}
}
