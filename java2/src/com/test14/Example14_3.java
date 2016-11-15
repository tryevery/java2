package com.test14;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 图形的布尔运算
 * @author lcj
 *
 */
public class Example14_3 {
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.setSize(400, 400);
		win.add(new MyCavns2());
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyCavns2 extends JPanel {
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		Ellipse2D ellipse = new Ellipse2D.Double(0, 2, 80, 80);
		Rectangle2D rect = new Rectangle2D.Double(40, 2, 80, 80);
		Area a1 = new Area(ellipse);
		Area a2 = new Area(rect);
		a1.intersect(a2);  //与
		g2d.fill(a1);
		ellipse.setFrame(130, 2, 80, 80);
		rect.setFrame(170, 2, 80, 80);
		a1 = new Area(ellipse);
		a2 = new Area(rect);
		a1.add(a2);     //或
		g2d.draw(a1);
		ellipse.setFrame(0, 90, 80, 80);
		rect.setFrame(40, 90, 80, 80);
		a1 = new Area(ellipse);
		a2 = new Area(rect);
		a1.subtract(a2);  //差
		g2d.draw(a1);
		ellipse.setFrame(130, 90, 80, 80);
		rect.setFrame(170, 90, 80, 80);
		a1 = new Area(ellipse);
		a2 = new Area(rect);
		a1.exclusiveOr(a2);  //异或
		g2d.fill(a1);
		
		
		
	}
}
