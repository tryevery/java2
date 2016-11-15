package com.test5;


/**
 * ����һ��������������̵�һ������
 * ���� p132
 * @author lcj
 *
 */
public class Pillar{
	Geometry bottom;
	double height;
	Pillar(Geometry bottom,double height) {
		this.height = height;
		this.bottom = bottom;
	}
	
	public double getVolume(){
		return bottom.getArea()*height;
	}
	
	public static void main(String[] args) {
		Pillar pillar;
		Geometry bottom;
		bottom = new Rectangle(12, 22);
		pillar = new Pillar(bottom, 58);
		System.out.println("���ε׵�Բ�������"+pillar.getVolume());
		bottom = new Circle(10);
		pillar = new Pillar(bottom, 58);
		System.out.println("Բ�ε׵�Բ�������"+pillar.getVolume());
	}
	
}

class Circle extends Geometry{
	
	double r;
	public Circle(double r) {
		this.r = r;
	}
	@Override
	public double getArea() {
		return 3.14*r*r;
	}
	
}

class Rectangle extends Geometry{
	double a,b;
	public Rectangle(double a,double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public double getArea() {
		return a*b;
	}
	
}
