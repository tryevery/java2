package com.test14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example14_2 {
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.setSize(400, 400);
		win.add(new MyCanvs1());
		win.setVisible(true);
	}
}

class MyCanvs1 extends JPanel {
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		String s = "Hello";
		Ellipse2D ellipse = new Ellipse2D.Double(30,30,80,30);
		AffineTransform trans = new AffineTransform(); //����ƽ��,��ת,���ŵĶ���
		for(int i=1;i<=24;i++){
			trans.rotate(15*Math.PI/180,80,45); //��ת
			g2d.setTransform(trans);  //�ѱ任��������ƹ���
			g2d.setColor(Color.RED);
			g2d.fill(ellipse); //���ͼ��
			g2d.draw(ellipse); //����ת�����Բ
		}
		
		for(int i=1;i<=12;i++){
			trans.rotate(30*Math.PI/180, 60, 160);
			g2d.setTransform(trans);
			g2d.setColor(Color.YELLOW);
			g2d.drawString(s,60,160);  //����ת����ַ���
		}
	}
}
