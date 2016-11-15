package com.test10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * �ַ������ܽ���д���ļ���
 * @author lcj
 *
 */
public class Example10_12 {
	public static void main(String[] args) {
		String commnd = "�ɽ��ܹ�ʱ����ʲô?";
		EncryptAndDecrypt en = new EncryptAndDecrypt();
		String passwd = "lcj";
		String secret = en.encrypt(commnd, passwd);
		File file = new File("secret.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream outData = new DataOutputStream(fos);
			outData.writeUTF(secret);
			System.out.println("��������:"+ secret);
		} catch (Exception e) {
		}
		
		
		try {
			FileInputStream fis = new FileInputStream(file);
			DataInputStream inData = new DataInputStream(fis);
			String str = inData.readUTF();
			String mingwen = en.decrypt(str, passwd);
			System.out.println("��������:"+mingwen);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


class EncryptAndDecrypt {
	String encrypt(String sourceString,String passwd){
		char p[] = passwd.toCharArray();
		int n = p.length;
		char []c = sourceString.toCharArray();
		int m = c.length;
		for(int i=0;i<m;i++){
			int mima = c[i]+p[i%n];
			c[i] = (char) mima;
		}
		
		return new String(c);
	}
	String decrypt(String sourceString,String passwd){
		char p[] = passwd.toCharArray();
		int n = p.length;
		char []c = sourceString.toCharArray();
		int m = c.length;
		for(int i=0;i<m;i++){
			int mima = c[i]-p[i%n];
			c[i] = (char) mima;
		}
		
		return new String(c);
	}
}