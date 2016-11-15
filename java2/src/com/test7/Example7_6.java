package com.test7;
/**
 * 这是一个测试断言assert的例子
 * P170
 * 注意：java中默认关闭断言语句，需要用java -ea mainClass 来启用断言
 * @author lcj
 *
 */
public class Example7_6 {
	public static void main(String[] args) {
		int []score = {98,76,76,45,434,323};
		int sum = 0;
		for(int number : score){
			assert number>=0:"负数不可能是成绩";
			sum = sum + number;
		}
		System.out.println(sum);
	}
}
