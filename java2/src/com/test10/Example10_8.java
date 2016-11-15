package com.test10;

import java.io.RandomAccessFile;

/**
 * 随机流
 * @author lcj
 *
 */
public class Example10_8 {
	public static void main(String[] args) {
		RandomAccessFile inAndOut = null;
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		String s = "你好";
		try {
			inAndOut = new RandomAccessFile("tom.dat", "rw");
			for(int i=0;i<data.length;i++){
				inAndOut.writeInt(data[i]); //向文件写入一个int值
			}
			
			inAndOut.writeUTF(s);
			
			for(long i=data.length-1;i>=0;i--){
				inAndOut.seek(i*4);//一个int正数占4个字节,inAndOut从文件的第36个字节取最后的整数
				System.out.printf("\t%d",inAndOut.readInt());//每隔四个字节往前读取一个整数
			}
//			System.out.println(inAndOut.readUTF()); //读取一个utf字符床
			inAndOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
