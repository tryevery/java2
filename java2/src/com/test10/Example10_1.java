package com.test10;

import java.io.File;

/**
 * ��ȡ�ļ�����Ϣ
 * @author lcj
 *
 */
public class Example10_1 {
	public static void main(String[] args) {
		File file = new File("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10","Example10_1.java");
		System.out.println(file.getName() +"\n"
				+"�Ƿ�ɶ�:" + file.canRead() +"\n"
				+"����:" + file.length() +"\n"
				+"����·��:" + file.getAbsolutePath());
		file = new File("new.txt");
		System.out.println("�ڵ�ǰĿ¼�´����ļ�"+file.getName());
		if(!file.exists()){
			try{
				file.createNewFile();
				System.out.println(file.getName());
				System.out.println("�����ɹ�");
			}catch(Exception e){
			}
		}
		
	}
}
