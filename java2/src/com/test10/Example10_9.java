package com.test10;

import java.io.RandomAccessFile;

/**
 * RondomAccessFile使用readLine()读取字符床
 * @author lcj
 *
 */
public class Example10_9 {
	public static void main(String[] args) {
		RandomAccessFile in = null;
		try {
			in = new RandomAccessFile("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10\\Example10_9.java", "rw");
			long length = in.length(); //获取文件长度
			long position = 0;
			in.seek(position); //将读取位置定位到文件的开始
			while(position<length){
				String str = in.readLine();
				byte []b = str.getBytes("iso-8859-1"); //指定文件编码
				str = new String(b);
				position = in.getFilePointer();
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
