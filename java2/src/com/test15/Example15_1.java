package com.test15;

/**
 * 声明一个泛型类计算面积
 * E 没有指定是何种类型的数据,可以是任何接口或对象,但不能是基本数据类型,也可以不用E表示
 * @author lcj
 *
 */
public class Example15_1 {
	public static void main(String[] args) {
		Circle c = new Circle(10);
		Cone<Circle> cone = new Cone<Circle>(c);//创建一个圆锥对象
		cone.setHeight(10);
		System.out.println(cone.computerVolume());
		Rect rect = new Rect(1, 5);
		Cone<Rect> cone1 = new Cone<Rect>(rect); //创建一个方锥对象
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
	
	public String toString(){   //重写toString()方法
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
