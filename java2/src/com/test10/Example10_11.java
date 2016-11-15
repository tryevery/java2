package com.test10;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Êý¾ÝÁ÷
 * @author lcj
 *
 */
public class Example10_11 {
	public static void main(String[] args) {
		File file = new File("apple.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream outData = new DataOutputStream(fos);
			outData.writeInt(100);
			outData.writeLong(56456456456L);
			outData.writeFloat(3.31424343F);
			outData.writeDouble(89890989.434);
			outData.writeBoolean(true);
			outData.writeChars("How are you doing");
			
		} catch (Exception e) {
		}
		
		try {
			FileInputStream fis = new FileInputStream(file);
			DataInputStream inData = new DataInputStream(fis);
			System.out.println(inData.readInt());
			System.out.println(inData.readLong());
			System.out.println(inData.readDouble());
			System.out.println(inData.readBoolean());
			System.out.println(inData.readFloat());
			char c = '\0';
			while((c=inData.readChar())!='\0'){
				System.out.println(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
