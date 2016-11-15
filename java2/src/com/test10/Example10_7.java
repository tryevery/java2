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
 * 缓冲流
 * @author lcj
 *
 */
public class Example10_7 {
	public static void main(String[] args) {
		File fRead = new File("english.txt");
		File fWrite = new File("englishCount.txt");
		try {
			Writer out = new FileWriter(fWrite);//指向目的地的字符输出流
			BufferedWriter bufferWrite = new BufferedWriter(out); //指向目的地的缓冲输出流
			Reader in = new FileReader(fRead); //指向源的字符出入流
			BufferedReader bufferReader = new BufferedReader(in); //指向源的缓冲输入流
			String str = null;
			while((str=bufferReader.readLine())!=null){
				StringTokenizer fenxi = new StringTokenizer(str);
				int count = fenxi.countTokens(); //单词的个数
				str = str + " 句子中单词的个数 "+count;
				bufferWrite.write(str);
				bufferWrite.newLine();
			}
			bufferWrite.close();
			out.close();
			in = new FileReader(fWrite);
			bufferReader = new BufferedReader(in);
			String s = null;
			System.out.println(fWrite.getName()+"内容:");
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
