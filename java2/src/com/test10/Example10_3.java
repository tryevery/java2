package com.test10;

import java.io.File;

/**
 * ʹ��RunTime����򿪼��±��������
 * @author lcj
 *
 */
public class Example10_3 {
	public static void main(String[] args) {
		try {
			Runtime ce = Runtime.getRuntime();
			File file = new File("c:\\windows","notepad.exe");
			ce.exec(file.getAbsolutePath());
			file = new File("c:\\Program Files\\Internet Explorer","IEXPLORE www.sohu.com");
			ce.exec(file.getAbsolutePath());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
