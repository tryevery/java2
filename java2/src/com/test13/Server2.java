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
				System.out.println("���ڼ���");
			}
			try {
				System.out.println("�ȴ��û�����");
				you = server.accept();
				System.out.println("�ͻ��ĵ�ַ:"+you.getInetAddress());
			} catch (IOException e) {
				System.out.println("���ڵȴ��ͻ�");
			}
			if(you!=null){
				new ServerThread(you).start();  //Ϊÿ���ͻ�ר������һ���߳�
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
				double r = in.readDouble(); //����״̬,���Ƕ�ȡ����Ϣ
				double area = Math.PI*r*r;
				out.writeDouble(area);
			} catch (IOException e) {
				System.out.println("�ͻ��뿪");
				return;
			}
		}
	}
	
}