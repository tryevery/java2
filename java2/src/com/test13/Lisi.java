package com.test13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * ���ڽ���������udp����������Ϣ
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
			InetAddress address = InetAddress.getByName("127.0.0.1"); //��ȡ������ַ
			DatagramPacket dataPack = new DatagramPacket(b, b.length,address,888); //����һ��������888�˿ڷ��͵����ݰ�
			DatagramSocket postman = new DatagramSocket(); //����һ�����Ͷ���
			System.out.println("���뷢�͸���������Ϣ");
			while(s.hasNext()){
				String mess = s.nextLine();
				b = mess.getBytes();
				if(mess.length()==0){
					System.exit(0);
				}
				b = mess.getBytes();
				dataPack.setData(b);
				postman.send(dataPack); //�������ݰ�
				System.out.println("�������뷢�͸���������Ϣ:");
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
			pack = new DatagramPacket(b, b.length); //��ȡ666�˿ڷ������ݰ�������
			postman = new DatagramSocket(666); //����666�˿ڵĶ���
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		while(true){
			if(postman==null){
				break;
			}
			else {
				try {
					postman.receive(pack); //�������ݰ�
					String mess = new String(pack.getData(),0,pack.getLength());
					System.out.printf("%25s\n","�յ�"+mess);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
}