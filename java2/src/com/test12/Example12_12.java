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
 * ��ʱ���߳� 
 * java.swing timer��
 * ʵ�ַ�ʽ:������ʼ��ť������ʱ��,��ʱ����ʾ���ı�����,
 * ͬʱ�ƶ��ı����������е�λ��,������ͣ��ťֹͣ��ʱ,��������������ʱ��
 * @author lcj
 *
 */
public class Example12_12 {
	public static void main(String[] args) {
		WindowTimer timer = new WindowTimer();
		timer.setTitle("��ʱ��");
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
		bStart = new JButton("��ʼ");
		bStop = new JButton("��ͣ");
		bContinue = new JButton("����");
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
			text.setText("ʱ��:"+m.format(date));
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
