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
 * �ͻ�������Բ�İ뾶,�������˼���󷵻ؿͻ���
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
				System.out.println("�����������ip");
				String ip = s.nextLine();
				System.out.println("����˿�");
				int port = s.nextInt();
				if(mysocket.isConnected()){}
				else {
					InetAddress address;
					address = InetAddress.getByName(ip); //��÷���������
					//SocketAddress������������׽������Ӻ͵�ַ
					InetSocketAddress socketAddress = new InetSocketAddress(address, port);
					mysocket.connect(socketAddress);
					in = new DataInputStream(mysocket.getInputStream());
					out = new DataOutputStream(mysocket.getOutputStream());
					read.setIn(in);
					readData.start(); //����������ȡ��Ϣ���߳�
				}
			} catch (Exception e) {
				System.out.println("��������Ͽ���ϵ");
				e.printStackTrace();
			}
			System.out.println("����Բ�İ뾶(����������N):");
			while(s.hasNext()){
				double redius = 0;
				try {
					redius = s.nextDouble();					
				} catch (Exception e) {
					System.exit(0);
				}
				
				try {
					out.writeDouble(redius);  //�������������Ϣ
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
				System.out.println("Բ�����:"+result);
				System.out.println("����Բ�İ뾶(����������N):");
			} catch (IOException e) {
				System.out.println("��������Ͽ�"+e);
				break;
			}
		}
		
	}
	
}
