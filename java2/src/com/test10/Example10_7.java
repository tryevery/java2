package com.test10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.StringTokenizer;

/**
 * ������
 * @author lcj
 *
 */
public class Example10_7 {
	public static void main(String[] args) {
		File fRead = new File("english.txt");
		File fWrite = new File("englishCount.txt");
		try {
			Writer out = new FileWriter(fWrite);//ָ��Ŀ�ĵص��ַ������
			BufferedWriter bufferWrite = new BufferedWriter(out); //ָ��Ŀ�ĵصĻ��������
			Reader in = new FileReader(fRead); //ָ��Դ���ַ�������
			BufferedReader bufferReader = new BufferedReader(in); //ָ��Դ�Ļ���������
			String str = null;
			while((str=bufferReader.readLine())!=null){
				StringTokenizer fenxi = new StringTokenizer(str);
				int count = fenxi.countTokens(); //���ʵĸ���
				str = str + " �����е��ʵĸ��� "+count;
				bufferWrite.write(str);
				bufferWrite.newLine();
			}
			bufferWrite.close();
			out.close();
			in = new FileReader(fWrite);
			bufferReader = new BufferedReader(in);
			String s = null;
			System.out.println(fWrite.getName()+"����:");
			while((s=bufferReader.readLine())!=null){
				System.out.println(s);
			}
			bufferReader.close();
			in.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
