package com.test9;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



/**
 * �Զ���Ի���
 * @author lcj
 *
 */
public class Example9_20 {
	public static void main(String[] args) {
		MyWindow win = new MyWindow();
		win.setTitle("���Զ���Ի���Ĵ���");
		win.setSize(200, 300);
	}
}

class MyWindow extends JFrame implements ActionListener {
	JButton button;
	MyDialog dialog; //�Զ��崰�ڵ�һ��ʵ��
	public MyWindow() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		button = new JButton("�򿪶Ի���");
		button.addActionListener(this);
		add(button,BorderLayout.NORTH);
		dialog = new MyDialog(this, "���ǶԻ���");
		dialog.setModal(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(true); //ʹ�Զ��崰�ڿɼ�
		String str = dialog.getTitle(); //����Ϊ���ǶԻ���
		setTitle(str);
	}
	
}


class MyDialog extends JDialog implements ActionListener{
	JTextField inputText;
	String title;
	public MyDialog(JFrame f,String s) {
		super(f,s);
		inputText = new JTextField(10);
		inputText.addActionListener(this);
		setLayout(new FlowLayout());
		add(new JLabel("���봰�ڵ��±���")); 
		add(inputText);
		setBounds(60, 60, 100, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		title = inputText.getText();
		setVisible(true);
		
	}
	
	public String getTitle(){
		return title;
	}
	
}