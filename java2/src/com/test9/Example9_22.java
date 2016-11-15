package com.test9;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 * ������дһ��������벢����ɼ�
 * @author lcj
 *
 */
public class Example9_22 {
	public static void main(String[] args) {
		WinTable table = new WinTable();
	}
}


class WinTable extends JFrame implements ActionListener {
	JTable table;
	Object a[][];
	Object name[] = {"����","Ӣ��ɼ�","��ѧ�ɼ�","�ܳɼ�"};
	JButton button;
	public WinTable() {
		a = new Object[8][4];
		for(int i=0;i<8;i++){
			for(int j=0;j<a[i].length;j++){
				if(j!=0){
					a[i][j] = "0";
				}else a[i][j] = "����";
			}
		}
		
		button = new JButton("����ÿ�˵ĳɼ�");
		table = new JTable(a, name);
		button.addActionListener(this);
		Container con = getContentPane();
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		con.add(button, BorderLayout.SOUTH);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<8;i++){
			double sum = 0;
			boolean boo = true;
			for(int j=1;j<=2;j++){
				try {
					sum = sum + Double.parseDouble(a[i][j].toString());
					
				} catch (Exception e2) {
					boo = false;
					table.repaint();
				}
				if(boo){
					a[i][3] = "" + sum;
					table.repaint();
				}
			}
		}
		
	}
}
