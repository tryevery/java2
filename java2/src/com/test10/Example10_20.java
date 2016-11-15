package com.test10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 应用举例    标准还考试
 * @author lcj
 *
 */
public class Example10_20 {
	public static void main(String[] args) {
		StandarExam s = new StandarExam();
		File f = new File("test.txt");
		s.setTestFile(f);
		s.standarExam();
	}
}



class StandarExam {
	File testFile;
	public void setTestFile(File f){
		testFile = f;
	}
	
	public void standarExam() {
		int score = 0;
		Scanner scanner = new Scanner(System.in);
		try {
			FileReader inOne = new FileReader(testFile);
			BufferedReader inTwo = new BufferedReader(inOne);
			String s = null;
			while((s = inTwo.readLine())!=null){
				if(!s.startsWith("-"))
				System.out.println(s);
				else {
					s = s.replaceAll("-", "");
					String correntAnser = s;
					System.out.println("\n输入选择的答案");
					String answer = scanner.nextLine();
					if(answer.compareToIgnoreCase(correntAnser)==0){
						score++;
					}
				}
			}
			inTwo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("最后得分:"+score);
	}
}