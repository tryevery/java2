package com.test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ����Arrays�ľ�̬�������������������Arrays.binarySearch(a, num);�ҳ��������Ƿ������Ԫ��
 * @author lcj
 *
 */
public class Example4_11 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int []a = {12,23,434,545,65,657,4,767};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("���������������жϸ������Ƿ��������У�");
		int num = s.nextInt();
		int index = Arrays.binarySearch(a, num);
		if(index > 0){
			System.out.println(num+"������������Ϊ"+index+"Ԫ����ͬ");
		}else System.out.println(index);
	}
}
