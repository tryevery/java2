package com.test6;

public class China implements Computer{
	int number;
	@Override
	public int f(int x) {
		int sum = 0;
		for(int i=1;i<=x;i++){
			sum = sum +i;
		}
		return sum;
	}

}
