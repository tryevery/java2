package com.test9;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 使用匿名类实例或者窗口做监视器实现一个猜数字的小游戏
 * @author lcj
 *
 */
public class Example9_14 {
	public static void main(String[] args) {
		WindowButton win = new WindowButton("猜数字");
	}
}


class WindowButton extends JFrame  implements ActionListener{
	int number;
	JLabel hintLabel;
	JTextField inputGess;
	JButton buttonGetNumber,buttonEnter;
	public WindowButton(String s) {
		super(s);
		addWindowListener(new WindowAdapter() { //使用匿名内部类做监视器
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
		setLayout(new FlowLayout());
		buttonGetNumber = new JButton("得到一个随机数");
		add(buttonGetNumber);
		hintLabel = new JLabel("输入你的猜测：",JLabel.CENTER);
		hintLabel.setBackground(Color.CYAN);
		inputGess = new JTextField("0", 10);
		add(hintLabel);
		add(inputGess);
		buttonEnter = new JButton("确定");
		add(buttonEnter);
		buttonEnter.addActionListener(this);
		buttonGetNumber.addActionListener(this);
		setBounds(100, 100, 150, 150);
		setVisible(true);
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) { //动作监听事件
		if(e.getSource() == buttonGetNumber){
			number = (int)(Math.random()*100)+1;
			hintLabel.setText("输入你的猜测：");
		}else if(e.getSource() == buttonEnter){
			int guess = 0;
			try {
				guess = Integer.parseInt(inputGess.getText());
				if(guess==number){
					hintLabel.setText("猜对了");
				}else if(guess>number){
					hintLabel.setText("猜大了");
					inputGess.setText(null);
				}else if(guess<number){
					hintLabel.setText("猜小了");
					inputGess.setText(null);
				}
			} catch (NumberFormatException e2) {
				hintLabel.setText("请输入数字字符");
			}
		}
	}
}