package com.test9;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * ʹ�����������������������ڹر��¼�
 * @author lcj
 *
 */
public class Example9_13 {
	public static void main(String[] args) {
		MyFrame farm = new MyFrame("����");
	}
}

class MyFrame extends JFrame {
	Boy police ;
	public MyFrame(String s) {
		super(s);
		police = new Boy();
		setBounds(100, 100, 200, 300);
		setVisible(true);
		addWindowListener(police); //�򴰿�ע�������
		validate();
	}
}

class Boy extends WindowAdapter { //�̳���WindowAdapter������д��Ҫ�ķ���
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}