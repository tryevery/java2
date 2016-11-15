package com.test7;

/**
 * 这是一个内部类的例子
 * P162
 * @author lcj
 *
 */
public class RedCowForm {
	static String formName;
	RedCow cow;   //内部类对象
	public RedCowForm() {
	}
	public RedCowForm(String s){
		cow = new RedCow(150, 112, 9000);
		formName = s;
	}
	public void showMessage(){
		cow.speak();
	}
	
	class RedCow {  //内部类的声明
		String cowName = "红牛";
		int height,weight,price;
		RedCow(int h,int w,int p){
			height = h;
			weight = w;
			price = p;
		}
		
		void speak(){
			System.out.println("我是："+cowName+"身高："+height+"体重："+weight+"生活在："+formName);
		}
	}
	
}
