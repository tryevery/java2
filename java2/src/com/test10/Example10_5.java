package com.test10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * �ļ��ֽ������
 * @author lcj
 *
 */
public class Example10_5 {
	public static void main(String[] args) {
		byte []a = "�������".getBytes();
		byte []b = "Happy new Year".getBytes();
		File f = new File("a.txt");  //�����Ŀ�ĵ�
		try {
			OutputStream out = new FileOutputStream(f);  //ָ��Ŀ�ĵص������
			System.out.println(f.getName()+"�Ĵ�С"+f.length()+"�ֽ�");
			out.write(a);  //��Ŀ�ĵ�д����
			out.close();
			out = new FileOutputStream(f, true);  //׼�����ļ�β׷��
			System.out.println(f.getName()+"�Ĵ�С"+f.length()+"�ֽ�");
			out.write(b,0,b.length);
			System.out.println(f.getName()+"�Ĵ�С"+f.length()+"�ֽ�");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
