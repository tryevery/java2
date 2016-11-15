package com.test9;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Text extends JFrame{
	public static void main(String[] args) {
		JFrame p = new JFrame();
		p.setLayout(null); //null²¼¾Ö
		p.setVisible(true);
		p.setLocation(100, 100);
		p.setSize(200, 300);
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jb = new JLabel("ÐÕÃû");
		p.add(jb);
		jb.setBounds(50, 50, 50, 50);
	}
}
