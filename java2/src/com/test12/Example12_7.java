package com.test12;


/**
 * 线程同步
 * 会计和出纳共同有一个账本,
 * 都不可以对工资进行操作,saveOrTake(int amount)方法应该是一个synchronized方法
 * @author lcj
 *
 */
public class Example12_7 {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setMonry(200);
		Thread account,cashier;//会计和出纳
		account = new Thread(bank);
		account.setName("会计");
		cashier = new Thread(bank);
		cashier.setName("出纳");
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
		if(Thread.currentThread().getName().equals("会记"))
			saveOrTake(300);
		else if(Thread.currentThread().getName().equals("出纳"))
			saveOrTake(150);
	}
	
	public void saveOrTake(int amount){ //存取方法
		if(Thread.currentThread().getName().equals("会计")){
			for(int i=1;i<=3;i++){
				money += amount/3; //没存amount/3歇息以下
				System.out.println(Thread.currentThread().getName()+"存入"+amount/3+",账上有"+money+"万,休息一会在存");
				try {
					Thread.sleep(1000); //这时出纳不能使用该方法
				} catch (InterruptedException e) {
				}
			}
		}
		else if(Thread.currentThread().getName().equals("出纳")){
			for(int i=1;i<=3;i++){ //出纳使用存取方法取出150
				money -= amount/3;//每取amount/3歇息以下
				System.out.println(Thread.currentThread().getName()+"取出"+amount/3+",账上有"+money+"万,休息一会在取");
				try {
					Thread.sleep(1000); //这时会计不能使用该方法
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
}
