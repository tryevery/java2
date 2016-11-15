package com.test13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 用于接受张三用udp发送来的信息
 * @author lcj
 *
 */
public class Lisi {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Thread readData;
		ReceiveLetterForLi reciver = new ReceiveLetterForLi();
		try {
			readData = new Thread(reciver);
			readData.start();
			byte []b = new byte[1];
			InetAddress address = InetAddress.getByName("127.0.0.1"); //获取主机地址
			DatagramPacket dataPack = new DatagramPacket(b, b.length,address,888); //创建一个向主机888端口发送的数据包
			DatagramSocket postman = new DatagramSocket(); //创建一个发送对象
			System.out.println("输入发送给张三的信息");
			while(s.hasNext()){
				String mess = s.nextLine();
				b = mess.getBytes();
				if(mess.length()==0){
					System.exit(0);
				}
				b = mess.getBytes();
				dataPack.setData(b);
				postman.send(dataPack); //发送数据包
				System.out.println("继续输入发送给张三的信息:");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class ReceiveLetterForLi implements Runnable {
	
	@Override
	public void run() {
		DatagramPacket pack = null;
		DatagramSocket postman = null;
		byte []b = new byte[8192];
		try {
			pack = new DatagramPacket(b, b.length); //获取666端口发送数据包的内容
			postman = new DatagramSocket(666); //接受666端口的对象
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		while(true){
			if(postman==null){
				break;
			}
			else {
				try {
					postman.receive(pack); //接受数据包
					String mess = new String(pack.getData(),0,pack.getLength());
					System.out.printf("%25s\n","收到"+mess);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}