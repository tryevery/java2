package com.test12;


/**
 * Thread 类创建两个模拟猫和狗喝水的线程(完全解耦)
 * @author lcj
 *
 */
public class Example12_3 {
	public static void main(String[] args) {
		House house = new House();
		house.setWater(10);
		Thread dog,cat;
		dog = new Thread(house); //dog和cat的目标对象相同
		cat = new Thread(house); //dog和cat的目标对象相同
		dog.setName("狗");
		cat.setName("猫");
		dog.start();
		cat.start();
	}
}


class House implements Runnable {
	int waterAmount;  //模拟水的数量
	public void setWater(int w){
		waterAmount = w;
	}
	
	@Override
	public void run() {
		while(true){
			String name = Thread.currentThread().getName();
			if(name.equals("狗")){
				System.out.println(name+"喝水");
				waterAmount = waterAmount-2;
			}else if(name.equals("猫")){
				System.out.println(name+"喝水");
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