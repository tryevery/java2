package com.test10;

import java.io.RandomAccessFile;

/**
 * �����
 * @author lcj
 *
 */
public class Example10_8 {
	public static void main(String[] args) {
		RandomAccessFile inAndOut = null;
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		String s = "���";
		try {
			inAndOut = new RandomAccessFile("tom.dat", "rw");
			for(int i=0;i<data.length;i++){
				inAndOut.writeInt(data[i]); //���ļ�д��һ��intֵ
			}
			
			inAndOut.writeUTF(s);
			
			for(long i=data.length-1;i>=0;i--){
				inAndOut.seek(i*4);//һ��int����ռ4���ֽ�,inAndOut���ļ��ĵ�36���ֽ�ȡ��������
				System.out.printf("\t%d",inAndOut.readInt());//ÿ���ĸ��ֽ���ǰ��ȡһ������
			}
//			System.out.println(inAndOut.readUTF()); //��ȡһ��utf�ַ���
			inAndOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
