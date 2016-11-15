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
 * 自定义对话框
 * @author lcj
 *
 */
public class Example9_20 {
	public static void main(String[] args) {
		MyWindow win = new MyWindow();
		win.setTitle("带自定义对话框的窗口");
		win.setSize(200, 300);
	}
}

class MyWindow extends JFrame implements ActionListener {
	JButton button;
	MyDialog dialog; //自定义窗口的一个实例
	public MyWindow() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		button = new JButton("打开对话框");
		button.addActionListener(this);
		add(button,BorderLayout.NORTH);
		dialog = new MyDialog(this, "我是对话框");
		dialog.setModal(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.setVisible(true); //使自定义窗口可见
		String str = dialog.getTitle(); //标题为我是对话框
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
		add(new JLabel("输入窗口的新标题")); 
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