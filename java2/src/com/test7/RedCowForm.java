package com.test7;

/**
 * ����һ���ڲ��������
 * P162
 * @author lcj
 *
 */
public class RedCowForm {
	static String formName;
	RedCow cow;   //�ڲ������
	public RedCowForm() {
	}
	public RedCowForm(String s){
		cow = new RedCow(150, 112, 9000);
		formName = s;
	}
	public void showMessage(){
		cow.speak();
	}
	
	class RedCow {  //�ڲ��������
		String cowName = "��ţ";
		int height,weight,price;
		RedCow(int h,int w,int p){
			height = h;
			weight = w;
			price = p;
		}
		
		void speak(){
			System.out.println("���ǣ�"+cowName+"��ߣ�"+height+"���أ�"+weight+"�����ڣ�"+formName);
		}
	}
	
}
