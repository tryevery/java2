package com.test4;

public class Rational {
	int numerator = 1;
	int denominator = 1;
	void setNumerator(int a){
		int c = f(Math.abs(a),denominator);
		numerator = a/c;
		denominator = denominator/c;
		if(numerator<0&&denominator<0){
			numerator = -numerator;
			denominator = -denominator;
		}
	}
	void setDenominator(int b){ //���÷�ĸ
		int c = f(numerator,Math.abs(b)); //�������Լ��
		numerator = b/c;
		denominator = denominator/c;
		if(numerator<0&&denominator<0){
			numerator = -numerator;
			denominator = -denominator;
		}
	}
	
	int getNumerator(){
		return numerator;
	}
	int getDenominator(){
		return denominator;
	}
	
	int f(int a,int b){ //��a��b�����Լ��
		if(a==0) return 1;
		if(a<b){
			int c = a;
			a = b;
			b = c;
		}
		int r = a%b;
		while(r!=0){
			a = b;
			b = r;
			r = a%b;
		}
		
		return b;
	}
	
	Rational add(Rational r){ //�ӷ�����
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*b+denominator*a;
		int newDenomimator = denominator*b;
		Rational result = new Rational();
		return result;
		
	}
}	
