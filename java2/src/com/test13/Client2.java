package com.test13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

/**
 * 客户端输入圆的半径,服务器端计算后返回客户端
 * @author lcj
 *
 */
public class Client2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Socket mysocket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		Thread readData;
			try {
				Read read = null;
				mysocket = new Socket();
				read = new Read();
				readData = new Thread(read);
				System.out.println("输入服务器的ip");
				String ip = s.nextLine();
				System.out.println("输入端口");
				int port = s.nextInt();
				if(mysocket.isConnected()){}
				else {
					InetAddress address;
					address = InetAddress.getByName(ip); //获得服务器名称
					//SocketAddress的子类来获得套接字连接和地址
					InetSocketAddress socketAddress = new InetSocketAddress(address, port);
					mysocket.connect(socketAddress);
					in = new DataInputStream(mysocket.getInputStream());
					out = new DataOutputStream(mysocket.getOutputStream());
					read.setIn(in);
					readData.start(); //负责启动读取信息的线程
				}
			} catch (Exception e) {
				System.out.println("与服务器断开联系");
				e.printStackTrace();
			}
			System.out.println("输入圆的半径(放弃请输入N):");
			while(s.hasNext()){
				double redius = 0;
				try {
					redius = s.nextDouble();					
				} catch (Exception e) {
					System.exit(0);
				}
				
				try {
					out.writeDouble(redius);  //向服务器发送信息
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}
}

class Read implements Runnable{
	DataInputStream in;
	
	public void setIn(DataInputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		double result = 0;
		while(true){
			try {
				result = in.readDouble();
				System.out.println("圆的面积:"+result);
				System.out.println("输入圆的半径(放弃请输入N):");
			} catch (IOException e) {
				System.out.println("与服务器断开"+e);
				break;
			}
		}
		
	}
	
}
