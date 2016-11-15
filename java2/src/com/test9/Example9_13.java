package com.test9;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 使用适配器做监视器，处理窗口关闭事件
 * @author lcj
 *
 */
public class Example9_13 {
	public static void main(String[] args) {
		MyFrame farm = new MyFrame("窗口");
	}
}

class MyFrame extends JFrame {
	Boy police ;
	public MyFrame(String s) {
		super(s);
		police = new Boy();
		setBounds(100, 100, 200, 300);
		setVisible(true);
		addWindowListener(police); //向窗口注册监视器
		validate();
	}
}

class Boy extends WindowAdapter { //继承了WindowAdapter可以重写需要的方法
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}