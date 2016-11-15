package com.test6;


interface ComputerAverage{
	double average(double a,double b);
}

class A implements ComputerAverage{

	@Override
	public double average(double a, double b) {
		double aver = 0;
		aver = (a+b)/2;
		return aver;
	}
	
}
class B implements ComputerAverage{
	
	@Override
	public double average(double a, double b) {
		double aver = 0;
		aver = Math.sqrt(a*b);
		return aver;
	}
	
}
public class Example6_4 {
	public static void main(String[] args) {
		ComputerAverage comp;
		double a = 11.23,b = 22.78;
		comp = new A();
		double result = comp.average(a, b);
		System.out.println(result);
		comp = new B();
		double result1 = comp.average(a, b);
		System.out.println(result1);
		
	}
}
