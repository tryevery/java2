package com.test9;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 鼠标监听事件
 * @author lcj
 *
 */
public class Example9_10 {
	public static void main(String[] args) {
		WindowMouse mouse = new WindowMouse();
		mouse.setTitle("處理鼠標事件");
		mouse.setBounds(10,10,460,360);
	}
}

class WindowMouse extends JFrame {
	JTextField text;
	JButton button;
	JTextArea area;
	MousePolice police;
	public WindowMouse() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		setLayout(new FlowLayout());
		text  = new JTextField(8);
		area = new JTextArea(5,28);
		police = new MousePolice();
		police.setJTextArea(area);
		text.addMouseListener(police);
		button = new JButton("按鈕");
		button.addMouseListener(police);
		addMouseListener(police);
		add(button);
		add(text);
		add(new JScrollPane(area));
	}
}

class MousePolice implements MouseListener {
	JTextArea area;
	public void setJTextArea(JTextArea area){
		this.area = area;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()>2)
		area.append("\n鼠標連機位置"+"" + e.getX() + ","+ e.getY()+")");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		area.append("\n鼠標按下位置"+"" + e.getX() + ","+ e.getY()+")"); 
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		area.append("\n鼠標釋放位置"+"" + e.getX() + ","+ e.getY()+")");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() instanceof JButton)
		area.append("\n鼠標進入按鈕位置"+"" + e.getX() + ","+ e.getY()+")");
		if(e.getSource() instanceof JTextField)
			area.append("\n鼠標進入文本框位置"+"" + e.getX() + ","+ e.getY()+")");
		if(e.getSource() instanceof JFrame)
			area.append("\n鼠標進入窗口位置"+"" + e.getX() + ","+ e.getY()+")");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		area.append("\n鼠標退出位置"+"" + e.getX() + ","+ e.getY()+")");
	}
	
}