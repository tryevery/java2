package com.test9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GridLayout����ʵս
 * @author lcj
 *
 */
public class Example9_4 {
	public static void main(String[] args) {
		WinGrid g = new WinGrid();
	}
}

class WinGrid extends JFrame{
	GridLayout grid; //���񲼾ֶ���
	JPanel chessboard;  //����һ�����
	public WinGrid() {
		chessboard = new JPanel();
		grid = new GridLayout(12,12);
		chessboard.setLayout(grid);
		Label label[][] = new Label[12][12]; //�����ά����
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				label[i][j] = new Label(); //��ǩ����
				if((i+j)%2==0){
					label[i][j].setBackground(Color.BLACK);
				}else{
					label[i][j].setBackground(Color.WHITE);
				}
				chessboard.add(label[i][j]); //��ӵ������
			}
		}
		
		add(chessboard,BorderLayout.CENTER); //Ϊ�������һ����壬��������ʾ
		add(new JButton("����������"),BorderLayout.NORTH); //Ϊ������Ӱ�ť��ʹ�ñ߽粼��
		add(new JButton("�Ϸ�������"),BorderLayout.SOUTH);
		add(new JButton("����������"),BorderLayout.WEST);
		add(new JButton("����������"),BorderLayout.EAST);
		setBounds(10, 10, 570, 390);//���ô�С
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();//��������
	}
}
