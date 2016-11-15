package com.test12;

/**
 * ʹ�� Thread �����ഴ���߳�
 * �����Ӳ����̵߳�����״̬
 * @author lcj
 *
 */
public class Example12_1 {
	public static void main(String[] args) {
		SpeakElephant elephant = new SpeakElephant();
		SpeakCar car = new SpeakCar();
		elephant.start();//���������߳�
		try {
			elephant.sleep(1000); //�߳�����
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		car.start();     //�����γ��߳�
		for(int i=1;i<=15;i++){
			System.out.println("����"+i+"  ");
		}
	}
}

class SpeakElephant extends Thread {
	public void run(){
		for(int i=1;i<=20;i++){
			System.out.println("����"+i+"  ");
		}
	}
}

class SpeakCar extends Thread {
	public void run(){
		for(int i=1;i<=20;i++){
			System.out.println("�γ�"+i+"  ");
		}
	}
}
