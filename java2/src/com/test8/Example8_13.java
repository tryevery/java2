package com.test8;

import java.util.Scanner;

/**
 * 测试Scanner的分割功能 P192
 * @author lcj
 *
 */
public class Example8_13 {
	public static void main(String[] args) {
		/*String cost  = "Tv cost 876 .Computer cost 4343 .telephone cost 678678";
		Scanner s = new Scanner(cost);
		double sum = 0;
		while(s.hasNext()){
			try {
				double price = s.nextDouble();
				sum = sum + price;
				System.out.println(price);
			} catch (Exception e) {
				String t = s.next();
			}
		}
		System.out.println(sum);*/
		test();
	}
	
	public static void test(){
		String cost  = "Tv cost 876 .Computer cost 4343 .telephone cost 678678";
		Scanner s = new Scanner(cost);
		s.useDelimiter("[^0-9.]+");
		double sum = 0;
		while(s.hasNext()){
			try {
				double price = s.nextDouble();
				sum = sum + price;
				System.out.println(price);
			} catch (Exception e) {
				String t = s.next();
			}
		}
		System.out.println(sum);
	}
}
