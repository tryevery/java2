package com.test15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ����  LinkedList
 * ����˳��ṹ 
 * @author lcj
 *
 */
public class Example15_2 {
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		for(int i=1;i<=60096;i++){
			list.add("speed"+i);
		}
		Iterator<String> iterator = list.iterator();
		long startTime = System.currentTimeMillis();
		while(iterator.hasNext()){
			String tr = iterator.next();
		}
		
		long endTime = System.currentTimeMillis();
		long result = endTime - startTime;
		System.out.println("ʹ�õ�����������������ʱ��:"+result+"����");
		startTime = System.currentTimeMillis();
		for(int i=0;i<list.size();i++){
			String te = list.get(i);
		}
		endTime = System.currentTimeMillis();
		result = endTime - startTime;
		System.out.println("ʹ��getѭ���������������õ�ʱ��:"+result+"����");
	}
}
