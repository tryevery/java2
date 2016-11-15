package com.test13;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 实现套接字连接,客户端向服务器端发出问题,服务器端回应
 * @author lcj
 *
 */
public class Client1 {
	public static void main(String[] args) {
		String []mess = {"2010世界杯在那里举行","巴西进入世界杯了吗?","中国进入世界杯了吗?"};
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
				System.out.println("客户收到服务器的回答:"+s);
				Thread.sleep(500);
			}
			
		} catch (Exception e) {
			System.out.println("服务器已断开"+e);
			e.printStackTrace();
		}
		
	}
}
