package com.test9;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;


/**
 * ��ɫ�Ի���ĳ���
 * @author lcj
 *
 */
public class Example9_19 {
	public static void main(String[] args) {
		WindowColor co = new WindowColor();
		co.setTitle("��ɫ�Ի���");
		co.setBounds(80,90,200,300);
	}
}

class WindowColor extends JFrame implements ActionListener {
	JButton button;
	public WindowColor() {
		button = new JButton("����ɫ�Ի���");
		button.addActionListener(this);
		setLayout(new FlowLayout());
		add(button);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Color newColor = JColorChooser.showDialog(this, "��ɫ��", getContentPane().getBackground());
		if(newColor != null){
			getContentPane().setBackground(newColor);
		}
		
	}
	
}



	