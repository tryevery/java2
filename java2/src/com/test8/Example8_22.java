package com.test8;

import java.util.Date;

class Rect{
	double width,height,area;
	public double getArea(){
		area = height*width;
		return area;
	}
}

public class Example8_22 {
	public static void main(String[] args) {
		try {
			Class cs = Class.forName("com.test8.Rect"); //�õ�Rect��class����
			Rect rect = (Rect) cs.newInstance(); //ʵ����Rect����
			rect.width = 100;
			rect.height = 20;
			System.out.println("�����"+rect.getArea());
			System.out.println(rect.getClass());
			cs = Class.forName("java.util.Date");
			Date date = (Date) cs.newInstance();
			System.out.println(date.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}


