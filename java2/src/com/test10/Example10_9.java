package com.test10;

import java.io.RandomAccessFile;

/**
 * RondomAccessFileʹ��readLine()��ȡ�ַ���
 * @author lcj
 *
 */
public class Example10_9 {
	public static void main(String[] args) {
		RandomAccessFile in = null;
		try {
			in = new RandomAccessFile("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10\\Example10_9.java", "rw");
			long length = in.length(); //��ȡ�ļ�����
			long position = 0;
			in.seek(position); //����ȡλ�ö�λ���ļ��Ŀ�ʼ
			while(position<length){
				String str = in.readLine();
				byte []b = str.getBytes("iso-8859-1"); //ָ���ļ�����
				str = new String(b);
				position = in.getFilePointer();
				System.out.println(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
