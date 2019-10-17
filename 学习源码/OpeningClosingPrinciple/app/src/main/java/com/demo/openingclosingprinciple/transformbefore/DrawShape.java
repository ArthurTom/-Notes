package com.demo.openingclosingprinciple.transformbefore;

/**
 * 作者:zwk
 * 联系方式：497981239@qq.com
 * 时间：on 2019/10/17 14:55
 * 功能：
 */
public class DrawShape {

	public void draw(ShapeType shapeType) {
		if (shapeType.shapeTypeNum == 1)
			System.out.println("绘制圆形");
		else if (shapeType.shapeTypeNum == 2)
			System.out.println("绘制矩形"); // 如果我要加入一个绘制其他的图形，这里需要新增一个判断，然后要新加一个类
	}
}
