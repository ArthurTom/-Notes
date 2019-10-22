package com.demo.buildermode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:37
 * 功能：程序的入口
 */
public class StartMain {
	public static void main(String[] args) {
		ComputerBuilder builder = new WindowComputerBuilder();
		Director director = new Director(builder);
		Computer computer = director.constract();
		System.out.println("打印初始化的computer的信息:" + computer.toString());
	}
}
