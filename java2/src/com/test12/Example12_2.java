package com.test12;


/**
 * ʹ��Thread�����߳�
 * �������߳�˳����,��ִ����main�߳��е�,Ȼ����ִ�����߳�
 * @author lcj
 *
 */
public class Example12_2 {
	public static void main(String[] args) {
		Thread speakElephant,speakCar;
		ElephantTarget elephanttarget = new ElephantTarget();
		CarTarget carTarget = new CarTarget();
		speakElephant = new Thread(elephanttarget);
		speakCar = new Thread(carTarget);
		speakCar.start();
		speakElephant.start();
		for(int i=1;i<=15;i++){
			System.out.println("����"+i+"  ");
		}
	}
}

class ElephantTarget implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("����"+i+"  ");
		}
		
	}
	
}
class CarTarget implements Runnable {
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("�γ�"+i+"  ");
		}
		
	}
	
}
