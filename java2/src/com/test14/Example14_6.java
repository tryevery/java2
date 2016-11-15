package com.test14;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * 薄播放音频文件
 * @author lcj
 *
 */
public class Example14_6 {
	public static void main(String[] args) {
		AudioClipDialog dialog = new AudioClipDialog();
		dialog.setVisible(true);
	}
}

class AudioClipDialog extends JDialog implements Runnable,ItemListener,ActionListener{
	Thread thread;
	JComboBox choiceMusic;
	AudioClip clip;
	JButton buttonPlay,buttonLoop,buttonStop;
	String str;
	public AudioClipDialog() {
		thread = new Thread(this);
		choiceMusic = new JComboBox();
		choiceMusic.addItem("选择音频文件");
		choiceMusic.addItem("ding.wav");
		choiceMusic.addItem("notify.wav");
		choiceMusic.addItem("online.wav");
		choiceMusic.addActionListener(this);
		buttonPlay = new JButton("播放");
		buttonLoop = new JButton("循环");
		buttonStop = new JButton("停止");
		buttonLoop.addActionListener(this);
		buttonPlay.addActionListener(this);
		buttonStop.addActionListener(this);
		setLayout(new FlowLayout());
		add(choiceMusic);
		add(buttonPlay);
		add(buttonLoop);
		add(buttonStop);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(350,120);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonPlay){
			clip.play();
		}
		else if(e.getSource()==buttonLoop){
			clip.loop();
		}
		else if(e.getSource()==buttonStop){
			clip.stop();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		str = choiceMusic.getSelectedItem().toString();
		if(!(thread.isAlive())){
			thread = new Thread(this);
		}
		thread.start();
	}

	@Override
	public void run() {
		try {
			File file = new File(str);
			URI uri = file.toURI();
			URL url = file.toURL();
			clip = Applet.newAudioClip(url);
		} catch (Exception e) {
		}
		
	}
	
}