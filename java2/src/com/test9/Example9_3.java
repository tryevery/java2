package com.test9;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Swing中的常用组建
 * @author lcj
 *
 */
public class Example9_3 {
	public static void main(String[] args) {
		ComponentInWindow com = new ComponentInWindow();
		com.setBounds(100, 100, 400, 300);
		com.setTitle("常用组件");
	}
}

class ComponentInWindow extends JFrame{
	JTextField text;
	JButton button;
	JCheckBox checkBox1,checkBox2,checkBox3;
	JRadioButton radio1,radio2;
	ButtonGroup group;
	JComboBox comBox;
	JTextArea area;
	
	public ComponentInWindow(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		setLayout(new FlowLayout());
		add(new JLabel("文本框："));
		text = new JTextField(10);
		add(text);
		System.out.println();
		add(new JLabel("按钮："));
		button = new JButton("确定");
		add(button);

		add(new JLabel("复选框："));
		checkBox1 = new JCheckBox("喜欢音乐");
		checkBox2 = new JCheckBox("喜欢旅游");
		checkBox3 = new JCheckBox("喜欢篮球");
		add(checkBox1);
		add(checkBox2);
		add(checkBox3);
		
		add(new JLabel("单选按钮："));
		group = new ButtonGroup();
		radio1 = new JRadioButton("男");
		radio2 = new JRadioButton("女");
		group.add(radio1);
		group.add(radio2);
		add(radio1);
		add(radio2);

		add(new JLabel("下拉列表："));
		comBox = new JComboBox();
		comBox.addItem("音乐天地");
		comBox.addItem("武术天地");
		comBox.addItem("象棋天地");
		add(comBox);
		
		add(new JLabel("文本域："));
		area = new JTextArea(6,12);
		add(new JScrollPane(area)); //添加到滚动窗格中
		
	}
}
