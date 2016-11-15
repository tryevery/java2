package com.test13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 张三主机
 * 通过用户数据报互相发送信息
 * @author lcj
 *
 */
public class Zhangsan {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Thread readData;
		ReceiveLetterForZhang reciver = new ReceiveLetterForZhang();
		try {
			readData = new Thread(reciver);
			readData.start();
			byte []b = new byte[1];
			//给主机是1270.0.1 的666端口发送信息
			InetAddress address = InetAddress.getByName("127.0.0.1"); 
			DatagramPacket dataPack = new DatagramPacket(b, b.length,address,666); //创建一个发送数据包
			DatagramSocket postman = new DatagramSocket(); //用于发送信息
			System.out.println("输入发送给李四的信息");
			while(s.hasNext()){
				String mess = s.nextLine();
				b = mess.getBytes();
				if(mess.length()==0){
					System.exit(0);
				}
				b = mess.getBytes();
				dataPack.setData(b); //给数据包传入内容
				postman.send(dataPack); //发送数据包
				System.out.println("继续输入发送给李四的信息:");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class ReceiveLetterForZhang implements Runnable {
	
	@Override
	public void run() {
		DatagramPacket pack = null;
		DatagramSocket postman = null;
		byte []b = new byte[8192];
		try {
			pack = new DatagramPacket(b, b.length);
			postman = new DatagramSocket(888); //获取888端口的对象
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		while(true){
			if(postman==null){
				break;
			}
			else {
				try {
					postman.receive(pack); //接受数据
					String mess = new String(pack.getData(),0,pack.getLength());
					System.out.printf("%25s\n","收到"+mess);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
