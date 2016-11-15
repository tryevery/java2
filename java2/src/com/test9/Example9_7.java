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
 * �Ľ�ʹ����ı����е���Ϣ��ʾ�ڴ����ı�����
 * ���������һ��������������һ������
 * @author lcj
 *
 */
public class Example9_7 {
	public static void main(String[] args) {
		WindowsActionEvent win = new WindowsActionEvent();
		PoliceListen police = new PoliceListen(); //����������
		win.setMyCommandListener(police); //������ϼ�����
	}
}

class WindowsActionEvent extends JFrame{
	JTextField inputText;
	JTextArea textShow;
	JButton button;
	MyCommandListener listener;
	public WindowsActionEvent(){
		init();
		setTitle("����ActionEvent�¼�");
		setBounds(100,100,460,360);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		setLayout(new FlowLayout());
		inputText = new JTextField(10);
		button = new JButton("ȷ��");
		textShow = new JTextArea(9,30);
		add(inputText);
		add(button);
		add(new JScrollPane(textShow));
	}
	
	void setMyCommandListener(MyCommandListener listener){
		this.listener = listener;
		listener.setJTextField(inputText);  //����JTextField����
		listener.setJTextArea(textShow);//����TextArea����
		inputText.addActionListener(listener); //Ϊ�����Ӽ�����
		button.addActionListener(listener);
	//  �¼�Դ                               ������
	}
}

interface MyCommandListener extends ActionListener{ //�ӽӿڸ�����������
	public void setJTextField(JTextField text);
	public void setJTextArea(JTextArea area);
}

class PoliceListen implements MyCommandListener{//���𴴽�����������
	JTextField textInput;
	JTextArea textArea;
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textInput.getText();
		textArea.append(str+"�ĳ��ȣ�"+str.length()+"\n");
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
