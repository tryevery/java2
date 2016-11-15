package homework8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 用Scanner类的实例解析字符串
 * @author lcj
 *
 */
public class Test6 {
	public static void main(String[] args) {
		String str = "数学78分，物理76分，英语96分";
		Scanner s = new Scanner(str);
		s.useDelimiter("[^0-9.]+"); //设置一个分割标志
		double sum = 0;
		while(s.hasNext()){
			try {
				double temp = s.nextDouble();
				sum = sum + temp;
			} catch (InputMismatchException exp) {
				exp.printStackTrace();
			}
		}
		System.out.println(sum);
	}
}
