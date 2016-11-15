package com.test10;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 序列化对象与克隆
 * @author lcj
 *
 */
public class Example10_14 {
	public static void main(String[] args) {
		MyWin my = new MyWin();
	}
}


class MyWin extends JFrame implements ActionListener {
	JLabel label = null;
	JButton read = null,write = null;
	ByteArrayOutputStream out = null;
	public MyWin() {
		setLayout(new FlowLayout());
		label = new JLabel("How are you");
		read = new JButton("读入对象");
		write = new JButton("写出对象");
		read.addActionListener(this);
		write.addActionListener(this);
		setVisible(true);
		add(label);
		add(read);
		add(write);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==read){
			try {
			out = new ByteArrayOutputStream();
			ObjectOutputStream objectOut = new ObjectOutputStream(out);
			objectOut.writeObject(label);
			objectOut.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		else if(e.getSource()==write){
			try {
				ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
				ObjectInputStream objectIn = new ObjectInputStream(in);
				JLabel temp = (JLabel) objectIn.readObject();
				temp.setText("你好");
				this.add(temp);
				this.validate();
				objectIn.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}