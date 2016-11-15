package com.test9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * 输入对话框的程序
 * @author lcj
 *
 */
public class Example9_17 {
	public static void main(String[] args) {
		WindowInput in = new WindowInput();
		in.setTitle("带消息对话框的窗口");
		in.setBounds(80, 90, 300, 300);
	}
}

class WindowInput extends JFrame implements ActionListener{
	
	JTextArea showResult;
	JButton openInput;
	public WindowInput() {
		openInput = new JButton("弹出输入对话框");
		showResult = new JTextArea();
		add(openInput,BorderLayout.NORTH);
		add(new JScrollPane(showResult),BorderLayout.CENTER);
		openInput.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //弹出输入对话框
		String str = JOptionPane.showInputDialog(this,"输入数字","输入对话框",JOptionPane.PLAIN_MESSAGE);
		if(str!=null){
			Scanner s = new Scanner(str);
			double sum = 0;
			int k = 0;
			while(s.hasNext()){
				try {
					double number = s.nextDouble();
					if(k==0)
						showResult.append(""+number);
					else showResult.append("+"+number);
					sum = sum + number;
					k++;
				} catch (InputMismatchException e2) {
					String t = s.next();
				}
			}
			showResult.append("="+sum+"\n");
		}
		
	}
	
}
