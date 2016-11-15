package com.test15;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet ����
 * @author lcj
 *
 */
public class Example15_8 {
	public static void main(String[] args) {
		TreeSet<Student1> tree = new TreeSet<Student1>();
		Student1 st1,st2,st3,st4;
		st1 = new Student1(90, "��һ");
		st2 = new Student1(66, "����");
		st3 = new Student1(80, "����");
		st4 = new Student1(70, "����");
		tree.add(st1);
		tree.add(st2);
		tree.add(st3);
		tree.add(st4);
		Iterator<Student1> iterator = tree.iterator();
		while(iterator.hasNext()){
			Student1 stu = iterator.next();
			System.out.println(""+stu.name+" "+stu.english);
		}
	}
}

class Student1 implements Comparable{
	int english = 0;
	String name;
	public Student1(int english,String name) {
		this.name = name;
		this.english = english;
	}
	@Override
	public int compareTo(Object o) {
		Student1 st = (Student1) o;
		if((this.english-st.english)==0){ //����tree�������ͬ�Ľ��
			return 1;
		}else
		return (this.english-st.english);
	}
	
}
