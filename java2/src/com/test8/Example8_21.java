package com.test8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 运用Pattern和Matcher类实现查找一个字符串中的网址，然后将网址剔除，得到一个新的字符串
 * @author lcj
 *
 */
public class Example8_21 {
	public static void main(String[] args) {
		Pattern p;
		Matcher m;
		String regex = "(http://|www)\56?\\w+\56{1}\\w+\56{1}\\p{Alpha}+";
		p = Pattern.compile(regex);
		String s = "新浪：www.sina.com,央视：http://www.cctv.com"; //字符串本身没有变化
		m = p.matcher(s);
		while(m.find()){
			System.out.println(m.group());
		}
		System.out.println("剔除字符串中网址后得到的字符串");
		String result = m.replaceAll(""); //将与regex中匹配的字符串用空替代
		System.out.println(result);
		System.out.println(s);
	}
}
