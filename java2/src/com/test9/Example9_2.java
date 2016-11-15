package com.test9;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * ����һ���˵������˵��Լ��˵���
 * @author lcj
 *
 */
public class Example9_2 {
	public static void main(String[] args) {
		WindowMenu w = new WindowMenu("���˵��Ĵ���",200,300,400,500);
	}
}

class WindowMenu extends JFrame{
	JMenuBar menubar;
	JMenu menu,submenu;
	JMenuItem item1,item2;
	public WindowMenu() {
		
	}
	public WindowMenu(String s,int x,int y,int w,int h) {
		init(s);
		setLocation(x,y);
		setSize(w, h);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���ùرշ�ʽ
	}
	void init(String s){
		menubar = new JMenuBar(); //�����˵���
		menu = new JMenu("�˵�"); //�����˵�
		menu.setMnemonic('a'); //���һ����ݼ� alt + a
		submenu = new JMenu("�����Ŀ");
		item1 = new JMenuItem("JAVA����",new ImageIcon("a.jpg")); //�����˵��������ͼ�� 
		item2 = new JMenuItem("��������",new ImageIcon("b,jpg"));
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK)); //���ÿ�ݼ�
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		menu.add(submenu);
		//���÷����ȡ��Դ
		submenu.add(new JMenuItem("��������ϵͳ",new ImageIcon(WindowMenu.class.getResource("c.jpg"))));
		submenu.add(new JMenuItem("ũ����Ϣϵͳ",new ImageIcon("d.jpg")));
		menubar.add(menu);
		setJMenuBar(menubar);
		
		
	}
	
	
}
