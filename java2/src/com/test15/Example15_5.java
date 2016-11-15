package com.test15;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ����Collectionsʵ��ϴ��,��ת�ͷ�ת
 * @author lcj
 *
 */
public class Example15_5 {	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=55;i++){
			list.add(new Integer(i));
		}
		System.out.println("ϴ��ǰ�����е�����");
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer h = iterator.next();
			System.out.printf("%d\t",h.intValue());
		}
		
		Collections.shuffle(list);
		System.out.println("\nϴ�ƺ���б�");
		iterator = list.iterator();
		while(iterator.hasNext()){
			Integer h = iterator.next();
			System.out.printf("%d\t",h.intValue());
		}
		
		System.out.println("������ѡװһ�κ��б�������");
		Collections.rotate(list, 1);
		iterator = list.iterator();
		while(iterator.hasNext()){
			Integer h = iterator.next();
			System.out.printf("%d\t",h.intValue());
		}
	}
}
