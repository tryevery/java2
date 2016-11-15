package com.test10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 使用文件锁来操作文件
 * @author lcj
 *
 */
public class Example10_19 {
	public static void main(String[] args) {
		File file = new File("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10\\Example10_19.java");
		WindowFileLock win = new WindowFileLock(file);
		win.setTitle("使用文件锁");
	}
}

class WindowFileLock extends JFrame implements ActionListener {
	
	JTextArea text;
	File file ;
	RandomAccessFile input;
	FileChannel channel;
	FileLock lock;
	JButton button;
	public WindowFileLock(File f) {
		file = f;
		try {
			input = new RandomAccessFile(file, "rw");
			channel = input.getChannel();
			lock = channel.tryLock();
		} catch (Exception e) {
		}
		text = new JTextArea();
		button = new JButton("读取一行");
		button.addActionListener(this);
		add(new JScrollPane(text),BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			lock.release();
			String lineString = input.readLine();
			text.append("\n"+lineString);
			lock = channel.tryLock();
			if(lineString==null){
				input.close();
			}
		} catch (Exception e2) {
		}
	}
	
}
