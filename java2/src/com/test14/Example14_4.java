package com.test14;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 绘制钟表
 * 下面利用多线程技术绘制一个钟表,限时本机的时间
 * 如果一个圆的圆心是(0,0),那么对于原上给定的一点(y,x),
 * 该点按顺时针方向旋转α角度后的坐标(m,n)由下列公式计算
 * m = xcos(α)-ysin(α)
 * n = ycos(α)+xsin(α)
 * @author lcj
 *
 */
public class Example14_4 {
	public static void main(String[] args) {
		JFrame win = new JFrame();
		win.setSize(400, 400);
		
		win.add(new Clock());
		win.setVisible(true);
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}



class Clock extends Canvas implements ActionListener {
	Date date;
	Timer secondTime;
	int hour,munite,second;
	Line2D secondLine,muniteLine,hourLine;
	int a,b,c;
	double pointSX[] = new double[60],
			pointSY[] = new double[60],
			pointMX[] = new double[60],
			pointMY[] = new double[60],
			pointHX[] = new double[60],
			pointHY[] = new double[60];
	
	public String getDate(){  //获取当前的时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		
		return format.format(date);
	}
	
	public Clock(){
		secondTime = new Timer(1000, this);
		pointSX[0] = 0;
		pointSY[0] = -100;
		pointMX[0] = 0;
		pointMY[0] = -90;
		pointHX[0] = 0;
		pointHY[0] = -70;
		double angle = 6*Math.PI/180;
		for(int i=0;i<59;i++){
			pointSX[i+1] = pointSX[i]*Math.cos(angle)-Math.sin(angle)*pointSY[i];
			pointSY[i+1] = pointSY[i]*Math.cos(angle)+Math.sin(angle)*pointSX[i];
			pointMX[i+1] = pointMX[i]*Math.cos(angle)-Math.sin(angle)*pointMY[i];
			pointMY[i+1] = pointMY[i]*Math.cos(angle)+Math.sin(angle)*pointMX[i];
			pointHX[i+1] = pointHX[i]*Math.cos(angle)-Math.sin(angle)*pointHY[i];
			pointHY[i+1] = pointHY[i]*Math.cos(angle)+Math.sin(angle)*pointHX[i];
		}
		
		for(int i=0;i<60;i++){
			pointSX[i] = pointSX[i]+190;
			pointSY[i] = pointSY[i]+180;
			pointMX[i] = pointMX[i]+190;
			pointMY[i] = pointMY[i]+180;
			pointHX[i] = pointHX[i]+190;
			pointHY[i] = pointHY[i]+180;
		}
		
		secondLine = new Line2D.Double(0, 0, 0, 0);
		muniteLine = new Line2D.Double(0, 0, 0, 0);
		hourLine = new Line2D.Double(0, 0, 0, 0);
		secondTime.start();
	}
	public void paint(Graphics g){
		for(int i=0;i<60;i++){
			int m = (int) pointSX[i];
			int n = (int) pointSY[i];
			if(i%5==0){
				g.setColor(Color.red);
				g.fillOval(m-4, n-4, 8, 8);
			}else{
				g.setColor(Color.blue);
				g.fillOval(m-2, n-2, 4, 4);
			}
		}
		
		g.fillOval(185, 175, 10, 10);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		g2d.draw(secondLine);
		BasicStroke bs = new BasicStroke(3f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2d.setStroke(bs);
		g2d.setColor(Color.black);
		g2d.draw(muniteLine);
		bs = new BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
		g2d.setStroke(bs);
		g2d.setColor(Color.black);
		g2d.draw(hourLine);
		g2d.drawString(getDate(), 120, 50);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==secondTime){
			date = new Date();
			String s = date.toString();
			hour = Integer.parseInt(s.substring(11,13));
			munite = Integer.parseInt(s.substring(14,16));
			second = Integer.parseInt(s.substring(17,19));
			int h =hour%12;
			a = second;
			b = munite;
			c = h*5+munite/12;
			secondLine.setLine(190, 180, (int)pointSX[a], (int)pointSY[a]);
			muniteLine.setLine(190, 180, (int)pointMX[b], (int)pointMY[b]);
			hourLine.setLine(190, 180, (int)pointHX[c], (int)pointHY[c]);
			repaint();
		}
	}
	
}