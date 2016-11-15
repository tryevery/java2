package com.test14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 绘制太极形和四边形
 * @author lcj
 *
 */
public class Example14_1 {
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.setSize(400, 400);
		win.add(new MyCanvas());
		win.setVisible(true);
	}
}

class MyCanvas extends JPanel {
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Arc2D arc = new Arc2D.Double(0, 0, 100, 100, -90, -180, Arc2D.PIE);//绘制圆弧
		g2d.setColor(Color.black);
		g2d.fill(arc);
		g2d.setColor(Color.white);
		arc.setArc(0, 0, 100, 100, -90, 180, Arc2D.PIE);//绘制圆弧
		g2d.fill(arc);
		arc.setArc(25, 0, 50, 50, -90, -180, Arc2D.PIE);//绘制圆弧
		g2d.fill(arc);
		g2d.setColor(Color.red);
		Ellipse2D ellipse = new Ellipse2D.Double(40,15,20,20);//绘制椭圆
		g2d.fill(ellipse);
		arc.setArc(25, 50, 50, 50, 90, -180, Arc2D.PIE);//绘制圆弧
		g2d.fill(arc);
		g2d.setColor(Color.WHITE);
		ellipse.setFrame(40, 65, 20, 20);
		g2d.fill(ellipse);
		g.setColor(Color.black);
		Polygon polygon = new Polygon(); //绘制多边形
		polygon.addPoint(150, 10);
		polygon.addPoint(100, 90);
		polygon.addPoint(210, 90);
		polygon.addPoint(260, 10);
		g2d.draw(polygon);
	}
}
