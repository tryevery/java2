package com.test10;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * Scannerʹ��������ʽ��Ϊ�ָ����
 * @author lcj
 *
 */
public class Example10_16 {
	public static void main(String[] args) {
		File file = new File("student.txt");
		try {
			
			FileOutputStream out = new FileOutputStream(file);
			byte []a = "�����ɼ�Ϊ72,���ĳɼ�Ϊ85,lcj�ɼ�Ϊ100".getBytes();
			out.write(a, 0, a.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Scanner s = null;
		int count = 0;
		double sum = 0;
		try {
			double score = 0;
			s = new Scanner(file);
			s.useDelimiter("[^0-9.]+");
			while(s.hasNext()){
				score = s.nextDouble();
				count++;
				sum += score;
				System.out.println(score);
			}
			
			double aver = sum / count;
			System.out.println("ƽ���ɼ�:"+aver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
