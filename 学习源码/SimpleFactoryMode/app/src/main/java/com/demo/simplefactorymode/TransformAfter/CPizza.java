package com.demo.simplefactorymode.TransformAfter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 16:29
 * 功能：
 */
public class CPizza extends Pizza {
	@Override
	void prepare() {
		System.out.println("CPizza");
	}
}
