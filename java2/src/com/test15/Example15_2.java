package com.test15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 链表  LinkedList
 * 不是顺序结构 
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
		System.out.println("使用迭代器遍历集合所用时间:"+result+"毫秒");
		startTime = System.currentTimeMillis();
		for(int i=0;i<list.size();i++){
			String te = list.get(i);
		}
		endTime = System.currentTimeMillis();
		result = endTime - startTime;
		System.out.println("使用get循环遍历迭代器所用的时间:"+result+"毫秒");
	}
}
