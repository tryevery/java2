package com.test7;

/**
 * 这是一个测试和子类有关的匿名内部类的例子
 * P165
 * @author lcj
 *
 */
abstract class OutputAlphabet{
	public abstract void output();
}

class OutputEnglish extends OutputAlphabet{

	@Override
	public void output() {
		for(int i=97;i<123;i++){
			System.out.printf("%3c",i);
		}
		
	}
	
}

class ShowBoard{
	void showMess(OutputAlphabet show){ //参数show 是OutputAlphabet类型的对象
		show.output();
	}
}

public class Example7_2 {
	public static void main(String[] args) {
		ShowBoard board = new ShowBoard();
		board.showMess(new OutputEnglish()); //向参数传递OutputAlphable的子类
		System.out.println();
		board.showMess(new OutputAlphabet() {
			
			@Override
			public void output() {
				for(char i='α';i<='ω';i++){
					System.out.printf("%3c",i);
				}
			}
		});
	}
}
