package com.test10;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Ӧ�þ���  ͨѶ¼
 * @author lcj
 *
 */
public class Example10_21 {
	public static void main(String[] args) {
		new CommFrame();
	}
}

class CommFrame extends JFrame implements ActionListener {
	File file = null;
	JMenuBar bar;
	JMenu menu;
	JMenuItem inputMenuItem,showMenuItem;
	JTextArea show;  //��ʾ��Ϣ
	InputArea inputMessage;  //¼����Ϣ
	CardLayout card = null; //��Ƭʽ����
	JPanel pCenter;
	public CommFrame() {
		file = new File("ͨѶ¼.txt");
		inputMenuItem = new JMenuItem("¼��");
		showMenuItem = new JMenuItem("��ʾ");
		bar = new JMenuBar();
		menu = new JMenu("�˵�ѡ��");
		menu.add(inputMenuItem);
		menu.add(showMenuItem);
		bar.add(menu);
		setJMenuBar(bar);
		inputMenuItem.addActionListener(this);
		showMenuItem.addActionListener(this);
		inputMessage = new InputArea(file);
		show = new JTextArea(12,20);
		card = new CardLayout();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		pCenter.add("inputMenuItem", inputMessage);
		pCenter.add("showMenuItem", new JScrollPane(show));
		add(pCenter,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(100, 50, 420, 380);
		validate();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputMenuItem){
			card.show(pCenter, "inputMenuItem");
		}else if(e.getSource()==showMenuItem){
			int number = 1;
			show.setText(null);
			card.show(pCenter, "showMenuItem");
			try {
				RandomAccessFile in = new RandomAccessFile(file, "r");
				String name = null;
				while((name=in.readUTF())!=null){
					show.append("\n"+number+" "+name);
					show.append("\t "+in.readUTF());
					show.append("\t"+in.readUTF());
					show.append("\n"+"----------------");
					number++;
				}
				in.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}

class InputArea extends JPanel implements ActionListener {
	File f = null;
	RandomAccessFile out;
	Box baseBox,boxV1,boxV2;
	JTextField name,email,phone;
	JButton button;
	
	public InputArea(File f) {
		setBackground(Color.CYAN);
		this.f = f;
		name = new JTextField(12);
		email = new JTextField(12);
		phone = new JTextField(12);
		button = new JButton("¼��");
		button.addActionListener(this);
		boxV1 = Box.createVerticalBox();
		boxV1.add(new JLabel("��������"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("����email"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("����绰"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("����¼��"));
		
		boxV2 = Box.createVerticalBox();
		boxV2.add(name);
		boxV2.add(Box.createHorizontalStrut(8));
		boxV2.add(email);
		boxV2.add(Box.createHorizontalStrut(8));
		boxV2.add(phone);
		boxV2.add(Box.createHorizontalStrut(8));
		boxV2.add(button);
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);
		add(baseBox);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			RandomAccessFile out = new RandomAccessFile(f, "rw");
			if(f.exists()){
				long length = f.length();
				out.seek(length);
			}
			out.writeUTF("����"+name.getText());
			out.writeUTF("email"+email.getText());
			out.writeUTF("�绰"+phone.getText());
			out.close();
		} catch (Exception e2) {
		}
		
	}
	
}
