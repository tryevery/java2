package com.test9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * 消息对话框的程序
 * @author lcj
 *
 */
public class Example9_16 {
	public static void main(String[] args) {
		WindowMess mess = new WindowMess();
		mess.setBounds(80,90,200,300);
		mess.setTitle("带消息对话框");
		
	}
}

class WindowMess extends JFrame implements ActionListener{
	
	JTextField inputEnglish;
	JTextArea show;
	String regex = "[a-zA-Z]+";
	public WindowMess() {
		inputEnglish = new JTextField(22);
		inputEnglish.addActionListener(this); //添加一个动作监视器
		show  = new JTextArea();
		add(inputEnglish,BorderLayout.NORTH);
		add(show,BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputEnglish){
			String str = inputEnglish.getText();
			if(str.matches(regex)){ //是否符合正则表达式
				show.append(str+",");
			}else{ //弹出警告消息对话框
				JOptionPane.showMessageDialog(this, "您输入了非法字符","消息对话框",JOptionPane.WARNING_MESSAGE);
				//消息框在组件的正前方显示，显示的消息，对话框标题，对话框的类型
				inputEnglish.setText(null);
			}
		}
	}
	
}
