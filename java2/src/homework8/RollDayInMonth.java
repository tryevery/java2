package homework8;

import java.util.Calendar;
import java.util.Date;

/**
 * ѧϰ������һ���¡�һ�ܡ�һ����ǰ���������
 * @author lcj
 *
 */
public class RollDayInMonth {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		String s = String.format("%tF(%<tA)", calendar);
		System.out.println(s);
		int n = 25;
		System.out.println("���������£�"+n+"��");
		calendar.roll(calendar.DAY_OF_MONTH, n);
		s = String.format("%tF(%<ta)", calendar);
		System.out.println(s);
		System.out.println("���������꣩"+n+"��");
		calendar.roll(calendar.DAY_OF_YEAR, n);
		s = String.format("%tF(%<ta)", calendar);
		System.out.println(s);
		
	}
}
