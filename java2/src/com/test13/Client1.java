package com.test13;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * ʵ���׽�������,�ͻ�����������˷�������,�������˻�Ӧ
 * @author lcj
 *
 */
public class Client1 {
	public static void main(String[] args) {
		String []mess = {"2010���籭���������","�����������籭����?","�й��������籭����?"};
		Socket socket;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket = new Socket("127.0.0.1", 2010);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			for(int i=0;i<mess.length;i++){
				out.writeUTF(mess[i]);
				String s = in.readUTF();
				System.out.println("�ͻ��յ��������Ļش�:"+s);
				Thread.sleep(500);
			}
			
		} catch (Exception e) {
			System.out.println("�������ѶϿ�"+e);
			e.printStackTrace();
		}
		
	}
}
