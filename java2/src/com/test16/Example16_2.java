package com.test16;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * 使用html向javaApplet传递两个整数
 * @author lcj
 *
 */
public class Example16_2 extends Applet{
	int x,y,sum;
	@Override
	public void init() {
		String s1 = getParameter("girl");
		String s2 = getParameter("boy");
		x = Integer.parseInt(s1);
		y = Integer.parseInt(s2);
		sum = x+y;
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("sum="+sum, 90, 120);
	}
	
}
