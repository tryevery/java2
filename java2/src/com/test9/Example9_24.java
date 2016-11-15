package com.test9;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * 打印机组件小程序
 * @author lcj
 *
 */
public class Example9_24 {
	public static void main(String[] args) {
		MyFramelcj my = new MyFramelcj();
		my.setBounds(70, 70, 570, 289);
		my.setVisible(true);
		my.validate();
	}
}

class MyFramelcj extends JFrame implements ActionListener {
	PrintJob p = null;
	Graphics g = null;
	JTextArea text = new JTextArea(10, 10);
	JButton printTextFied = new JButton("打印文本框"),
			printFrame = new JButton("打印窗口"),
			printButton = new JButton("打印按钮");
	
	public MyFramelcj() {
		super("在应用程序中打开");
		printTextFied.addActionListener(this);
		printFrame.addActionListener(this);
		printButton.addActionListener(this);
		add(text,"Center");
		JPanel panel = new JPanel();
		panel.add(printTextFied);
		panel.add(printButton);
		panel.add(printFrame);
		
		add(panel,"South");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == printTextFied){
			p = getToolkit().getPrintJob(this, "ok", null);
			g = p.getGraphics();
			g.translate(120, 200);
			text.printAll(g);
			g.dispose();
			p.end();
		}
		else if(e.getSource() == printFrame){
			p = getToolkit().getPrintJob(this, "ok", null);
			g = p.getGraphics();
			g.translate(120, 200);
			this.printAll(g);
			g.dispose();
			p.end();
		}
		if(e.getSource() == printButton){
			p = getToolkit().getPrintJob(this, "ok", null);
			g = p.getGraphics();
			g.translate(120, 200);
			printTextFied.printAll(g);
			g.translate(78, 0);
			printFrame.printAll(g);
			g.translate(66, 0);
			printButton.printAll(g);
			g.dispose();
			p.end();
		}
		
	}
}
