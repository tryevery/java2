package com.test12;

/**
 * 使用 Thread 的子类创建线程
 * 该例子阐述线程的四种状态
 * @author lcj
 *
 */
public class Example12_1 {
	public static void main(String[] args) {
		SpeakElephant elephant = new SpeakElephant();
		SpeakCar car = new SpeakCar();
		elephant.start();//启动大象线程
		try {
			elephant.sleep(1000); //线程休眠
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		car.start();     //启动轿车线程
		for(int i=1;i<=15;i++){
			System.out.println("主人"+i+"  ");
		}
	}
}

class SpeakElephant extends Thread {
	public void run(){
		for(int i=1;i<=20;i++){
			System.out.println("大象"+i+"  ");
		}
	}
}

class SpeakCar extends Thread {
	public void run(){
		for(int i=1;i<=20;i++){
			System.out.println("轿车"+i+"  ");
		}
	}
}
