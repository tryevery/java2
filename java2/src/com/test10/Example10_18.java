package com.test10;

import java.io.FileInputStream;

import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;

/**
 * ����������������
 * @author lcj
 *
 */
public class Example10_18 {
	public static void main(String[] args) {
		byte []b = new byte[30];
		try {
			FileInputStream fis = new FileInputStream("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10\\Example10_18.java");
			ProgressMonitorInputStream in = new ProgressMonitorInputStream(null, "��ȡjava�ļ�", fis);
			ProgressMonitor p = in.getProgressMonitor(); //��ȡ������
			while((in.read(b))!=-1){
				String s = new String(b);
				System.out.print(s);
				Thread.sleep(1000); //�����ļ���С,Ϊ�˿���������ӻ�1000����
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
