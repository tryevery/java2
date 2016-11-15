package com.test8;

import java.util.Calendar;

/**
 * д��һ����������
 * @author lcj
 *
 */
public class Example8_16 {
	public static void main(String[] args) {
		CalendarBean cb = new CalendarBean();
		cb.setYear(2016);
		cb.setMonth(9);
		String []a = cb.getCalendar();
		char []str = "��һ����������".toCharArray();
		for(char c:str){
			System.out.printf("%3c",c);
		}
		for(int i=0;i<a.length;i++){
			if(i%7==0) System.out.println("");
			System.out.printf("%3s",a[i]);
		}
		System.out.print("hello");
	}
}

class CalendarBean{
	int year = 0,month = 0;
	public void setYear(int year){
		this.year = year;
	}
	public void setMonth(int month){
		this.month = month;
	}
	
	public String[] getCalendar(){
		String []a = new String[42];
		Calendar rili = Calendar.getInstance(); //��ʼ��һ����������
		rili.set(year,month-1,1);
		int weekDay = rili.get(Calendar.DAY_OF_WEEK)-1; //����һ�������ڼ�
		int day = 0;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			day = 31;
		}
		if(month==4||month==6||month==9||month==11){
			day = 30;
		}
		if(month==2){
			if(((year%4==0)&&(year%100!=0))||year%400==0){ //�ж�����
				day = 29;
			}else{
				day = 28;
			}
		}
		
		for(int i=0;i<weekDay;i++){
			a[i] = " ";  //��ǰ��û�еĵط��ճ���
		}
		for(int i=weekDay,n=1;i<weekDay+day;i++){
			a[i] = String.valueOf(n); //�ӵڼ�����ʼ��ӡ����
			n++;
		}
		
		for(int i=weekDay+day;i<a.length;i++){
			a[i] = " "; //����ӡ�ո�
		}
		return a;
	}
}
