package com.test7;

interface Com{
	public void speak();
}
class Cry{
	public void cry(){
		System.out.println("��Һ�");
	}
}
public class Example7_1 {
	public static void main(String[] args) {
		RedCowForm form = new RedCowForm("��ţũ��");
		form.showMessage(); //�����������Ե���
		form.cow.speak();
		/*Cry cry = new Cry(){
			public void cry(){
				System.out.println("��Һã�����˳��");
			}
		};
		cry.cry();
		
		Com com = new Com() {
			
			@Override
			public void speak() {
				System.out.println("p�ǽӿڱ���");
			}
		};
		com.speak();*/
	}
}
