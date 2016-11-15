package com.test10;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * 使用scanner解析文件
 * @author lcj
 *
 */
public class Example10_15 {
	public static void main(String[] args) {
		File file = new File("cost.txt");
		try {
			
			FileOutputStream out = new FileOutputStream(file);
			byte []a = "The television cost 1867 dollar.The milk cost 98 dollar.The apple cost 68 dollar".getBytes();
			out.write(a, 0, a.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Scanner s = null;
		int sum = 0;
		try {
			s = new Scanner(file);
			while(s.hasNext()){
				try {
					int price = s.nextInt();
					sum += price;
					System.out.println(price);
				} catch (Exception e) {
					String t = s.next();
				}
			}
			System.out.println("Total Cost:" + sum);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
