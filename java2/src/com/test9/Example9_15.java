package com.test9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * ����һ������MVCģʽ��д�ļ�������������ĳ���
 * @author lcj
 *
 */
public class Example9_15 {
	public static void main(String[] args) {
		WindowTriangle t = new WindowTriangle();
		t.setBounds(100,100,420,360);
		t.setTitle("ʹ��MVC�ṹ");
	}
}


class WindowTriangle extends JFrame implements ActionListener{
	Triangle triangle;            //ģ��
	JTextField textA,textB,textC; //��ͼ
	JTextArea showArea;           //��ͼ
	JButton button;     		  //����
	public WindowTriangle() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		triangle = new Triangle();
		textA = new JTextField(5);
		textB = new JTextField(5);
		textC = new JTextField(5);
		showArea = new JTextArea();
		button = new JButton("�������");
		JPanel pNorth = new JPanel();
		pNorth.add(new JLabel("��A"));
		pNorth.add(textA);
		pNorth.add(new JLabel("��B"));
		pNorth.add(textB);
		pNorth.add(new JLabel("��C"));
		pNorth.add(textC);
		pNorth.add(button);
		
		button.addActionListener(this);
		add(pNorth, BorderLayout.NORTH);
		add(new JScrollPane(showArea), BorderLayout.CENTER);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double a = Double.parseDouble(textA.getText().trim());
			double b = Double.parseDouble(textB.getText().trim());
			double c = Double.parseDouble(textC.getText().trim());
			triangle.setSideA(a);
			triangle.setSideB(b);
			triangle.setSideC(c);
			String area = triangle.getArea();
			showArea.append("������"+a+" "+b+" "+c+"�����");
			showArea.append(area+"\n");
		} catch (Exception e2) {
			showArea.append("\n"+e+"\n");
		}
	}
}

class Triangle {
	double sideA,sideB,sideC,area;
	boolean isTrianger;
	public String getArea() {
		if(isTrianger){
			double p = (sideA+sideB+sideC) / 2;
			area = Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
			return String.valueOf(area);			
		}else{
			return "�޷��������";
		}
	}
	public void setSideA(double sideA) {
		this.sideA = sideA;
		if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA){
			isTrianger = true;
		}else {
			isTrianger = false;
		}
	}
	public void setSideB(double sideB) {
		this.sideB = sideB;
		if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA){
			isTrianger = true;
		}else {
			isTrianger = false;
		}
	}
	public void setSideC(double sideC) {
		this.sideC = sideC;
		if(sideA+sideB>sideC&&sideA+sideC>sideB&&sideB+sideC>sideA){
			isTrianger = true;
		}else {
			isTrianger = false;
		}
	}
	
}