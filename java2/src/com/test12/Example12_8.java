package com.test12;

/**
 * Э��ͬ�����߳�,ģ����Ʊ
 * @author lcj
 *
 */
public class Example12_8 {
	public static void main(String[] args) {
		TicketHouse house = new TicketHouse();
		Thread zhangfei,lisi;
		zhangfei = new Thread(house);
		zhangfei.setName("�ŷ�");
		lisi = new Thread(house);
		lisi.setName("����");
		zhangfei.start();
		lisi.start();
	}
}

class TicketHouse implements Runnable {
	int fiveAmount = 2,tenAmount = 0,twentyAmount = 0;
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("�ŷ�")){
			saleTicket(20);
		}
		else if(Thread.currentThread().getName().equals("����")){
			saleTicket(5);
		}
		
	}
	
	private synchronized void saleTicket(int money){
		if(money ==5 ){
			fiveAmount = fiveAmount+1;
			System.out.println("��"+Thread.currentThread().getName()+"�볡��,"+Thread.currentThread().getName()+"��Ǯ����");
		}
		else if(money ==20 ){
			while(fiveAmount<3){
				try {
					System.out.println("\n"+Thread.currentThread().getName()+"���ߵ�");
					wait();
					System.out.println("\n"+Thread.currentThread().getName()+"������Ʊ");
					
				} catch (InterruptedException e) {
				}
			}
			fiveAmount = fiveAmount-3;
			twentyAmount = twentyAmount+1;
			System.out.println("��"+Thread.currentThread().getName()+"�볡��,"+Thread.currentThread().getName()+"��20����15");	
		}
		notifyAll();
	}
	
}
