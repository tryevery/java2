package com.test10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;

/**
 * 使用数组流向内存写入数据,然后在读取写入的数据
 * @author lcj
 *
 */
public class Example10_10 {
	public static void main(String[] args) {
		try {
			ByteArrayOutputStream outByte = new ByteArrayOutputStream();
			byte []b = "mid-autumn festival".getBytes();
			outByte.write(b);
			ByteArrayInputStream inByte = new ByteArrayInputStream(outByte.toByteArray());
			byte a[] = new byte[outByte.toByteArray().length];
			inByte.read(a); //将读取的数据写入到a数组中
			System.out.println(new String(a));
			CharArrayWriter outChar = new CharArrayWriter();
			char []c = "中秋快乐".toCharArray();
			outChar.write(c);
			CharArrayReader inChar = new CharArrayReader(outChar.toCharArray());
			char backChar[] = new char[outChar.toCharArray().length];
			inChar.read(backChar);
			System.out.println(new String(backChar));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
