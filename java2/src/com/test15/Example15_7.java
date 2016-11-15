package com.test15;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * 散列映射  HashMap<K,V>
 * @author lcj
 *
 */
public class Example15_7 {
	public static void main(String[] args) {
		WindowWord win = new WindowWord();
		win.setTitle("英汉小词典");
	}

}

class WindowWord extends JFrame {
	JTextField inputText,showText;
	WordPolice police;
	public WindowWord() {
		setLayout(new FlowLayout());
		inputText = new JTextField(6);
		showText = new JTextField(6);
		add(inputText);
		add(showText);
		police = new WordPolice();
		police.setJTextField(showText);
		inputText.addActionListener(police);
		setBounds(100, 100, 400, 280);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class WordPolice implements ActionListener{
	JTextField showText;
	HashMap<String, String> hashtable;
	File file = new File("image/word.txt");
	Scanner s = null;
	public WordPolice() {
		hashtable = new HashMap<String,String>();
		try {
			s = new Scanner(file);
			while(s.hasNext()){
				String englishWord = s.next();
				String chineseWrod = s.next();
				hashtable.put(englishWord, chineseWrod);
			}
		} catch (Exception e) {
		}
	}
	
	public void setJTextField(JTextField showText){
		this.showText = showText;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String englishWord = e.getActionCommand();
		if(hashtable.containsKey(englishWord)){
			String chineseWrod = hashtable.get(englishWord);
			showText.setText(chineseWrod);
		}else showText.setText("没有次单词");
	}
	
}