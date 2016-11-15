package com.test13;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * 在窗口中输入网址，读取服务器上的资源，程序需要在一个线程中读取URL资源，
 * 以免阻塞主线程
 * @author lcj
 *
 */
public class Example13_1 {
	public static void main(String[] args) {
		Scanner s;
		URL url;
		Thread readURL;
		Look look = new Look();
		System.out.println("输入URL资源,例如:http://www.yaohoo.com");
		s = new Scanner(System.in);
		String source = s.nextLine();
		String xieyi = "http://";
		try {
			url = new URL(xieyi+source);
			look.setUrl(url);
			readURL = new Thread(look);
			readURL.start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
	}
}


class Look implements Runnable {
	URL url;
	
	public void setUrl(URL url) {
		this.url = url;
	}

	@Override
	public void run() {
		try {
			InputStream in = url.openStream();
			byte []b = new byte[1024];
			int n = -1;
			while((n=in.read(b))!=-1){
				String str = new String(b,0,n);
				System.out.println(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}