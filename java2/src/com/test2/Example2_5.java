package com.test2;

import java.util.Scanner;

public class Example2_5 {
	public static int[] sort(int []a){
		int n = a.length;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(a[j]<a[i]){
					int t = a[j];
					a[j] = a[i];
					a[i] = t;
				}
			}
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int number = s.nextInt();
		int count = 0;
		int start = 0;
		int b[] = {12,23,45,56,76,343,3434,232};
		int a[] = sort(b);
		int end = a.length;
		int middle = (start+end)/2;
		while(number!=a[middle]){
			if(number>a[middle]){
				start = middle;
			}
			else if(number<a[middle]){
				end = middle;
			}
			middle = (start+end)/2;
			count++;
			if(count>a.length/2) break;
		}
		
		if(count>a.length/2){
			System.out.println("buzaishuzuzhong");
		}else{
			System.out.println("zaishuzuzhong");
		}
	}
	
}
