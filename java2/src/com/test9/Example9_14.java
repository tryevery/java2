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
 * ʹ��������ʵ�����ߴ�����������ʵ��һ�������ֵ�С��Ϸ
 * @author lcj
 *
 */
public class Example9_14 {
	public static void main(String[] args) {
		WindowButton win = new WindowButton("������");
	}
}


class WindowButton extends JFrame  implements ActionListener{
	int number;
	JLabel hintLabel;
	JTextField inputGess;
	JButton buttonGetNumber,buttonEnter;
	public WindowButton(String s) {
		super(s);
		addWindowListener(new WindowAdapter() { //ʹ�������ڲ�����������
			public void windowClosing(WindowEvent e){
				dispose();
			}
		});
		setLayout(new FlowLayout());
		buttonGetNumber = new JButton("�õ�һ�������");
		add(buttonGetNumber);
		hintLabel = new JLabel("������Ĳ²⣺",JLabel.CENTER);
		hintLabel.setBackground(Color.CYAN);
		inputGess = new JTextField("0", 10);
		add(hintLabel);
		add(inputGess);
		buttonEnter = new JButton("ȷ��");
		add(buttonEnter);
		buttonEnter.addActionListener(this);
		buttonGetNumber.addActionListener(this);
		setBounds(100, 100, 150, 150);
		setVisible(true);
		validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) { //���������¼�
		if(e.getSource() == buttonGetNumber){
			number = (int)(Math.random()*100)+1;
			hintLabel.setText("������Ĳ²⣺");
		}else if(e.getSource() == buttonEnter){
			int guess = 0;
			try {
				guess = Integer.parseInt(inputGess.getText());
				if(guess==number){
					hintLabel.setText("�¶���");
				}else if(guess>number){
					hintLabel.setText("�´���");
					inputGess.setText(null);
				}else if(guess<number){
					hintLabel.setText("��С��");
					inputGess.setText(null);
				}
			} catch (NumberFormatException e2) {
				hintLabel.setText("�����������ַ�");
			}
		}
	}
}