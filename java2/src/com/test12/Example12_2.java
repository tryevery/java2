package com.test12;


/**
 * 使用Thread创建线程
 * 这样的线程顺序是,先执行玩main线程中的,然后在执行子线程
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
			System.out.println("主人"+i+"  ");
		}
	}
}

class ElephantTarget implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("大象"+i+"  ");
		}
		
	}
	
}
class CarTarget implements Runnable {
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			System.out.println("轿车"+i+"  ");
		}
		
	}
	
}
