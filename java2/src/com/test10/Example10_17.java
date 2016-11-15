package com.test10;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 文件对话框
 * 使用文件对话框打开和保存文件
 * @author lcj
 *
 */
public class Example10_17 {
	public static void main(String[] args) {
		WindowReader win = new WindowReader();
	}
}


class WindowReader extends JFrame implements ActionListener {
	
	JFileChooser fileDialog;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem itemSave,itemOpen;
	JTextArea textArea;
	BufferedReader in;
	FileReader fileReader;
	BufferedWriter out;
	FileWriter fileWrite;
	public WindowReader() {
		init();
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void init(){
		textArea = new JTextArea();
		textArea.setFont(new Font("楷体_gb2312",Font.PLAIN,28));
		add(new JScrollPane(textArea),BorderLayout.CENTER);
		menubar = new JMenuBar();
		menu = new JMenu("文件");
		itemOpen = new JMenuItem("打开文件");
		itemSave = new JMenuItem("保存文件");
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		menu.add(itemOpen);
		menu.add(itemSave);
		menubar.add(menu);
		setJMenuBar(menubar);
		fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("java文件", "java");
		fileDialog.setFileFilter(filter);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itemSave){
			int state = fileDialog.showSaveDialog(this);
			if(state == JFileChooser.APPROVE_OPTION){
				try {
					File dir = fileDialog.getCurrentDirectory();
					String name = fileDialog.getSelectedFile().getName();
					File file = new File(dir,name);
					fileWrite = new FileWriter(file);
					out = new BufferedWriter(fileWrite);
					out.write(textArea.getText());
					out.close();
					fileWrite.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}else if(e.getSource()==itemOpen){
			int state = fileDialog.showOpenDialog(this);
			if(state==JFileChooser.APPROVE_OPTION){
				textArea.setText(null);
				try {
					File dir = fileDialog.getCurrentDirectory(); 
					String name = fileDialog.getSelectedFile().getName();
					File file = new File(dir,name);
					fileReader = new FileReader(file);
					in = new BufferedReader(fileReader);
					String s = null;
					while((s=in.readLine())!=null){
						textArea.append(s+"\n");
						
					}
					in.close();
					fileReader.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	
}