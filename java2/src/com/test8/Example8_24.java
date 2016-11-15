package com.test8;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

public class Example8_24 {
	public static void main(String[] args) {
		String mess = null;
		Scanner s = new Scanner(System.in);
		System.out.println("s输入格式：姓名 分数1 分数2 分数3");
		mess = s.nextLine();
		String name = "";
		double sum = 0;
		while(!mess.startsWith("end")){
			Scanner scanner = new Scanner(mess);
			sum = 0;
			while(scanner.hasNext()){
				try {
					double score = scanner.nextDouble();
					sum = sum + score;
				} catch (InputMismatchException exp) {
					name = scanner.next();
				}
			}
			System.out.println(name+"总成绩"+sum);
			System.out.println("\t输入end结束统计\n");
			mess = s.nextLine();
		}
	}
}
