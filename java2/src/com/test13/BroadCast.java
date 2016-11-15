package com.test13;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * �㲥���ݱ�,
 * һ��D���ַ��Ϊһ���鲥��ַ
 * @author lcj
 *
 */
public class BroadCast {
	String s = "����ż�ʱ����9��30��";
	int port = 5858;
	InetAddress group = null;
	MulticastSocket socket = null;
	public BroadCast(){
		try {
			group = InetAddress.getByName("239.255.8.0"); //���ù㲥��ĵ�ַΪ239.255.8.0
			socket = new MulticastSocket(port); //���㲥�׽��ַ������ݱ���ΧΪ��������
			socket.setTimeToLive(1);//���㲥�׽��ַ������ݷ�ΧΪ��������
			socket.joinGroup(group);
			//����group��,socket���͵����ݱ���group�еĳ�Ա���յ�
			
		} catch (Exception e) {
			System.out.println("ERROE:"+e);
		}
	}
	
	public void play() {
		while(true){
			try {
				DatagramPacket packet = null;
				byte data[] = s.getBytes();
				packet = new DatagramPacket(data, data.length,group , port);
				System.out.println(new String(data));
				socket.send(packet);
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("Error:"+e);
			}
		}
	}
	
	public static void main(String[] args) {
		new BroadCast().play();
	}
}
