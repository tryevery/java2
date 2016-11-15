package com.test13;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ���www.sina.com.cn�����������Լ�ip��ַ,
 * ͬʱ��ȡ��ip��ַ��166.111.222.3����������ip��ַ
 * @author lcj
 *
 */
public class Example13_2 {
	public static void main(String[] args) {
		InetAddress address_1,address_2;
		try {
			address_1 = InetAddress.getByName("www.sina.com.cn");
			System.out.println(address_1.toString());
			System.out.println(address_1.getHostAddress()); //��ȡ����
			address_2 = InetAddress.getByName("166.111.222.3");
			System.out.println(address_2.toString());
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostName()+"\n"+address.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("�޷��ҵ�www.sina.com.cn");
			e.printStackTrace();
		}
	}
}
