package com.test10;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * �ļ��ַ����������
 * @author lcj
 *
 */
public class Example10_6 {
	public static void main(String[] args) {
		File f = new File("a.txt"); //��ȡ���ļ�
		File tf = new File("b.txt");//д����ļ�
		char []c = new char[19]; 
		try {
			Writer out = new FileWriter(tf,true); //ָ��Ŀ�ĵص������
			Reader in = new FileReader(f);//ָ��Դ��������
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
