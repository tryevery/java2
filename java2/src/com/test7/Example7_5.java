package com.test7;
/**
 * 这是一个测试自定义异常类的例子
 * P169
 * @author lcj
 *
 */

class BankException extends Exception{
	String message;
	public BankException(int m,int n){
		message = "入帐资金"+m+"是负数或支出"+n+"是正数，不符合系统要求";
	}
	
	public String warnMess(){
		return message;
	}
}

class Bank{
	private int money;
	public void income(int in,int out) throws BankException{
		if(in<=0||out>=0||in+out<=0){
			throw new BankException(in, out);
		}
		int netIncome = in + out;
		System.out.printf("本次计算出的纯收入是：%d元\n",netIncome);
		money = money + netIncome;
	}
	
	public int getMoney(){
		return money;
	}
}
public class Example7_5 {
	public static void main(String[] args) {
		Bank bank = new Bank();
		try {
			bank.income(200, -100);
			bank.income(300, -100);
			bank.income(400, -100);
			System.out.printf("银行目前有%d元\n",bank.getMoney());
			bank.income(200, 100);
			bank.income(999900, 100);
			
		} catch (BankException e) {
			System.out.println("计算收益的过程中出现如下问题：");
			System.out.println(e.warnMess());
		}
		System.out.printf("银行目前有%d元\n",bank.getMoney());
	}
}
