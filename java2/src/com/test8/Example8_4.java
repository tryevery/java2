package com.test8;
/**
 * main�����еĲ������ԴӼ��̽�������
 * ��Ҫ��cmd����������ʱ�ں���ո���ϲ�������
 * @author lcj
 *
 */
public class Example8_4 {
	public static void main(String[] args) {
		double aver = 0,sum = 0,item = 0;
		boolean computable = true;
		for(String s : args){
			try{item = Double.parseDouble(s);
				sum = sum + item;
			}catch(NumberFormatException e){
				System.out.println("�������˷Ƿ�����");
				computable = false;
			}
		if(computable){
			System.out.println(sum);
		}
		}
	}
}
