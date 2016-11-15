package com.test15;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * ��ӳ�� TreeMap
 * @author lcj
 *
 */
public class Example15_9 {
	public static void main(String[] args) {
		TreeMap<StudentKey, Student2> tree = new TreeMap<StudentKey,Student2>();
		String str[] = {"�Զ�","����","����","����"};
		double []math = {89,45,78,76};
		double []english = {67,66,90,56};
		Student2 student[] = new Student2[4];
		for(int i=0;i<student.length;i++){
			student[i] = new Student2(str[i], math[i], english[i]);
		}
		
		StudentKey []key = new StudentKey[4];
		for(int k=0;k<key.length;k++){
			key[k] = new StudentKey(student[k].math);  //�ؼ��ְ���ѧ�ɼ����д�С
		}
		
		for(int j=0;j<student.length;j++){
			tree.put(key[j], student[j]); //��������
		}
		
		int number = tree.size();
		System.out.println("��ӳ������"+number+"������,����ѧ�ɼ�����");
		Collection<Student2> collection = tree.values();
		Iterator<Student2> iterator = collection.iterator();
		while(iterator.hasNext()){
			Student2 stu = iterator.next();
			System.out.println("����"+stu.name+"��ѧ"+stu.math);
		}
		tree.clear();
		
		for(int k=0;k<key.length;k++){
			key[k] = new StudentKey(student[k].english);  //�ؼ��ְ�Ӣ��ɼ���С����
		}
		
		for(int j=0;j<student.length;j++){
			tree.put(key[j], student[j]);
		}
		
		number = tree.size();
		System.out.println("��ӳ������"+number+"������,��Ӣ��ɼ�����");
		collection = tree.values();
		iterator = collection.iterator();
		while(iterator.hasNext()){
			Student2 stu = iterator.next();
			System.out.println("����"+stu.name+"Ӣ��"+stu.english);
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
			return (int) ((this.d-st.d)*1000);  //����������,�����ǽ���
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