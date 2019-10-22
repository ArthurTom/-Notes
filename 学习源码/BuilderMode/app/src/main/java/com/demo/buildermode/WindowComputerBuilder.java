package com.demo.buildermode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:26
 * 功能：window类型的电脑--继承ComputerBuilder实现组装电脑的方法
 */
public class WindowComputerBuilder extends ComputerBuilder {

	private Computer computer;

	public WindowComputerBuilder() {
		computer = new Computer();
	}

	@Override
	public void buildHost() {
		computer.setHost("组装个联想主机");
	}

	@Override
	public void buildDisplay() {
		computer.setDisplay("组装个联想显示器");
	}

	@Override
	public void buildOS() {
		computer.setOS("组装个联想的操作系统");
	}

	@Override
	public Computer build() {
		return computer;
	}
}
