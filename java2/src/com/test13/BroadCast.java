package com.test13;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 广播数据报,
 * 一个D类地址称为一个组播地址
 * @author lcj
 *
 */
public class BroadCast {
	String s = "国庆放假时间是9月30号";
	int port = 5858;
	InetAddress group = null;
	MulticastSocket socket = null;
	public BroadCast(){
		try {
			group = InetAddress.getByName("239.255.8.0"); //设置广播组的地址为239.255.8.0
			socket = new MulticastSocket(port); //多点广播套接字发送数据报范围为本地网络
			socket.setTimeToLive(1);//多点广播套接字发送数据范围为本地网络
			socket.joinGroup(group);
			//加入group后,socket发送的数据报被group中的成员接收到
			
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
