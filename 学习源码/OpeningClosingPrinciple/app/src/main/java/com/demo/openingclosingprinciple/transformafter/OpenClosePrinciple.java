package com.demo.openingclosingprinciple.transformafter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/17 14:42
 * 功能：开闭原则的入口
 */
public class OpenClosePrinciple {
	public static void main(String[] args) {
		DrawShape mDrawShape = new DrawShape();
		mDrawShape.draw(new DrawCircle());
		mDrawShape.draw(new DrawRect());
	}
}
