package com.test10;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 列出当前文件夹下的所有java文件
 * @author lcj
 *
 */
public class Example10_2 {
	public static void main(String[] args) {
		File dirFile = new File("E:\\JAVA\\EclipseWorkspaces\\java2\\src\\com\\test10");
		FileAccept fileAccept = new FileAccept();
		fileAccept.setExtendName("java");
		String filename[] = dirFile.list(fileAccept);
		for(String str:filename){
			System.out.println(str);
		}
	}
}
 
class FileAccept implements FilenameFilter {
	private String extendName;

	public void setExtendName(String extendName) {
		this.extendName = "."+extendName;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extendName);
	}
	
}
