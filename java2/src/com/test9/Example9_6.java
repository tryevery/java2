package com.test9;

import java.awt.FlowLayout;
import java.awt.RadialGradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * ��ϰActionEvent�¼�
 * @author lcj
 * 
 * ActionEvent�¼���
 * 1��ActionEvent�¼�Դ ���ı��򡢰�ť���˵���ȣ�
 * 2��ע������� �������������addActionListener(ActionListener listen)
 *    ��ʵ��ActionListener�ӿڵ�ʵ��ע��Ϊ�¼�Դ�ļ�������
 * 3��ʵ��ActionLisener�ӿ�
 * 4������ActionEvent�еķ���
 *
 */
public class Example9_6 {
	public static void main(String[] args) {
		WindowActionEvent wimaction = new WindowActionEvent(); 
	}
}

class WindowActionEvent extends JFrame{
	JTextField text; 
	ActionListener listener; //����һ��������
	public WindowActionEvent(){
		setLayout(new FlowLayout());
		text = new JTextField(10);
		add(text);
		listener = new ReaderListen(); //����������
		text.addActionListener(listener); //Ϊ�ı�����Ӽ�����
		setTitle("����ActionEvent�¼�");
		setBounds(100,100,310,260);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class ReaderListen implements ActionListener { //���𴴽�����������

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand(); //����ı����е��ַ���
		System.out.println(str+":"+str.length());
		
	}
	
}
