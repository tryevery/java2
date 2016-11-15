package com.test9;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * DecumentEvent�¼���ʵ�ֽ�������ı�����һ���ı�������ʾ���Ұ����ֵ��������ʾ
 * @author lcj
 *
 */
public class Example9_9 {
	public static void main(String[] args) {
		WindowDocument win = new WindowDocument();
	}
}

class WindowDocument extends JFrame{
	JTextArea inputText,showText;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem itemCopy,itemCut,itemPaste;
	TextListener textChangeListener;
	HandleListener handleListener;
	
	public WindowDocument() {
		init();
		setLayout(new FlowLayout());
		setBounds(100,100,590,500);
		setTitle("������~");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	void init(){
		inputText = new JTextArea(15,20);
		showText = new JTextArea(15, 20);
		showText.setLineWrap(true); //�ı��Զ�����
		showText.setWrapStyleWord(true); //�ı����Ե���Ϊ���Զ�����
		menubar = new JMenuBar();
		menu = new JMenu("�༭");
		itemCopy = new JMenuItem("����(C)");
		itemCut = new JMenuItem("����(T)");
		itemPaste = new JMenuItem("ճ��(P)");
		itemCopy.setAccelerator(KeyStroke.getKeyStroke('c'));
		itemCut.setAccelerator(KeyStroke.getKeyStroke('t'));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke('p')); //���ÿ�ݷ�ʽ
		itemCopy.setActionCommand("copy");
		itemCut.setActionCommand("cut");
		itemPaste.setActionCommand("paste");
		
		menu.add(itemCopy);
		menu.add(itemCut);
		menu.add(itemPaste);
		menubar.add(menu);
		setJMenuBar(menubar);
		add(new JScrollPane(inputText));
		add(new JScrollPane(showText));
		
		textChangeListener = new TextListener();
		handleListener = new HandleListener();
		textChangeListener.setInputText(inputText);
		textChangeListener.setShowText(showText);
		handleListener.setInputText(inputText);
		handleListener.setShowText(showText);
		(inputText.getDocument()).addDocumentListener(textChangeListener);
		itemCopy.addActionListener(handleListener);
		itemCut.addActionListener(handleListener);
		itemPaste.addActionListener(handleListener);
		
	}
}


class TextListener implements DocumentListener {
	
	JTextArea inputText,showText;
	
	public void setInputText(JTextArea text){
		inputText = text;
	}
	public void setShowText(JTextArea text){
		inputText = text;
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		String str = inputText.getText();
		String regex = "[\\s\\d\\p{Punct}]+";
		String words[] = str.split(regex);
		Arrays.sort(words);
		
		showText.setText("");
		for(int i=0;i<words.length;i++){
			showText.append(words[i]+",");
		}
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		changedUpdate(e);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		changedUpdate(e);
		
	}

	
	
}

class HandleListener implements ActionListener {
	JTextArea inputText,showText;
	public void setInputText(JTextArea text){
		inputText = text;
	}
	public void setShowText(JTextArea text){
		inputText = text;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("copy")) showText.copy();
		else if(str.equals("cut")) showText.cut();
		else if(str.equals("paste")) showText.paste();
		
	}
	
}
