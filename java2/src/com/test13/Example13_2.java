package com.test13;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获得www.sina.com.cn的主机域名以及ip地址,
 * 同时获取了ip地址是166.111.222.3主机域名级ip地址
 * @author lcj
 *
 */
public class Example13_2 {
	public static void main(String[] args) {
		InetAddress address_1,address_2;
		try {
			address_1 = InetAddress.getByName("www.sina.com.cn");
			System.out.println(address_1.toString());
			System.out.println(address_1.getHostAddress()); //获取域名
			address_2 = InetAddress.getByName("166.111.222.3");
			System.out.println(address_2.toString());
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.getHostName()+"\n"+address.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("无法找到www.sina.com.cn");
			e.printStackTrace();
		}
	}
}
