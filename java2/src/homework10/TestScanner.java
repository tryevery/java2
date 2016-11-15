package homework10;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * 解析文本
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
			byte []a = ("商品列表:\n"+"电视机,2567元/台"+"洗衣机,3562元/台"+"冰箱,6573元/台").getBytes();
			out.write(a, 0, a.length);
			s = new Scanner(file);
			s.useDelimiter("[^0-9.]+"); //设置一个过滤规则
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
