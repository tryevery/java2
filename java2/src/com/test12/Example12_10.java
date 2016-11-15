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
 * GUI线程
 * 训练用户寻找键盘上字母的能力
 * @author lcj
 *
 */
public class Example12_10 {
	public static void main(String[] args) {
		WindowTyped win = new WindowTyped();
		win.setTitle("大字母游戏");
		win.setSleepTime(3000);
	}
}

class WindowTyped extends JFrame implements ActionListener,Runnable{
	JTextField inputLetter;
	Thread giveLetter; //负责给出字母
	JLabel showLetter,showScore;
	int sleepTime,score;
	Color c;
	public WindowTyped() {
		setLayout(new FlowLayout());
		giveLetter = new Thread(this);
		inputLetter = new JTextField(6);
		showLetter = new JLabel(" ",JLabel.CENTER);
		showScore = new JLabel("分数:");
		showLetter.setFont(new Font("Arial",Font.BOLD,22));
		add(new JLabel("显示字母:"));
		add(showLetter);
		add(new JLabel("输入所显示的字母(回车)"));
		add(inputLetter);
		add(showScore);
		inputLetter.addActionListener(this);
		setBounds(100, 100, 400, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		giveLetter.start(); //在AWT-Windows线程中启动giveLetter线程
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
			showScore.setText("得分"+score);
			inputLetter.setText(null);
			validate();
			giveLetter.interrupt(); //吵醒休眠的进程,以便加快出字母发速度
		}
		
	}
	
}