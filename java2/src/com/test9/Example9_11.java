package com.test9;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * ʹ��MouseMotionListener�ӿڴ�������϶����ƶ��¼�
 * @author lcj
 *
 */
public class Example9_11 {
	public static void main(String[] args) {
		WindowMove win = new WindowMove();
		win.setTitle("��������϶��¼�"); //���ñ���
		win.setBounds(10, 10, 460, 360); //���ô��ڴ�С
	}
}

class WindowMove extends JFrame {
	LP layeredPane;
	public WindowMove() {
		layeredPane = new LP();
		add(layeredPane,BorderLayout.CENTER); //���һ����ȵ����������Ҿ��в���
		setVisible(true);
		setBounds(12,12,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class LP extends JLayeredPane implements MouseListener,MouseMotionListener {
	JButton button;
	int x,y,a,b,x0,y0;
	LP(){
		button = new JButton("������϶���");
		button.addMouseListener(this); //���һ���������¼�
		button.addMouseMotionListener(this);//����������¼�
		setLayout(new FlowLayout()); //���һ�����ַ�ʽ
		add(button,JLayeredPane.DEFAULT_LAYER); //�������ȵ�����������һ��dault��ı�ݶ��󣬸������һ����ť
	}
	
	@Override
	public void mouseDragged(MouseEvent e) { //�϶���괥�����¼�
		Component com = null;
		//component ��һ������ͼ�α�ʾ�����Ķ��󣬿�����Ļ����ʾ���������û����н�����
		//����ͼ���û������еİ�ť����ѡ��͹������������ʾ���� 
		if(e.getSource() instanceof Component){ //
			com = (Component) e.getSource();
			a = com.getBounds().x; //��ȡ����ı߽�x
			b = com.getBounds().y;//��ȡ����ı߽�y
			x = e.getX();
			y = e.getY();
			a =a+x;
			b =b+y;
			com.setLocation(a-x0, b-y0);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {  //�ƶ���괥�����¼�
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JComponent com = null;
		com = (JComponent) e.getSource();
		setLayer(com, JLayeredPane.DRAG_LAYER); //����һ��Drag��ı�ݶ���
		a = com.getBounds().x;
		b = com.getBounds().y;
		x0 = e.getX(); //��갴��ʱ��ȡλ������x��y
		y0 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JComponent com = null;
		com = (JComponent) e.getSource();
		setLayer(com, JLayeredPane.DEFAULT_LAYER);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}