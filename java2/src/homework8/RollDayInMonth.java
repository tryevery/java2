package homework8;

import java.util.Calendar;
import java.util.Date;

/**
 * 学习怎样在一个月、一周、一年中前后滚动日期
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
		System.out.println("向后滚动（月）"+n+"天");
		calendar.roll(calendar.DAY_OF_MONTH, n);
		s = String.format("%tF(%<ta)", calendar);
		System.out.println(s);
		System.out.println("向后滚动（年）"+n+"天");
		calendar.roll(calendar.DAY_OF_YEAR, n);
		s = String.format("%tF(%<ta)", calendar);
		System.out.println(s);
		
	}
}
