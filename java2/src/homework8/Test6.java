package homework8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ��Scanner���ʵ�������ַ���
 * @author lcj
 *
 */
public class Test6 {
	public static void main(String[] args) {
		String str = "��ѧ78�֣�����76�֣�Ӣ��96��";
		Scanner s = new Scanner(str);
		s.useDelimiter("[^0-9.]+"); //����һ���ָ��־
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
