package com.test8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����Pattern��Matcher��ʵ�ֲ���һ���ַ����е���ַ��Ȼ����ַ�޳����õ�һ���µ��ַ���
 * @author lcj
 *
 */
public class Example8_21 {
	public static void main(String[] args) {
		Pattern p;
		Matcher m;
		String regex = "(http://|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}+";
		p = Pattern.compile(regex);
		String s = "���ˣ�www.sina.com,���ӣ�http://www.cctv.com"; //�ַ�������û�б仯
		m = p.matcher(s);
		while(m.find()){
			System.out.println(m.group());
		}
		System.out.println("�޳��ַ�������ַ��õ����ַ���");
		String result = m.replaceAll(""); //����regex��ƥ����ַ����ÿ����
		System.out.println(result);
		System.out.println(s);
	}
}
