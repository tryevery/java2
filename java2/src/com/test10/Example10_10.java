package com.test10;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;

/**
 * ʹ�����������ڴ�д������,Ȼ���ڶ�ȡд�������
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
			inByte.read(a); //����ȡ������д�뵽a������
			System.out.println(new String(a));
			CharArrayWriter outChar = new CharArrayWriter();
			char []c = "�������".toCharArray();
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
