package com.test9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * GridLayout布局实战
 * @author lcj
 *
 */
public class Example9_4 {
	public static void main(String[] args) {
		WinGrid g = new WinGrid();
	}
}

class WinGrid extends JFrame{
	GridLayout grid; //网格布局对象
	JPanel chessboard;  //创建一个面板
	public WinGrid() {
		chessboard = new JPanel();
		grid = new GridLayout(12,12);
		chessboard.setLayout(grid);
		Label label[][] = new Label[12][12]; //对象二维数组
		for(int i=0;i<12;i++){
			for(int j=0;j<12;j++){
				label[i][j] = new Label(); //标签对象
				if((i+j)%2==0){
					label[i][j].setBackground(Color.BLACK);
				}else{
					label[i][j].setBackground(Color.WHITE);
				}
				chessboard.add(label[i][j]); //添加到面板中
			}
		}
		
		add(chessboard,BorderLayout.CENTER); //为窗口添加一个面板，并剧中显示
		add(new JButton("北方参赛者"),BorderLayout.NORTH); //为窗口添加按钮，使用边界布局
		add(new JButton("南方参赛者"),BorderLayout.SOUTH);
		add(new JButton("西方参赛者"),BorderLayout.WEST);
		add(new JButton("东方参赛者"),BorderLayout.EAST);
		setBounds(10, 10, 570, 390);//设置大小
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();//更新数据
	}
}
