package com.test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 利用Arrays的静态方法排序数组后在利用Arrays.binarySearch(a, num);找出数组中是否有这个元素
 * @author lcj
 *
 */
public class Example4_11 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int []a = {12,23,434,545,65,657,4,767};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("输入整数，程序判断该整数是否在数组中：");
		int num = s.nextInt();
		int index = Arrays.binarySearch(a, num);
		if(index > 0){
			System.out.println(num+"和数组中索引为"+index+"元素相同");
		}else System.out.println(index);
	}
}
