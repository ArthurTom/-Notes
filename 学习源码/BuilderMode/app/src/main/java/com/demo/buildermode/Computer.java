package com.demo.buildermode;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/22 19:24
 * 功能：产品类--电脑一些组成属性
 */
public class Computer {
	private String host; // 主机
	private String display; // 显示器
	private String OS; // 系统

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String OS) {
		this.OS = OS;
	}

	@Override
	public String toString() {
		return "Computer{" +
				"host='" + host + '\'' +
				", display='" + display + '\'' +
				", OS='" + OS + '\'' +
				'}';
	}
}
