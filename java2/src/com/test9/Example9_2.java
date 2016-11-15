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
 * 创建一个菜单条、菜单以及菜单项
 * @author lcj
 *
 */
public class Example9_2 {
	public static void main(String[] args) {
		WindowMenu w = new WindowMenu("带菜单的窗口",200,300,400,500);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置关闭方式
	}
	void init(String s){
		menubar = new JMenuBar(); //创建菜单条
		menu = new JMenu("菜单"); //创建菜单
		menu.setMnemonic('a'); //添加一个快捷键 alt + a
		submenu = new JMenu("软件项目");
		item1 = new JMenuItem("JAVA话题",new ImageIcon("a.jpg")); //创建菜单项，并设置图标 
		item2 = new JMenuItem("动画话题",new ImageIcon("b,jpg"));
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK)); //设置快捷键
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		menu.add(submenu);
		//运用反射获取资源
		submenu.add(new JMenuItem("汽车销售系统",new ImageIcon(WindowMenu.class.getResource("c.jpg"))));
		submenu.add(new JMenuItem("农场信息系统",new ImageIcon("d.jpg")));
		menubar.add(menu);
		setJMenuBar(menubar);
		
		
	}
	
	
}
