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
 * 使用MouseMotionListener接口处理鼠标拖动和移动事件
 * @author lcj
 *
 */
public class Example9_11 {
	public static void main(String[] args) {
		WindowMove win = new WindowMove();
		win.setTitle("处理鼠标拖动事件"); //设置标题
		win.setBounds(10, 10, 460, 360); //设置窗口大小
	}
}

class WindowMove extends JFrame {
	LP layeredPane;
	public WindowMove() {
		layeredPane = new LP();
		add(layeredPane,BorderLayout.CENTER); //添加一个深度的容器，并且剧中布局
		setVisible(true);
		setBounds(12,12,300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class LP extends JLayeredPane implements MouseListener,MouseMotionListener {
	JButton button;
	int x,y,a,b,x0,y0;
	LP(){
		button = new JButton("用鼠标拖动我");
		button.addMouseListener(this); //添加一个鼠标监听事件
		button.addMouseMotionListener(this);//添加鼠标监听事件
		setLayout(new FlowLayout()); //添加一个布局方式
		add(button,JLayeredPane.DEFAULT_LAYER); //添加了深度的容器，定义一个dault层的便捷对象，给其添加一个按钮
	}
	
	@Override
	public void mouseDragged(MouseEvent e) { //拖动鼠标触发的事件
		Component com = null;
		//component 是一个具有图形表示能力的对象，可在屏幕上显示，并可与用户进行交互。
		//典型图形用户界面中的按钮、复选框和滚动条都是组件示例。 
		if(e.getSource() instanceof Component){ //
			com = (Component) e.getSource();
			a = com.getBounds().x; //获取组件的边界x
			b = com.getBounds().y;//获取组件的边界y
			x = e.getX();
			y = e.getY();
			a =a+x;
			b =b+y;
			com.setLocation(a-x0, b-y0);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {  //移动鼠标触发的事件
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
		setLayer(com, JLayeredPane.DRAG_LAYER); //定义一个Drag层的便捷对象
		a = com.getBounds().x;
		b = com.getBounds().y;
		x0 = e.getX(); //鼠标按下时获取位置坐标x和y
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