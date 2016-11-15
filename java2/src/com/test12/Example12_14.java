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
 * Ӧ�þ��� ����(������GUI�����ʹ�ü�ʱ���߳�������ʱ)
 * 
 * @author lcj
 *
 */
public class Example12_14 {
	public static void main(String[] args) {
		StandardExamInTime win = new StandardExamInTime();
		win.setTitle("��ʱ�ش�����");
		win.setTestFile(new File("test.txt"));
		win.setMAX(8);
	}
}

class StandardExamInTime extends JFrame implements ActionListener, ItemListener {
	File testFile;
	int MAX = 8;
	int maxTime = MAX, score = 0;
	Timer timer; // ��ʱ��
	JTextArea showQuestion; // ��ʱ����
	JCheckBox choiceA, choiceB, choiceC, choiceD; // ��ѡ��
	JLabel showScore, showTime; // ��ǩ
	String currentAnswer; // ��
	JButton reStart; // ���¿�ʼ
	FileReader inOne; // �ֽ�������
	BufferedReader inTwo; // �����ֽ�������

	public StandardExamInTime() {
		timer = new Timer(1000, this);
		showQuestion = new JTextArea(2, 16);
		setLayout(new FlowLayout());
		showScore = new JLabel("����" + score);
		showTime = new JLabel(" ");
		add(showTime);
		add(new JLabel("����:"));
		add(showQuestion);
		choiceA = new JCheckBox("A");
		choiceB = new JCheckBox("B");
		choiceC = new JCheckBox("C");
		choiceD = new JCheckBox("D");
		choiceA.addItemListener(this);
		choiceB.addItemListener(this);  //��Ӽ�����
		choiceC.addItemListener(this);
		choiceD.addItemListener(this);
		add(choiceA);
		add(choiceB);
		add(choiceC);
		add(choiceD);
		add(showScore);
		reStart = new JButton("����һ��");
		reStart.setEnabled(false);
		add(reStart);
		reStart.addActionListener(this); //��Ӷ���������
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
			ReadOneQuestion(); //��ȡ����
			reStart.setEnabled(false); //�Ƿ���Ե��
		} catch (FileNotFoundException e) {
			showQuestion.setText("û��ѡ��");
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
					s = s.replaceAll("-", ""); //�滻���е�-
					currentAnswer = s;
					break;
				}
			}
			timer.start(); //������ʱ��
			if (s == null) {
				inTwo.close(); //�ر���
				reStart.setEnabled(true); //�ɵ��
				showQuestion.setText("��Ŀ���");
				timer.stop(); //ֹͣ��ʱ��
			}
		} catch (IOException e) {
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox box = (JCheckBox) e.getSource();
		String str = box.getText();
		boolean booOne = box.isSelected();
		boolean booTwo = str.compareToIgnoreCase(currentAnswer) == 0; //�����ͬ
		if (booOne && booTwo) {
			score++;
			showScore.setText("����:" + score);
			timer.stop();
			maxTime = MAX;
			ReadOneQuestion();
		}
		box.setSelected(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			showTime.setText("ʣ��:" + maxTime + "��");
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
