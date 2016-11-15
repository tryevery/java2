package com.test14;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.lang.model.element.QualifiedNameable;

import com.sun.image.codec.jpeg.*;
/**
 * 将绘制的图像保存为jpg图像文件
 * @author lcj
 *
 */
public class Example14_7 {
	public static void main(String[] args) {
		try {
			@SuppressWarnings("restriction")
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(new FileOutputStream("my.jpg"));
			Paint myJPG = new Paint();
			encoder.encode(myJPG.getImage());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Paint extends Canvas {
	BufferedImage image;
	Graphics2D g2d;
	BasicStroke bs;
	public Paint() {
		image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		g2d = image.createGraphics();
		Rectangle2D rect = new Rectangle2D.Double(0, 0, 300, 300);
		g2d.setColor(Color.CYAN);
		g2d.fill(rect);
		QuadCurve2D quad = new QuadCurve2D.Double(2, 10, 51, 70, 100, 50);
		bs = new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
		g2d.setStroke(bs);
		g2d.setColor(Color.black);
		g2d.draw(quad);
		Ellipse2D ellipse = new Ellipse2D.Double(2, 40, 100, 50);
		g2d.draw(ellipse);
		g2d.drawString("我绘制的图像保存的jpg图像", 100, 45);
	}
	public BufferedImage getImage() {
		return image;
	}
	
}
