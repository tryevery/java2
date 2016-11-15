package com.test12;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * 计时器线程 
 * java.swing timer类
 * 实现方式:单击开始按钮启动计时器,将时间显示在文本框中,
 * 同时移动文本框在容器中的位置,单击暂停按钮停止计时,单击继续重启计时器
 * @author lcj
 *
 */
public class Example12_12 {
	public static void main(String[] args) {
		WindowTimer timer = new WindowTimer();
		timer.setTitle("计时器");
	}
}

class WindowTimer extends JFrame implements ActionListener {
	JTextField text;
	JButton bStart,bStop,bContinue;
	Timer timer;
	SimpleDateFormat m;
	int n = 0,start = 1;
	public WindowTimer() {
		timer = new Timer(1000, this);
		m = new SimpleDateFormat("HH:mm:ss");
		text = new JTextField(10);
		bStart = new JButton("开始");
		bStop = new JButton("暂停");
		bContinue = new JButton("继续");
		bStart.addActionListener(this);
		bStop.addActionListener(this);
		bContinue.addActionListener(this);
		setLayout(new FlowLayout());
		add(bStart);
		add(bStop);
		add(bContinue);
		add(text);
		setSize(500, 500);
		validate();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==timer){
			Date date = new Date();
			text.setText("时间:"+m.format(date));
			int x = text.getBounds().x;
			int y = text.getBounds().y;
			y += 2;
			x -= 2;
			text.setLocation(x, y);
		}
		else if(e.getSource()==bStart){
			timer.start();
		}
		else if(e.getSource()==bStop){
			timer.stop();
		}
		else if(e.getSource()==bContinue){
			timer.restart();
		}
	}
	
}
