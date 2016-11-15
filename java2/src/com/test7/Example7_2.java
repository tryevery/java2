package com.test7;

/**
 * ����һ�����Ժ������йص������ڲ��������
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
	void showMess(OutputAlphabet show){ //����show ��OutputAlphabet���͵Ķ���
		show.output();
	}
}

public class Example7_2 {
	public static void main(String[] args) {
		ShowBoard board = new ShowBoard();
		board.showMess(new OutputEnglish()); //���������OutputAlphable������
		System.out.println();
		board.showMess(new OutputAlphabet() {
			
			@Override
			public void output() {
				for(char i='��';i<='��';i++){
					System.out.printf("%3c",i);
				}
			}
		});
	}
}
