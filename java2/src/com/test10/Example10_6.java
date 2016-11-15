package com.test10;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 文件字符输入输出流
 * @author lcj
 *
 */
public class Example10_6 {
	public static void main(String[] args) {
		File f = new File("a.txt"); //读取的文件
		File tf = new File("b.txt");//写入的文件
		char []c = new char[19]; 
		try {
			Writer out = new FileWriter(tf,true); //指向目的地的输出流
			Reader in = new FileReader(f);//指向源的输入流
			int n = -1;
			while((n=in.read(c))!=-1){
				out.write(c, 0, n);
				
			}
			
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
