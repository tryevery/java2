package com.test9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 改进使这个文本框中的信息显示在窗口文本域中
 * 利用组合让一个对象来操作另一个对象
 * @author lcj
 *
 */
public class Example9_7 {
	public static void main(String[] args) {
		WindowsActionEvent win = new WindowsActionEvent();
		PoliceListen police = new PoliceListen(); //创建监视器
		win.setMyCommandListener(police); //窗口组合监视器
	}
}

class WindowsActionEvent extends JFrame{
	JTextField inputText;
	JTextArea textShow;
	JButton button;
	MyCommandListener listener;
	public WindowsActionEvent(){
		init();
		setTitle("处理ActionEvent事件");
		setBounds(100,100,460,360);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		setLayout(new FlowLayout());
		inputText = new JTextField(10);
		button = new JButton("确定");
		textShow = new JTextArea(9,30);
		add(inputText);
		add(button);
		add(new JScrollPane(textShow));
	}
	
	void setMyCommandListener(MyCommandListener listener){
		this.listener = listener;
		listener.setJTextField(inputText);  //传递JTextField对象
		listener.setJTextArea(textShow);//传递TextArea对象
		inputText.addActionListener(listener); //为组件添加监视器
		button.addActionListener(listener);
	//  事件源                               监视器
	}
}

interface MyCommandListener extends ActionListener{ //子接口给出两个方法
	public void setJTextField(JTextField text);
	public void setJTextArea(JTextArea area);
}

class PoliceListen implements MyCommandListener{//负责创建监视器的类
	JTextField textInput;
	JTextArea textArea;
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textInput.getText();
		textArea.append(str+"的长度："+str.length()+"\n");
	}

	@Override
	public void setJTextField(JTextField text) {
		textInput = text;
	}

	@Override
	public void setJTextArea(JTextArea area) {
		textArea = area;
	}
	
}
