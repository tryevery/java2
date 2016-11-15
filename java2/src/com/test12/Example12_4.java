package com.test12;

/**
 * Thread �ഴ������ģ��è�͹���ˮ���߳�(�����)
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
	int waterAmount;  //ģ��ˮ������
	Thread dog,cat;
	public House1() {
		dog = new Thread(this); //��ǰHouse������Ϊ�̵߳�Ŀ�����
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
				System.out.println("����ˮ");
				waterAmount = waterAmount-2;
			}else if(name==cat){
				System.out.println("è��ˮ");
				waterAmount = waterAmount-1;
			}
			
			System.out.println(" ʣ "+waterAmount);
			try {
				Thread.sleep(2000); //���ʱ��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(waterAmount<=0){
				return;
			}
		}
	}
	
}
