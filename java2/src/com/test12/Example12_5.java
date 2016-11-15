package com.test12;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Ϊһ��Ӧ����ʵ����߳��ٴη���ʵ��,
 * ��ԭ����ʵ��������ʵ��,���ǲ��ᱻgc����,����������
 * @author lcj
 *
 */
public class Example12_5 {
	public static void main(String[] args) {
		Home home = new Home();
		Thread showTime = new Thread(home);
		showTime.start();
	}
}


class Home implements Runnable {
	int time = 0;
	SimpleDateFormat m = new SimpleDateFormat("HH:mm:ss");
	Date date;
	@Override
	public void run() {
		while(true){
			date = new Date();
			System.out.println(m.format(date));
			time++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(time==3){
				Thread thread = Thread.currentThread();
				thread = new Thread(this);
				thread.start();
			}
		}
	}
	
}
