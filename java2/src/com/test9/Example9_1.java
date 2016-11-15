package com.test9;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class Example9_1 extends JFrame{
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		Container con = jf.getContentPane();
		con.setBackground(Color.green); //设置窗口的北京颜色
		jf.setTitle("这是我的第一个窗口程序");
		jf.setBounds(200,200,300,400);//设置窗口的起始位置以及窗口的大小
//		jf.setSize(300, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//当点击关闭按钮是执行怎样的操作
		jf.setVisible(true);
	}
}
