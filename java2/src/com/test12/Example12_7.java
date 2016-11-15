package com.test12;


/**
 * �߳�ͬ��
 * ��ƺͳ��ɹ�ͬ��һ���˱�,
 * �������ԶԹ��ʽ��в���,saveOrTake(int amount)����Ӧ����һ��synchronized����
 * @author lcj
 *
 */
public class Example12_7 {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setMonry(200);
		Thread account,cashier;//��ƺͳ���
		account = new Thread(bank);
		account.setName("���");
		cashier = new Thread(bank);
		cashier.setName("����");
		cashier.start();
		account.start();
	}
}

class Bank implements Runnable {
	int money = 200;
	public void setMonry(int n){
		money = n;
	}
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("���"))
			saveOrTake(300);
		else if(Thread.currentThread().getName().equals("����"))
			saveOrTake(150);
	}
	
	public void saveOrTake(int amount){ //��ȡ����
		if(Thread.currentThread().getName().equals("���")){
			for(int i=1;i<=3;i++){
				money += amount/3; //û��amount/3ЪϢ����
				System.out.println(Thread.currentThread().getName()+"����"+amount/3+",������"+money+"��,��Ϣһ���ڴ�");
				try {
					Thread.sleep(1000); //��ʱ���ɲ���ʹ�ø÷���
				} catch (InterruptedException e) {
				}
			}
		}
		else if(Thread.currentThread().getName().equals("����")){
			for(int i=1;i<=3;i++){ //����ʹ�ô�ȡ����ȡ��150
				money -= amount/3;//ÿȡamount/3ЪϢ����
				System.out.println(Thread.currentThread().getName()+"ȡ��"+amount/3+",������"+money+"��,��Ϣһ����ȡ");
				try {
					Thread.sleep(1000); //��ʱ��Ʋ���ʹ�ø÷���
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
}
