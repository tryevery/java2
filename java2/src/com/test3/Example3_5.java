package com.test3;
/**
 * 计算8+88+888...的前12项的和
 * @author lcj
 *
 */
public class Example3_5 {
	public static void main(String[] args) {
		long sum = 0,a=8,item=8;
		for(int i=1;i<=12;i++){
			sum = sum+item;
			item = item*10+a;
		}
		System.out.println(sum);
	}
}	
