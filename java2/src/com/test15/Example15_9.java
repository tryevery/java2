package com.test15;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * 树映射 TreeMap
 * @author lcj
 *
 */
public class Example15_9 {
	public static void main(String[] args) {
		TreeMap<StudentKey, Student2> tree = new TreeMap<StudentKey,Student2>();
		String str[] = {"赵儿","张三","李四","王五"};
		double []math = {89,45,78,76};
		double []english = {67,66,90,56};
		Student2 student[] = new Student2[4];
		for(int i=0;i<student.length;i++){
			student[i] = new Student2(str[i], math[i], english[i]);
		}
		
		StudentKey []key = new StudentKey[4];
		for(int k=0;k<key.length;k++){
			key[k] = new StudentKey(student[k].math);  //关键字按数学成绩排列大小
		}
		
		for(int j=0;j<student.length;j++){
			tree.put(key[j], student[j]); //放入数据
		}
		
		int number = tree.size();
		System.out.println("树映射中有"+number+"个对象,按数学成绩排序");
		Collection<Student2> collection = tree.values();
		Iterator<Student2> iterator = collection.iterator();
		while(iterator.hasNext()){
			Student2 stu = iterator.next();
			System.out.println("姓名"+stu.name+"数学"+stu.math);
		}
		tree.clear();
		
		for(int k=0;k<key.length;k++){
			key[k] = new StudentKey(student[k].english);  //关键字按英语成绩大小排序
		}
		
		for(int j=0;j<student.length;j++){
			tree.put(key[j], student[j]);
		}
		
		number = tree.size();
		System.out.println("树映射中有"+number+"个对象,按英语成绩排序");
		collection = tree.values();
		iterator = collection.iterator();
		while(iterator.hasNext()){
			Student2 stu = iterator.next();
			System.out.println("姓名"+stu.name+"英语"+stu.english);
		}
	}
}

class StudentKey implements Comparable {
	double d = 0;
	public StudentKey(double d) {
		this.d = d;
	}
	
	@Override
	public int compareTo(Object o) {
		StudentKey st = (StudentKey) o;
		if((this.d - st.d)==0){
			return -1;
		}else 
			return (int) ((this.d-st.d)*1000);  //正数是升序,负数是降序
	}
}

class Student2 {
	String name = null;
	double math,english;
	public Student2(String s,double m,double e) {
		name = s;
		math = m;
		english = e;
	}
}