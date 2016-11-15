package com.test3;
/**
 * 计算1+1/!2+1/!3+1/!4+...前20项的和
 * @author lcj
 *
 */
public class Example3_6 {
	public static void main(String[] args) {
		/*double sum = 0;
		double item = 1;
		int i = 1;
		while(i<=20){
			sum = sum + item;
			i=i+1;
			item = item*(1.0/i);
		}
		
		System.out.println(sum);*/
		sum();
	}
	/**
	 *计算1！+2！+。。。+10！
	 */
	public static void sum(){
		long sum = 0,item = 1;
		for(int i=1;i<=3;i++){
			item = item*i;
			sum = sum + item;
		}
		System.out.println(sum);
	}
}
