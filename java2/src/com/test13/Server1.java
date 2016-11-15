package com.test13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	private static ServerSocket serverForClient;

	public static void main(String[] args) {
		String []answer = {"南非","进入世界杯","哈哈....问题振逗"};
		Socket socketOnServer = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			serverForClient = new ServerSocket(2010);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("等待用户的呼叫");
			socketOnServer = serverForClient.accept();
			out = new DataOutputStream(socketOnServer.getOutputStream());
			in = new DataInputStream(socketOnServer.getInputStream());
			for(int i=0;i<answer.length;i++){
				String s = in.readUTF();
				System.out.println("服务器收到用户的请求:"+s);
				out.writeUTF(answer[i]);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("客户已经断开:"+e);
		}
		
	}
}
