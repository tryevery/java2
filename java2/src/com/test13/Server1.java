package com.test13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	private static ServerSocket serverForClient;

	public static void main(String[] args) {
		String []answer = {"�Ϸ�","�������籭","����....������"};
		Socket socketOnServer = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			serverForClient = new ServerSocket(2010);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("�ȴ��û��ĺ���");
			socketOnServer = serverForClient.accept();
			out = new DataOutputStream(socketOnServer.getOutputStream());
			in = new DataInputStream(socketOnServer.getInputStream());
			for(int i=0;i<answer.length;i++){
				String s = in.readUTF();
				System.out.println("�������յ��û�������:"+s);
				out.writeUTF(answer[i]);
				Thread.sleep(500);
			}
		} catch (Exception e) {
			System.out.println("�ͻ��Ѿ��Ͽ�:"+e);
		}
		
	}
}
