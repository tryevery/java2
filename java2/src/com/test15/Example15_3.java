package com.test15;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author lcj
 *
 */
public class Example15_3 {
	public static void main(String[] args) {
		LinkedList list = new LinkedList(); 
		list.add("��");
		list.add("��");
		int number = list.size();
		for (int i = 0; i < number; i++) {
			String temp = (String) list.get(i);
			System.out.println("��"+i+"����е�����"+temp);
		}
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			String tr = (String) iterator.next();
			System.out.println(tr);
		}
	}
}
