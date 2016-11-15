package com.test10;

import java.io.File;

/**
 * 获取文件的信息
 * @author lcj
 *
 */
public class Example10_1 {
	public static void main(String[] args) {
		File file = new File("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10","Example10_1.java");
		System.out.println(file.getName() +"\n"
				+"是否可读:" + file.canRead() +"\n"
				+"长度:" + file.length() +"\n"
				+"绝对路径:" + file.getAbsolutePath());
		file = new File("new.txt");
		System.out.println("在当前目录下创建文件"+file.getName());
		if(!file.exists()){
			try{
				file.createNewFile();
				System.out.println(file.getName());
				System.out.println("创建成功");
			}catch(Exception e){
			}
		}
		
	}
}
