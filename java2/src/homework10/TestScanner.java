package homework10;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * �����ı�
 * @author lcj
 *
 */
public class TestScanner {
	public static void main(String[] args) {
		File file = new File("cost.txt");
		double sum = 0;
		Scanner s = null;
		try {
			FileOutputStream out = new FileOutputStream(file);
			byte []a = ("��Ʒ�б�:\n"+"���ӻ�,2567Ԫ/̨"+"ϴ�»�,3562Ԫ/̨"+"����,6573Ԫ/̨").getBytes();
			out.write(a, 0, a.length);
			s = new Scanner(file);
			s.useDelimiter("[^0-9.]+"); //����һ�����˹���
			while(s.hasNext()){
				try {
					double price = s.nextInt();
					sum = sum + price;
					System.out.println(price);
				} catch (Exception e) {
					String t = s.next();
				}
			}
			System.out.println("Total Cost:"+sum+"dollar");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
