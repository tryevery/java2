package com.test10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象流
 * @author lcj
 *
 */
public class Example10_13 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TV changhong = new TV();
		changhong.setName("长虹");
		changhong.setPrice(10000);
		File file = new File("television.txt");
		try {
			/*FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream objectOut = new ObjectOutputStream(fos);*/
			ByteArrayOutputStream outByte = new ByteArrayOutputStream();
			ObjectOutputStream objectOut = new ObjectOutputStream(outByte); //将对象信息写入内存中
			
			
			objectOut.writeObject(changhong);
			objectOut.close();
			/*FileInputStream fis = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(fis);*/
			
			ByteArrayInputStream inByte = new ByteArrayInputStream(outByte.toByteArray());
			ObjectInputStream objectIn = new ObjectInputStream(inByte); //从内存中读取对象信息
			
			TV tv = (TV) objectIn.readObject();
			objectIn.close();
			tv.setName("TCL");
			tv.setPrice(10000);
			System.out.println(changhong.getName());
			System.out.println(changhong.getPrice());
			System.out.println(tv.getName());
			System.out.println(tv.getName());
		} catch (Exception e) {
			System.out.println("不能读出对象");
		}
	}
}

class TV implements Serializable{
	String name;
	double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
