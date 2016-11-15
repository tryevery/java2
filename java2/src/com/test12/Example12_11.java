package com.test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ����start ��ť�߳̿�ʼ����,ÿ��һ����ʾ��ǰ��ʱ��
 * @author lcj
 *
 */
public class Example12_11 {
	public static void main(String[] args) {
		new Win();
	}
}

class Win extends JFrame implements Runnable,ActionListener {
	Thread showTime = null;
	JTextArea text = null;
	JButton buttonStart = new JButton("start"),
			buttonStop = new JButton("stop");
	boolean die;
	SimpleDateFormat m = new SimpleDateFormat("HH:mm:ss");
	Date date;
	public Win() {
		showTime = new Thread(this);
		text = new JTextArea();
		add(new JScrollPane(text),BorderLayout.CENTER);
		JPanel p = new JPanel();
		p.add(buttonStart);
		p.add(buttonStop);
		buttonStart.addActionListener(this);
		buttonStop.addActionListener(this);
		add(p,BorderLayout.NORTH);
		setBounds(100, 100, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonStart){
			if(!(showTime.isAlive())){
				showTime = new Thread(this);
				die = false;
			}
			try {
				showTime.start();	//��AWT-EventQueuce �߳�������showTime�߳�			
			} catch (Exception e2) {
				text.setText("�߳�û�н���run����ǰ,��Ҫ�ڵ���start����");
			}
		}else if(e.getSource()==buttonStop){
			die = true;
		}
	}

	@Override
	public void run() {
		while(true){
			date = new Date();
			text.append("\n"+m.format(date));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if(die==true){
				return;
			}
		}
		
	}
	
}
