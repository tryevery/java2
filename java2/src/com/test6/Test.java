package com.test6;

public class Test {
	public static void main(String[] args) {
		China zhang;
		Japan henlu;
		zhang = new China();
		henlu = new Japan();
		zhang.number = 32+Computer.MAX;
		henlu.number = 14 + Computer.MAX;
		System.out.println("�ŵ�ѧ�ţ�"+zhang.number+"�ŵ���ͽ����"+zhang.f(100));
		System.out.println("henlu��ѧ�ţ�"+henlu.number+"henlu����ͽ����"+henlu.f(100));
		
		/**
		 * ���ԽӿڵĻص�
		 */
		
		/*China a = new China();
		Computer c =a; */
		Computer c = new China();//��������
		//������һ���ӿڱ���
		//c�������Ե�����ʵ�ֵĽӿڷ��������ǲ����Ե������������ķǽӿڷ���
		System.out.println(c.f(0));
	}
}
