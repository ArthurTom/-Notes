package com.demo.dependenceinversionprinciple.tansformAfter;

import com.demo.dependenceinversionprinciple.transformbefore.Email;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/16 11:51
 * 功能：人
 */
public class Person {
	public void received(ChartEach chartEach) { // 使用接口传递
		System.out.println(chartEach.getInfo());
	}
}
