package com.demo.buildermode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:32
 * 功能：统一组装电脑
 */
public class Director {
	private ComputerBuilder builder;

	public Director(ComputerBuilder builder) {
		this.builder = builder;
	}

	/**
	 * 组装电脑的步骤
	 */
	public Computer constract() {
		builder.buildHost();
		builder.buildDisplay();
		builder.buildOS();
		return builder.build();
	}
}
