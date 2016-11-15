package com.test8;

import java.util.Arrays;



public class Example8_2 {
	public static void sort(String []a){
		int count = 0;
		for(int i=0;i<=a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if(a[j].compareTo(a[i])<0){
					String temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String []a = {"melon","apple","pear","banana"};
		String []b = {"Î÷¹Ï","Æ»¹û","Àæ×Ó","Ïã½¶"};
		sort(a);
		for(String i:a){
			System.out.print("  "+i);
		}
		System.out.println();
		Arrays.sort(b);
		for(String i:b){
			System.out.print("  "+i);
		}
	}
}
