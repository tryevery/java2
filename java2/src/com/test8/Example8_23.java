package com.test8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class Example8_23 {
	public static void main(String[] args) {
		Date date = new Date();
		Class cs = date.getClass(); //获取class对象
		String className = cs.getName();
		Constructor []con = cs.getDeclaredConstructors();//全部构造方法
		Field []field = cs.getDeclaredFields();//全部成员变量
		Method []method = cs.getMethods();//全部方法
		System.out.println("名字"+className);
		System.out.println("类中有如下成员变量：");
		for(int i=0;i<field.length;i++){
			System.out.println(field[i].toString());
		}
		System.out.println("类中有如下方法：");
		for(int i=0;i<method.length;i++){
			System.out.println(method[i].toString());
		}
		System.out.println("类中有如下构造方法：");
		for(int i=0;i<con.length;i++){
			System.out.println(con[i].toString());
		}
	}
}
