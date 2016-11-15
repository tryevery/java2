package com.test8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class Example8_23 {
	public static void main(String[] args) {
		Date date = new Date();
		Class cs = date.getClass(); //��ȡclass����
		String className = cs.getName();
		Constructor []con = cs.getDeclaredConstructors();//ȫ�����췽��
		Field []field = cs.getDeclaredFields();//ȫ����Ա����
		Method []method = cs.getMethods();//ȫ������
		System.out.println("����"+className);
		System.out.println("���������³�Ա������");
		for(int i=0;i<field.length;i++){
			System.out.println(field[i].toString());
		}
		System.out.println("���������·�����");
		for(int i=0;i<method.length;i++){
			System.out.println(method[i].toString());
		}
		System.out.println("���������¹��췽����");
		for(int i=0;i<con.length;i++){
			System.out.println(con[i].toString());
		}
	}
}
