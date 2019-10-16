package com.demo.dependenceinversionprinciple.transformbefore;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/16 11:57
 * 功能：java中的main入口
 */
public class DependenceInversion {
	public static void main(String[] args) {
		Person person = new Person();
		person.received(new Email());
	}
}
