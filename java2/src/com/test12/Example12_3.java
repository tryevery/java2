package com.test12;


/**
 * Thread �ഴ������ģ��è�͹���ˮ���߳�(��ȫ����)
 * @author lcj
 *
 */
public class Example12_3 {
	public static void main(String[] args) {
		House house = new House();
		house.setWater(10);
		Thread dog,cat;
		dog = new Thread(house); //dog��cat��Ŀ�������ͬ
		cat = new Thread(house); //dog��cat��Ŀ�������ͬ
		dog.setName("��");
		cat.setName("è");
		dog.start();
		cat.start();
	}
}


class House implements Runnable {
	int waterAmount;  //ģ��ˮ������
	public void setWater(int w){
		waterAmount = w;
	}
	
	@Override
	public void run() {
		while(true){
			String name = Thread.currentThread().getName();
			if(name.equals("��")){
				System.out.println(name+"��ˮ");
				waterAmount = waterAmount-2;
			}else if(name.equals("è")){
				System.out.println(name+"��ˮ");
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