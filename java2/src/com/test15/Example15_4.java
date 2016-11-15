package com.test15;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ���������
 * Collections ���� 
 * binarySerch  ���ֲ���
 * @author lcj
 *
 */
public class Example15_4 {
	public static void main(String[] args) {
		List<Student> list = new LinkedList<Student>();
		list.add(new Student("����",188));
		list.add(new Student("����",178));
		list.add(new Student("����",198));
		Iterator<Student> iterator = list.iterator();
		System.out.println("����ǰ���б�:");
		while(iterator.hasNext()){
			Student stu = iterator.next();
			System.out.println(stu.name+"���"+stu.height);
		}
		Collections.sort(list); //����������
		System.out.println("����������");
		iterator = list.iterator();
		while(iterator.hasNext()){
			Student stu = iterator.next();
			System.out.println(stu.name+"���"+stu.height);
			
		}
		Student zhaolin = new Student("zhao xiao lin", 178);
		int index = Collections.binarySearch(list, zhaolin,null);
		if(index>=0){
			System.out.println(zhaolin.name+"�������е�"+list.get(index).name+"�����ͬ");
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
	public int compareTo(Object o) { //����student�������,���ҽ������ߵ�heightֵ���
		Student stu = (Student) o;
		return (this.height-stu.height);
	}
	
}
