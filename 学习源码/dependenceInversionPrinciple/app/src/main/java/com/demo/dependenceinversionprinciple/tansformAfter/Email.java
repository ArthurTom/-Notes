package com.demo.dependenceinversionprinciple.tansformAfter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/16 11:51
 * 功能：邮箱工具类
 */
public class Email implements ChartEach {
	@Override
	public String getInfo() {
		return "电子邮箱：hello 依赖倒转原则";
	}
}
