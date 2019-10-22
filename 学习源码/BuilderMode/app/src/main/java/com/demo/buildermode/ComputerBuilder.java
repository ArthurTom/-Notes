package com.demo.buildermode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:16
 * 功能：抽象类--声明组装电脑的一些方法，由子类实现
 */
public abstract class ComputerBuilder {
	public abstract void buildHost(); // 组装主机

	public abstract void buildDisplay();// 组装显示器

	public abstract void buildOS();// 安装系统

	public abstract Computer build();
}
