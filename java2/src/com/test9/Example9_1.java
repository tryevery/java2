package com.test9;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Example9_1 extends JFrame{
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Container con = jf.getContentPane();
		con.setBackground(Color.green); //���ô��ڵı�����ɫ
		jf.setTitle("�����ҵĵ�һ�����ڳ���");
		jf.setBounds(200,200,300,400);//���ô��ڵ���ʼλ���Լ����ڵĴ�С
//		jf.setSize(300, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//������رհ�ť��ִ�������Ĳ���
		jf.setVisible(true);
	}
}
