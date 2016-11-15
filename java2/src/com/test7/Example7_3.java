package com.test7;

/**
 * 这是一个测试和接口有关的匿名内部类的例子
 * P166
 * @author lcj
 *
 */

interface SpeakHello {
	void speak();
}

class HelloMachine{
	public void turnOn(SpeakHello hello){
		hello.speak();
	}
}

public class Example7_3 {
	public static void main(String[] args) {
		HelloMachine machine = new HelloMachine();
		machine.turnOn(new SpeakHello() { //和接口speak有关的匿名内部类
			
			@Override
			public void speak() {
				System.out.println("hello you are welcome");
			}
		});
		machine.turnOn(new SpeakHello() {  //和接口speak有关的匿名内部类
			
			@Override
			public void speak() {
				System.out.println("你好");
			}
		});
		
	}
}
