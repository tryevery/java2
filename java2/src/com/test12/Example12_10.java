package com.test12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * GUI�߳�
 * ѵ���û�Ѱ�Ҽ�������ĸ������
 * @author lcj
 *
 */
public class Example12_10 {
	public static void main(String[] args) {
		WindowTyped win = new WindowTyped();
		win.setTitle("����ĸ��Ϸ");
		win.setSleepTime(3000);
	}
}

class WindowTyped extends JFrame implements ActionListener,Runnable{
	JTextField inputLetter;
	Thread giveLetter; //���������ĸ
	JLabel showLetter,showScore;
	int sleepTime,score;
	Color c;
	public WindowTyped() {
		setLayout(new FlowLayout());
		giveLetter = new Thread(this);
		inputLetter = new JTextField(6);
		showLetter = new JLabel(" ",JLabel.CENTER);
		showScore = new JLabel("����:");
		showLetter.setFont(new Font("Arial",Font.BOLD,22));
		add(new JLabel("��ʾ��ĸ:"));
		add(showLetter);
		add(new JLabel("��������ʾ����ĸ(�س�)"));
		add(inputLetter);
		add(showScore);
		inputLetter.addActionListener(this);
		setBounds(100, 100, 400, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giveLetter.start(); //��AWT-Windows�߳�������giveLetter�߳�
	}
	
	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}
	@Override
	public void run() {
		char c = 'a';
		while(true){
			showLetter.setText(""+c+" ");
			validate();
			c = (char) (c+1);
			if(c>'z') c = 'a';
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = showLetter.getText().trim();
		String letter = inputLetter.getText().trim();
		if(s.equals(letter)){
			score++;
			showScore.setText("�÷�"+score);
			inputLetter.setText(null);
			validate();
			giveLetter.interrupt(); //�������ߵĽ���,�Ա�ӿ����ĸ���ٶ�
		}
		
	}
	
}