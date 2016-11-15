package com.test15;

/**
 * ����һ��������������
 * E û��ָ���Ǻ������͵�����,�������κνӿڻ����,�������ǻ�����������,Ҳ���Բ���E��ʾ
 * @author lcj
 *
 */
public class Example15_1 {
	public static void main(String[] args) {
		Circle c = new Circle(10);
		Cone<Circle> cone = new Cone<Circle>(c);//����һ��Բ׶����
		cone.setHeight(10);
		System.out.println(cone.computerVolume());
		Rect rect = new Rect(1, 5);
		Cone<Rect> cone1 = new Cone<Rect>(rect); //����һ����׶����
		cone1.setHeight(98);
		System.out.println(cone1.computerVolume());
	}
}

class Cone<E> {
	double height;
	E button;
	public Cone(E b) {
		button = b;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double  computerVolume() {
		String s = button.toString();
		double area = Double.parseDouble(s);
		return 1.0/3.0*area*height;
	}
}

class Rect {
	double sideA,sideB,area;
	public Rect(double a,double b) {
		sideA = a;
		sideB = b;
	}
	
	public String toString(){   //��дtoString()����
		area = sideA*sideB;
		return ""+area;
	}
}

class Circle {
	double area,redius;
	public Circle(double r) {
		redius = r;
	}
	public String toString(){
		area = Math.PI*redius*redius;
		return ""+area;
	}
}
