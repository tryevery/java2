package com.test9;

import java.awt.FlowLayout;
import java.awt.RadialGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 练习ActionEvent事件
 * @author lcj
 * 
 * ActionEvent事件：
 * 1、ActionEvent事件源 （文本框、按钮、菜单项等）
 * 2、注册监视器 （以上组件调用addActionListener(ActionListener listen)
 *    将实现ActionListener接口的实例注册为事件源的监视器）
 * 3、实现ActionLisener接口
 * 4、调用ActionEvent中的方法
 *
 */
public class Example9_6 {
	public static void main(String[] args) {
		WindowActionEvent wimaction = new WindowActionEvent(); 
	}
}

class WindowActionEvent extends JFrame{
	JTextField text; 
	ActionListener listener; //声明一个监视器
	public WindowActionEvent(){
		setLayout(new FlowLayout());
		text = new JTextField(10);
		add(text);
		listener = new ReaderListen(); //创建监视器
		text.addActionListener(listener); //为文本框添加监视器
		setTitle("处理ActionEvent事件");
		setBounds(100,100,310,260);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class ReaderListen implements ActionListener { //负责创建监视器的类

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand(); //获得文本框中的字符串
		System.out.println(str+":"+str.length());
		
	}
	
}
