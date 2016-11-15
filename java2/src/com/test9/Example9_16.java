package com.test9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * ��Ϣ�Ի���ĳ���
 * @author lcj
 *
 */
public class Example9_16 {
	public static void main(String[] args) {
		WindowMess mess = new WindowMess();
		mess.setBounds(80,90,200,300);
		mess.setTitle("����Ϣ�Ի���");
		
	}
}

class WindowMess extends JFrame implements ActionListener{
	
	JTextField inputEnglish;
	JTextArea show;
	String regex = "[a-zA-Z]+";
	public WindowMess() {
		inputEnglish = new JTextField(22);
		inputEnglish.addActionListener(this); //���һ������������
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
			if(str.matches(regex)){ //�Ƿ����������ʽ
				show.append(str+",");
			}else{ //����������Ϣ�Ի���
				JOptionPane.showMessageDialog(this, "�������˷Ƿ��ַ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
				//��Ϣ�����������ǰ����ʾ����ʾ����Ϣ���Ի�����⣬�Ի��������
				inputEnglish.setText(null);
			}
		}
	}
	
}
