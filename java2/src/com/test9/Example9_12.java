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
 * ʹ�ü����¼���д�������кŵĳ���
 * @author lcj
 *
 */
public class Example9_12 {
	public static void main(String[] args) {
		Win win = new Win();
		win.setTitle("�������кţ�");
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
			text[i].addKeyListener(police); //Ϊ�ı���ע��һ�����̼�����
			text[i].addFocusListener(police);//Ϊ�ı���ע��һ�����������
			add(text[i]);
		}
		
		button = new JButton("ȷ��");
		add(button);
		text[0].requestFocusInWindow();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Police implements KeyListener,FocusListener { //�����¼��ͽ����¼�

	@Override
	public void focusGained(FocusEvent e) {
		JTextField text = (JTextField) e.getSource();
		text.setText(null); //�������ı���ʱ�Ὣ��ǰ���ı�����
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
		if(t.getCaretPosition()>=6){ //�����ı�������ı�������ŵ�λ��
			t.transferFocus(); //�������Ƶ���һ�����
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}