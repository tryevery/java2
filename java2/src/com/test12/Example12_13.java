package com.test12;

/**
 * �ػ��߳�
 * @author lcj
 *
 */
public class Example12_13 {
	public static void main(String[] args) {
		Daemon d = new Daemon();
		d.A.start();
		d.B.setDaemon(true);
		d.B.start();
	}
}

class Daemon implements Runnable {
	Thread A,B;
	public Daemon() {
		A = new Thread(this);
		B = new Thread(this);
	}
	@Override
	public void run() {
		if(Thread.currentThread()==A){
			for(int i=0;i<8;i++){
				System.out.println("i="+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else if(Thread.currentThread()==B){
			while(true){
				System.out.println("�߳�B���ػ��߳�");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
