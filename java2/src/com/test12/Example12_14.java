package com.test12;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Repeatable;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * 应用举例 答题(增加了GUI界面和使用计时器线程来倒计时)
 * 
 * @author lcj
 *
 */
public class Example12_14 {
	public static void main(String[] args) {
		StandardExamInTime win = new StandardExamInTime();
		win.setTitle("限时回答问题");
		win.setTestFile(new File("test.txt"));
		win.setMAX(8);
	}
}

class StandardExamInTime extends JFrame implements ActionListener, ItemListener {
	File testFile;
	int MAX = 8;
	int maxTime = MAX, score = 0;
	Timer timer; // 计时器
	JTextArea showQuestion; // 限时问题
	JCheckBox choiceA, choiceB, choiceC, choiceD; // 复选框
	JLabel showScore, showTime; // 标签
	String currentAnswer; // 答案
	JButton reStart; // 重新开始
	FileReader inOne; // 字节输入流
	BufferedReader inTwo; // 缓冲字节输入流

	public StandardExamInTime() {
		timer = new Timer(1000, this);
		showQuestion = new JTextArea(2, 16);
		setLayout(new FlowLayout());
		showScore = new JLabel("分数" + score);
		showTime = new JLabel(" ");
		add(showTime);
		add(new JLabel("问题:"));
		add(showQuestion);
		choiceA = new JCheckBox("A");
		choiceB = new JCheckBox("B");
		choiceC = new JCheckBox("C");
		choiceD = new JCheckBox("D");
		choiceA.addItemListener(this);
		choiceB.addItemListener(this);  //添加监视器
		choiceC.addItemListener(this);
		choiceD.addItemListener(this);
		add(choiceA);
		add(choiceB);
		add(choiceC);
		add(choiceD);
		add(showScore);
		reStart = new JButton("在做一遍");
		reStart.setEnabled(false);
		add(reStart);
		reStart.addActionListener(this); //添加动作监听器
		setBounds(100, 100, 200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void setMAX(int n) {
		MAX = n;
	}

	public void setTestFile(File f) {
		testFile = f;
		score = 0;
		try {
			inOne = new FileReader(testFile); 
			inTwo = new BufferedReader(inOne);
			ReadOneQuestion(); //读取问题
			reStart.setEnabled(false); //是否可以点击
		} catch (FileNotFoundException e) {
			showQuestion.setText("没有选题");
		}

	}

	public void ReadOneQuestion() {
		showQuestion.setText(null);
		try {
			String s = null;
			while ((s = inTwo.readLine()) != null) {
				if (!s.startsWith("-")) {
					showQuestion.append("\n" + s);
				} else {
					s = s.replaceAll("-", ""); //替换所有的-
					currentAnswer = s;
					break;
				}
			}
			timer.start(); //启动计时器
			if (s == null) {
				inTwo.close(); //关闭流
				reStart.setEnabled(true); //可点击
				showQuestion.setText("题目完毕");
				timer.stop(); //停止计时器
			}
		} catch (IOException e) {
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox box = (JCheckBox) e.getSource();
		String str = box.getText();
		boolean booOne = box.isSelected();
		boolean booTwo = str.compareToIgnoreCase(currentAnswer) == 0; //与答案相同
		if (booOne && booTwo) {
			score++;
			showScore.setText("分数:" + score);
			timer.stop();
			maxTime = MAX;
			ReadOneQuestion();
		}
		box.setSelected(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			showTime.setText("剩下:" + maxTime + "秒");
			maxTime--;
			if (maxTime <= 0) {
				maxTime = MAX;
				ReadOneQuestion();
			}
		} else if (e.getSource() == reStart) {
			setTestFile(testFile);
		}
	}

}
