package com.test15;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 利用Collections实现洗牌,旋转和翻转
 * @author lcj
 *
 */
public class Example15_5 {	
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=55;i++){
			list.add(new Integer(i));
		}
		System.out.println("洗牌前链表中的数据");
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			Integer h = iterator.next();
			System.out.printf("%d\t",h.intValue());
		}
		
		Collections.shuffle(list);
		System.out.println("\n洗牌后的列表");
		iterator = list.iterator();
		while(iterator.hasNext()){
			Integer h = iterator.next();
			System.out.printf("%d\t",h.intValue());
		}
		
		System.out.println("在向右选装一次后列表中数据");
		Collections.rotate(list, 1);
		iterator = list.iterator();
		while(iterator.hasNext()){
			Integer h = iterator.next();
			System.out.printf("%d\t",h.intValue());
		}
	}
}
