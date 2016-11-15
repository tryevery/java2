package com.test12;

/**
 * Thread 类创建两个模拟猫和狗喝水的线程(弱耦合)
 * @author lcj
 *
 */
public class Example12_4 {
	public static void main(String[] args) {
		House1 house = new House1();
		house.setWater(10);
		house.dog.start();
		house.cat.start();
	}
}


class House1 implements Runnable {
	int waterAmount;  //模拟水的数量
	Thread dog,cat;
	public House1() {
		dog = new Thread(this); //当前House对象作为线程的目标对象
		cat = new Thread(this);
	}
	public void setWater(int w){
		waterAmount = w;
	}
	
	@Override
	public void run() {
		while(true){
			Thread name = Thread.currentThread();
			if(name==dog){
				System.out.println("狗喝水");
				waterAmount = waterAmount-2;
			}else if(name==cat){
				System.out.println("猫喝水");
				waterAmount = waterAmount-1;
			}
			
			System.out.println(" 剩 "+waterAmount);
			try {
				Thread.sleep(2000); //间隔时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(waterAmount<=0){
				return;
			}
		}
	}
	
}
