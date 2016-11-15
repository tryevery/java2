package com.test15;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 排序与查找
 * Collections 排序 
 * binarySerch  二分查找
 * @author lcj
 *
 */
public class Example15_4 {
	public static void main(String[] args) {
		List<Student> list = new LinkedList<Student>();
		list.add(new Student("张三",188));
		list.add(new Student("李四",178));
		list.add(new Student("王五",198));
		Iterator<Student> iterator = list.iterator();
		System.out.println("排序前的列表:");
		while(iterator.hasNext()){
			Student stu = iterator.next();
			System.out.println(stu.name+"身高"+stu.height);
		}
		Collections.sort(list); //对容器排序
		System.out.println("排序后的链表");
		iterator = list.iterator();
		while(iterator.hasNext()){
			Student stu = iterator.next();
			System.out.println(stu.name+"身高"+stu.height);
			
		}
		Student zhaolin = new Student("zhao xiao lin", 178);
		int index = Collections.binarySearch(list, zhaolin,null);
		if(index>=0){
			System.out.println(zhaolin.name+"和链表中的"+list.get(index).name+"身高相同");
		}
	}
}

class Student implements Comparable {
	int height = 0;
	String name;
	public Student(String n,int h) {
		name = n;
		height = h;
	}
	@Override
	public int compareTo(Object o) { //两个student对象相等,当且仅当两者的height值相等
		Student stu = (Student) o;
		return (this.height-stu.height);
	}
	
}
