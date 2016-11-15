package com.test10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 字符串加密解密写入文件中
 * @author lcj
 *
 */
public class Example10_12 {
	public static void main(String[] args) {
		String commnd = "渡江总攻时间是什么?";
		EncryptAndDecrypt en = new EncryptAndDecrypt();
		String passwd = "lcj";
		String secret = en.encrypt(commnd, passwd);
		File file = new File("secret.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream outData = new DataOutputStream(fos);
			outData.writeUTF(secret);
			System.out.println("加密命令:"+ secret);
		} catch (Exception e) {
		}
		
		
		try {
			FileInputStream fis = new FileInputStream(file);
			DataInputStream inData = new DataInputStream(fis);
			String str = inData.readUTF();
			String mingwen = en.decrypt(str, passwd);
			System.out.println("解密命令:"+mingwen);
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