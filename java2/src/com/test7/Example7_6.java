package com.test7;
/**
 * ����һ�����Զ���assert������
 * P170
 * ע�⣺java��Ĭ�Ϲرն�����䣬��Ҫ��java -ea mainClass �����ö���
 * @author lcj
 *
 */
public class Example7_6 {
	public static void main(String[] args) {
		int []score = {98,76,76,45,434,323};
		int sum = 0;
		for(int number : score){
			assert number>=0:"�����������ǳɼ�";
			sum = sum + number;
		}
		System.out.println(sum);
	}
}
