package com.test13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	public static void main(String[] args) {
		ServerSocket server = null;
		ServerThread thread;
		Socket you = null;
		while(true){
			try {
				server = new ServerSocket(2010);
			} catch (IOException e) {
				System.out.println("正在监听");
			}
			try {
				System.out.println("等待用户呼叫");
				you = server.accept();
				System.out.println("客户的地址:"+you.getInetAddress());
			} catch (IOException e) {
				System.out.println("正在等待客户");
			}
			if(you!=null){
				new ServerThread(you).start();  //为每个客户专门启动一个线程
			}
		}
	}
}

class ServerThread extends Thread{
	Socket socket;
	DataInputStream in = null;
	DataOutputStream out = null;
	String s = null;
	public ServerThread(Socket s) {
		socket = s;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
		}
		
	}

	@Override
	public void run() {
		while(true){
			try {
				double r = in.readDouble(); //阻塞状态,除非读取到信息
				double area = Math.PI*r*r;
				out.writeDouble(area);
			} catch (IOException e) {
				System.out.println("客户离开");
				return;
			}
		}
	}
	
}