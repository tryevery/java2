package com.test12;


/**
 * �߳����� join()
 * ģ�⵰��ʱ��������
 * @author lcj
 *
 */
public class Example12_9 {
	public static void main(String[] args) {
		ThreadJoin a = new ThreadJoin();
		Thread customer = new Thread(a);
		Thread cakeMaker = new Thread(a);
		customer.setName("�˿�");
		cakeMaker.setName("����");
		a.setJoinThread(cakeMaker);
		customer.start();
	}
}

class ThreadJoin implements Runnable{
	Cake cake;
	Thread joinThread;
	public void setJoinThread(Thread t){
		joinThread = t;
	}
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("�˿�")){
			System.out.println(Thread.currentThread().getName()+"�ȴ�"+joinThread.getName()+"�������յ���");
			try {
				joinThread.start();
				joinThread.join();
			} catch (InterruptedException e) {
			}
			System.out.println(Thread.currentThread().getName()+"����"+cake.name+" ��Ǯ"+cake.price);
		}
		else if(Thread.currentThread()==joinThread){
			System.out.println(joinThread.getName()+"��ʼ�������յ���,���...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			cake = new Cake("���յ���", 158);
			System.out.println(joinThread.getName()+"�������");
		}
	}
	//�ڲ���
	class Cake {
		int price;
		String name;
		Cake(String name,int price){
			this.name = name;
			this.price = price;
		}
	}
}
