package homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 
 * @author lcj
 *
 */
public class Server {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm1 = null,pstm2 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			pstm1 = conn.prepareStatement("select * from cargo where number=?");
			pstm2 = conn.prepareStatement("select * from cargo where name=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ServerSocket server = null;
		Runnable target;
		Thread threadForClient = null;
		Socket socketOnServer = null;
		
		while(true){
			try {
				server = new ServerSocket(4331);
			} catch (IOException e) {
				System.out.println("���ڼ���");
			}
			try {
				System.out.println("�ȴ��ͻ�����");
				socketOnServer = server.accept();
				System.out.println("�ͻ��ĵ�ַ:"+socketOnServer.getInetAddress());
			} catch (IOException e) {
				System.out.println("���ڵȴ��ͻ�");
			}
			if(socketOnServer!=null){
				target = new Target(socketOnServer, pstm1, pstm2);
				threadForClient = new Thread(target);
				threadForClient.start();
			}
		}
	}
}

class Target extends Thread {
	Socket socket;
	DataInputStream in = null;
	DataOutputStream out = null;
	PreparedStatement pstm1,pstm2;
	boolean boo = false;
	public Target(Socket socket,PreparedStatement pstm1,PreparedStatement pstm2) {
		this.socket = socket;
		this.pstm1 = pstm1;
		this.pstm2 = pstm2;
		try {
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		ResultSet rs = null;
		while(true){
			try {
				String str = in.readUTF();
				if(str.startsWith("number:")){
					str = str.substring(str.indexOf(":")+1);
					pstm1.setString(1, str);
					rs = pstm1.executeQuery();
				}
				else if(str.startsWith("name")){
					str = str.substring(str.indexOf(":")+1);
					pstm2.setString(1, str);
					rs = pstm2.executeQuery();
				}
				
				while(rs.next()){
					boo = true;
					String number = rs.getString(1);
					String name = rs.getString(2);
					Date time = rs.getDate(3);
					double price = rs.getDouble(4);
					out.writeUTF("���ͺ�:"+number+"����:"+name+"��������:"+time+"�۸�:"+price);
				}
				if(boo==false){
					out.writeUTF("û�иó��ͺ�");
				}
			} catch (IOException | SQLException e) {
				System.out.println("�ͻ��뿪:"+e);
				return;
			}
		}
	}
}
