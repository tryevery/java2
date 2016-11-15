package com.test7;
/**
 * ����һ�������Զ����쳣�������
 * P169
 * @author lcj
 *
 */

class BankException extends Exception{
	String message;
	public BankException(int m,int n){
		message = "�����ʽ�"+m+"�Ǹ�����֧��"+n+"��������������ϵͳҪ��";
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
		System.out.printf("���μ�����Ĵ������ǣ�%dԪ\n",netIncome);
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
			System.out.printf("����Ŀǰ��%dԪ\n",bank.getMoney());
			bank.income(200, 100);
			bank.income(999900, 100);
			
		} catch (BankException e) {
			System.out.println("��������Ĺ����г����������⣺");
			System.out.println(e.warnMess());
		}
		System.out.printf("����Ŀǰ��%dԪ\n",bank.getMoney());
	}
}
