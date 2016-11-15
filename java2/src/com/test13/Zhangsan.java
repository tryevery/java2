package com.test13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * ��������
 * ͨ���û����ݱ����෢����Ϣ
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
			//��������1270.0.1 ��666�˿ڷ�����Ϣ
			InetAddress address = InetAddress.getByName("127.0.0.1"); 
			DatagramPacket dataPack = new DatagramPacket(b, b.length,address,666); //����һ���������ݰ�
			DatagramSocket postman = new DatagramSocket(); //���ڷ�����Ϣ
			System.out.println("���뷢�͸����ĵ���Ϣ");
			while(s.hasNext()){
				String mess = s.nextLine();
				b = mess.getBytes();
				if(mess.length()==0){
					System.exit(0);
				}
				b = mess.getBytes();
				dataPack.setData(b); //�����ݰ���������
				postman.send(dataPack); //�������ݰ�
				System.out.println("�������뷢�͸����ĵ���Ϣ:");
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
			postman = new DatagramSocket(888); //��ȡ888�˿ڵĶ���
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		while(true){
			if(postman==null){
				break;
			}
			else {
				try {
					postman.receive(pack); //��������
					String mess = new String(pack.getData(),0,pack.getLength());
					System.out.printf("%25s\n","�յ�"+mess);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}
