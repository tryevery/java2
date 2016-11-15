package com.test8;

import java.math.BigInteger;

/**
 * ÆåÅÌ·ÅÂó×Ó
 * @author lcj
 *
 */
public class BigIn {
	public static void main(String[] args) {
		BigInteger b = new BigInteger("2");
		BigInteger t = new BigInteger("0");
		for(int i=0;i<64;i++){
			t = t.add(b.pow(i));
		}
		System.out.println(t);
		System.out.println(b.pow(64).add(new BigInteger("-1")));
		
//		bi = bi.add(BigInteger.valueOf((long)(Math.pow(2, i))));  
	}
}
