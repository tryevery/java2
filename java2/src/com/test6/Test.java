package com.test6;

public class Test {
	public static void main(String[] args) {
		China zhang;
		Japan henlu;
		zhang = new China();
		henlu = new Japan();
		zhang.number = 32+Computer.MAX;
		henlu.number = 14 + Computer.MAX;
		System.out.println("张的学号："+zhang.number+"张的求和结果："+zhang.f(100));
		System.out.println("henlu的学号："+henlu.number+"henlu的求和结果："+henlu.f(100));
		
		/**
		 * 测试接口的回调
		 */
		
		/*China a = new China();
		Computer c =a; */
		Computer c = new China();//匿名对象
		//声明了一个接口变量
		//c变量可以调用类实现的接口方法，但是不可以调用类中其他的非接口方法
		System.out.println(c.f(0));
	}
}
