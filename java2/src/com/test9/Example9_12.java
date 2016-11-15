package com.test9;

import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 使用键盘事件编写输入序列号的程序
 * @author lcj
 *
 */
public class Example9_12 {
	public static void main(String[] args) {
		Win win = new Win();
		win.setTitle("输入序列号：");
		win.setBounds(10, 10, 460, 360);
	}
	
}

class Win extends JFrame {
	JTextField text[] = new JTextField[3];
	Police police;
	JButton button;
	public Win(){
		setLayout(new FlowLayout());
		police = new Police();
		for(int i=0;i<text.length;i++){
			text[i] = new JTextField(7);
			text[i].addKeyListener(police); //为文本框注册一个键盘监视器
			text[i].addFocusListener(police);//为文本框注册一个焦点监视器
			add(text[i]);
		}
		
		button = new JButton("确定");
		add(button);
		text[0].requestFocusInWindow();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Police implements KeyListener,FocusListener { //键盘事件和焦点事件

	@Override
	public void focusGained(FocusEvent e) {
		JTextField text = (JTextField) e.getSource();
		text.setText(null); //当单击文本框时会将以前的文本销毁
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		JTextField t = (JTextField) e.getSource();
		if(t.getCaretPosition()>=6){ //返回文本组件中文本插入符号的位置
			t.transferFocus(); //将焦点移到下一个组件
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}