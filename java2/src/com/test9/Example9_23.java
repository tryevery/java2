package com.test9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;


/**
 * 将按钮绑定到键盘的一个例子
 * @author lcj
 *
 */
public class Example9_23 {
	public static void main(String[] args) {
		BindButtonWindow win = new BindButtonWindow();
	}
}



class BindButtonWindow extends JFrame {
	JButton button;
	Policelcj police;
	public BindButtonWindow() {
		setLayout(new FlowLayout());
		police = new Policelcj(); //创建一个监视器对象
		button = new JButton("单击我或则后按A键移动我");
		add(button);
		button.addActionListener(police); //添加一个监视器
		InputMap inputmap = button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputmap.put(KeyStroke.getKeyStroke("A"), "dog");
		ActionMap actionmap = button.getActionMap();
		actionmap.put("dog", police);
		setVisible(true);
		setBounds(100, 100, 200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Policelcj extends AbstractAction {
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		int x = b.getBounds().x;  //获取按钮的当前位置位置
		int y = b.getBounds().y;
		b.setLocation(x+10, y+10);
	}
	
}