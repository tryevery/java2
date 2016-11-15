package com.test14;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * ªÊ÷∆Õº∆¨
 * @author lcj
 *
 */
public class Example14_5 {
	public static void main(String[] args) {
		JFrame win = new JFrame();
		Toolkit tool = win.getToolkit();
		Image image = tool.getImage("image/2.jpg");
		win.setIconImage(image);
		win.add(new ImageCanvas());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
	}
}

class ImageCanvas extends Canvas {
	Toolkit tool;
	Image image;
	public ImageCanvas() {
		setSize(200, 200);
		tool = getToolkit();
		image = tool.getImage("image/1.jpg");
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 10, 10, image.getWidth(this), image.getHeight(this), this);
	}
}
