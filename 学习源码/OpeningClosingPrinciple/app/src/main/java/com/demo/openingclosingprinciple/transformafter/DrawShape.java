package com.demo.openingclosingprinciple.transformafter;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/17 14:55
 * 功能：
 */
public class DrawShape {

	public void draw(ShapeType shapeType) {
		shapeType.draw();// 这里不再判断，而是使用抽象类的子类的重写方法
	}
}
