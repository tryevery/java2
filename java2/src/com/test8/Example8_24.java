package com.test8;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;

public class Example8_24 {
	public static void main(String[] args) {
		String mess = null;
		Scanner s = new Scanner(System.in);
		System.out.println("s�����ʽ������ ����1 ����2 ����3");
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
			System.out.println(name+"�ܳɼ�"+sum);
			System.out.println("\t����end����ͳ��\n");
			mess = s.nextLine();
		}
	}
}
