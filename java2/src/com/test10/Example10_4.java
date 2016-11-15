package com.test10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件字节流读取文件的内容
 * @author lcj
 *
 */
public class Example10_4 {
	public static void main(String[] args) {
		int n = -1;
		byte []a = new byte[100];
		try {
			File f = new File("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10\\Example10_4.java");
			InputStream in = new FileInputStream(f);
			while((n=in.read(a, 0, 100))!=-1){
				String s = new String(a,0,n);
				System.out.println(s);
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}
