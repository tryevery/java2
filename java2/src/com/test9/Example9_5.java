package com.test9;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * BoxLayout布局练习
 * @author lcj
 *
 */
public class Example9_5 {
	public static void main(String[] args) {
		WindowBoxLayout win = new WindowBoxLayout();
		win.setBounds(100, 100, 310, 260);
		
	}
}

class WindowBoxLayout extends JFrame {
	Box baseBox,box1,box2;
	public WindowBoxLayout() {
		setLayout(new FlowLayout());
		init();
		setTitle("嵌套盒布局容器");
		setVisible(true);
		/*setLocation(100, 100); //这个应放在前面才有效
		setSize(310, 260);*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		box1 = Box.createVerticalBox();
		box1.add(new JLabel("姓名"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("email"));
		box1.add(Box.createVerticalStrut(8));
		box1.add(new JLabel("职业"));
		
		box2 = Box.createVerticalBox();
		box2.add(new JTextField(10));
		box2.add(Box.createVerticalStrut(8));
		box2.add(new JTextField(10));
		box2.add(Box.createVerticalStrut(8));
		box2.add(new JTextField(10));
		
		baseBox = Box.createHorizontalBox();
		baseBox.add(box1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(box2);
		add(baseBox);
	}
}
