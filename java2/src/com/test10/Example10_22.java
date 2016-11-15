package com.test10;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Ӧ�þ��� �򵥵�java���ɻ���
 * 
 * @author lcj
 *
 */
public class Example10_22 {
	public static void main(String[] args) {
		JDKWindow jdk = new JDKWindow();
	}
}

class JDKWindow extends JFrame {
	JTextField javaSourceFileName; //javaԴ�ļ�
	JTextField javaMainClassName;
	JButton compile, run, edit;
	HandleListener listener;
	public JDKWindow() {
		edit = new JButton("�ü��±��༭�ļ�");
		compile = new JButton("����");
		run = new JButton("����");
		javaSourceFileName = new JTextField(10);
		javaMainClassName = new JTextField(10);
		setLayout(new FlowLayout());
		add(edit);
		add(new JLabel("����Դ�ļ�"));
		add(javaSourceFileName);
		add(compile);
		add(new JLabel("����������"));
		add(javaMainClassName);
		add(run);
		listener = new HandleListener();
		edit.addActionListener(listener);
		compile.addActionListener(listener);
		run.addActionListener(listener);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 180);
	}
	class HandleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==edit){
				Runtime ce = Runtime.getRuntime();
				File file = new File("c:/windows","notepad.exe");
				try {
					ce.exec(file.getAbsolutePath());
				} catch (Exception e2) {}
			}
			else if (e.getSource()==compile){
				ComplieDialog compileDialog = new ComplieDialog();
				String name = javaSourceFileName.getText();
				compileDialog.complie(name);
				compileDialog.setVisible(true);
			}
			else if (e.getSource()==run){
				RunDialog runDialog = new RunDialog();
				String name = javaMainClassName.getText();
				runDialog.run(name);
				runDialog.setVisible(true);
			}
		}

	}
}

class ComplieDialog extends JDialog {
	JTextArea showError;

	public ComplieDialog() {
		setTitle("����Ի���");
		showError = new JTextArea();
		Font f = new Font("����", Font.BOLD, 20);
		showError.setFont(f);
		add(new JScrollPane(showError), BorderLayout.CENTER);
		setBounds(10, 10, 500, 300);
	}

	public void complie(String name) {
		try {
			Runtime ce = Runtime.getRuntime();
			Process process = ce.exec("javac " + name);
			InputStream in = process.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			int n;
			boolean bn = true;
			byte[] error = new byte[100];
			while ((n = bis.read(error, 0, 100)) != -1) {
				String str = null;
				str = new String(error, 0, n);
				showError.append(str);
				if (str != null) bn = false;
			}
			if (bn)
				showError.append("������ȷ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

class RunDialog extends JDialog {
	JTextArea showOut;

	public RunDialog() {
		setTitle("���жԻ���");
		showOut = new JTextArea();
		Font f = new Font("����", Font.BOLD, 15);
		showOut.setFont(f);
		add(new JScrollPane(showOut), BorderLayout.CENTER);
		setBounds(210, 10, 500, 300);
	}

	public void run(String name) {
		try {
			Runtime ce = Runtime.getRuntime();
			Process process = ce.exec("java " + name);
			InputStream in = process.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			int n;
			boolean bn = true;
			byte mess[] = new byte[100];
			while ((n = bin.read(mess, 0, 100)) != -1) {
				String s = null;
				s = new String(mess, 0, n);
				showOut.append(s);
				if (s != null) bn = false;
				if (bn) showOut.setText("java������ûʹ��out����������Ϣ");
			}
		} catch (Exception e) {
		}
	}
}
