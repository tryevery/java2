package com.test9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 实现一个简单的计算器
 * 用户在窗口中的两个文本框中输入参数
 * 用户在下拉列表中选择运算符将触发ItemEvent事件，ItemEvent时间的监视器operator获得运算符，
 * 并将运算符传递给ActionEvent事件的监视器
 * 用户单击按钮触发ActionEvent事件，监视器computer给出运算结果
 * @author lcj
 *
 */
public class Example9_8 {
	public static void main(String[] args) {
		WindowOperation op = new WindowOperation();
		
	}
}

class WindowOperation extends JFrame{
	JTextField inputNumber1,inputNumber2;
	JComboBox choiceFuhao;
	JTextArea textshow;
	JButton button;
	OperatorListener operator; //监听ItemEvent事件的监视器
	ComputerListener computer; //监听ActionEvent事件的监视器
	public WindowOperation() {
		init();
		setTitle("简单计算器");
		setBounds(100, 100, 390, 360);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void init() {
		setLayout(new FlowLayout());
		inputNumber1 = new JTextField(5);
		inputNumber2 = new JTextField(5);
		choiceFuhao = new JComboBox();
		button = new JButton("计算");
		choiceFuhao.addItem("选择符号：");
		String []a =  {"+","-","*","/"};
		for(int i=0;i<a.length;i++){
			choiceFuhao.addItem(a[i]);
		}
		
		textshow = new JTextArea(9,30);
		operator = new OperatorListener();
		computer = new ComputerListener();
		operator.setJComboBox(choiceFuhao);
		operator.setWorkTogether(computer);
		computer.setJTextFieldOne(inputNumber1);
		computer.setJTextFieldTwo(inputNumber2);
		computer.setJTextArea(textshow);
		choiceFuhao.addItemListener(operator); //事件源添加监视器
		button.addActionListener(computer);
		add(inputNumber1);
		add(choiceFuhao);
		add(inputNumber2);
		add(button);
		add(new JScrollPane(textshow));
	}
	
}


class OperatorListener implements ItemListener{
	
	JComboBox choice;
	ComputerListener computer;
	public void setJComboBox(JComboBox box){
		choice = box;
	}
	public void setWorkTogether(ComputerListener computer){
		this.computer = computer;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String fuhao = choice.getSelectedItem().toString();
		computer.setFuhao(fuhao);
		
	}
	
}

class ComputerListener implements ActionListener{
	JTextField inputNumber1,inputNumber2;
	JTextArea textshow;
	String fuhao;
	public void setJTextFieldOne(JTextField t){
		inputNumber1 = t;
	}
	public void setJTextFieldTwo(JTextField t){
		inputNumber2 = t;
	}
	public void setJTextArea(JTextArea area){
		textshow = area;
	}
	public void setFuhao(String s) {
		fuhao = s;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double number1 = Double.parseDouble(inputNumber1.getText());
			double number2 = Double.parseDouble(inputNumber2.getText());
			double result = 0;
			if(fuhao.equals("+")){
				result = number1 + number2;
			}
			else if(fuhao.equals("-")){
				result = number1 - number2;
			}
			else if(fuhao.equals("*")){
				result = number1 * number2;
			}
			else if(fuhao.equals("/")){
				result = number1 / number2;
			}
			textshow.append(number1 + " " + fuhao + " " + number2 + "=" + result+"\n");
		} catch (Exception e2) {
			textshow.append("请输入数字字符");
		}
		
	}

	
}