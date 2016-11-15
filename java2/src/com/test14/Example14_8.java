package com.test14;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * 用鼠标点击七个按钮,播放相应的音乐
 * @author lcj
 *
 */
public class Example14_8 extends JFrame{
	MusicButton []button ;
	public Example14_8() {
		button = new MusicButton[8];
		setLayout(new GridLayout(1, 7));
		for(int i=1;i<=7;i++){
			button[i] = new MusicButton();
			button[i].setClipFile(i+".wav");
			add(button[i]);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(350, 120);
	}
	
	public static void main(String[] args) {
		new Example14_8();
	}
		
}

class MusicButton extends JButton implements ActionListener {
	String musicName = "1.wav";
	public MusicButton() {
		addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		File file = new File(musicName);
		try {
			URI uri = file.toURI();
			URL url = uri.toURL();
			AudioClip clip = Applet.newAudioClip(url);
			clip.play();
		} catch (Exception e2) {
		}
	}
	
	public void setClipFile(String name){
		musicName = name;
		String t = musicName.substring(0, musicName.indexOf("."));
		setText(""+t);
		int M = JComponent.WHEN_IN_FOCUSED_WINDOW;
		registerKeyboardAction(this, KeyStroke.getKeyStroke(t), M);
	}
	
}
