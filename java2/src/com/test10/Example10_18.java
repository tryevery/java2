package com.test10;

import java.io.FileInputStream;

import javax.swing.ProgressMonitor;
import javax.swing.ProgressMonitorInputStream;

/**
 * 带进度条的输入流
 * @author lcj
 *
 */
public class Example10_18 {
	public static void main(String[] args) {
		byte []b = new byte[30];
		try {
			FileInputStream fis = new FileInputStream("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10\\Example10_18.java");
			ProgressMonitorInputStream in = new ProgressMonitorInputStream(null, "读取java文件", fis);
			ProgressMonitor p = in.getProgressMonitor(); //获取进度条
			while((in.read(b))!=-1){
				String s = new String(b);
				System.out.print(s);
				Thread.sleep(1000); //由于文件较小,为了看清进度条延缓1000毫秒
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
