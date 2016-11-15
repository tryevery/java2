package com.test7;

interface Com{
	public void speak();
}
class Cry{
	public void cry(){
		System.out.println("大家好");
	}
}
public class Example7_1 {
	public static void main(String[] args) {
		RedCowForm form = new RedCowForm("红牛农场");
		form.showMessage(); //这两个都可以调用
		form.cow.speak();
		/*Cry cry = new Cry(){
			public void cry(){
				System.out.println("大家好，工作顺利");
			}
		};
		cry.cry();
		
		Com com = new Com() {
			
			@Override
			public void speak() {
				System.out.println("p是接口变量");
			}
		};
		com.speak();*/
	}
}
