package com.test8;

import java.util.Calendar;
import java.util.Date;

/**
 * ��������Calendar�еĸ��ַ��� P196
 * @author lcj
 *
 */
public class Example8_15 {
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		int year = ca.get(Calendar.YEAR);
		int mounth = ca.get(Calendar.MONTH)+1;
		int day = ca.get(Calendar.DAY_OF_MONTH);
		int hour = ca.get(Calendar.HOUR_OF_DAY);
		int minute = ca.get(Calendar.MINUTE);
		int second = ca.get(Calendar.SECOND);
		System.out.println("���ڵ�ʱ���ǣ�");
		System.out.print(year+"��"+mounth+"��"+day+"��");
		System.out.println(" "+hour+"ʱ"+minute+"��"+second+"��");
		int y =2012,m = 9,d = 1;
		ca.set(y, m-1,d);
		long time1 = ca.getTimeInMillis();
		y = 2016;
		m = 7;
		d = 1;
		ca.set(y,m-1,d);
		long time2 = ca.getTimeInMillis();
		long subDay = (time2 - time1)/(1000*60*60*24);
		System.out.println(new Date(time2));
		System.out.println(new Date(time1));
		System.out.println(subDay);
	}
}
