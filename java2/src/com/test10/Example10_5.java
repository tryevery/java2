package com.test10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 文件字节输出流
 * @author lcj
 *
 */
public class Example10_5 {
	public static void main(String[] args) {
		byte []a = "新年快乐".getBytes();
		byte []b = "Happy new Year".getBytes();
		File f = new File("a.txt");  //输出的目的地
		try {
			OutputStream out = new FileOutputStream(f);  //指向目的地的输出流
			System.out.println(f.getName()+"的大小"+f.length()+"字节");
			out.write(a);  //向目的地写数据
			out.close();
			out = new FileOutputStream(f, true);  //准备向文件尾追加
			System.out.println(f.getName()+"的大小"+f.length()+"字节");
			out.write(b,0,b.length);
			System.out.println(f.getName()+"的大小"+f.length()+"字节");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
