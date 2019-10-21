package com.demo.simplefactorymode.TransformAfter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 11:21
 * 功能：A种披萨
 */
public class APizza extends Pizza {
	@Override
	void prepare() {
     System.out.println("A类披萨准备所需的材料");
	}
}
