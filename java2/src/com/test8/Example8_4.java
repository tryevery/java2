package com.test8;
/**
 * main方法中的参数可以从键盘接受数字
 * 需要在cmd窗口中运行时在后面空格加上参数运行
 * @author lcj
 *
 */
public class Example8_4 {
	public static void main(String[] args) {
		double aver = 0,sum = 0,item = 0;
		boolean computable = true;
		for(String s : args){
			try{item = Double.parseDouble(s);
				sum = sum + item;
			}catch(NumberFormatException e){
				System.out.println("您输入了非法数字");
				computable = false;
			}
		if(computable){
			System.out.println(sum);
		}
		}
	}
}
