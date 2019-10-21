package com.demo.simplefactorymode.TransformAfter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/21 11:18
 * 功能：披萨普通的写法
 */
public abstract class Pizza {
	private String name;

	abstract void prepare(); // 根据材料不同，制作不同的Pizza

	public void bake() { // 烘培
		System.out.println(name+"准备烘焙");

	}

	public void cut() { // 切块
    System.out.println(name+"准备切块");
	}

	public void box() { // 装盒
     System.out.println(name+"准备装盒子");
	}

	public void setName(String name) {
		this.name = name;
	}
}
