package homework13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	public static void main(String[] args) {
		new QueryClient();
	}
}

class QueryClient extends JFrame implements Runnable, ActionListener {
	JButton connection, sendNumber, sendName;
	JTextField inputNumber, inputName;
	JTextArea showResult;
	Socket socket = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	Thread thread;

	public QueryClient() {
		socket = new Socket();
		JPanel p = new JPanel();
		connection = new JButton("连接服务器");
		sendNumber = new JButton("发送车号");
		sendNumber.setEnabled(false);
		sendName = new JButton("发送车名");
		sendName.setEnabled(false);
		inputName = new JTextField(8);
		inputNumber = new JTextField(8);
		showResult = new JTextArea(6, 42);
		p.add(connection);
		p.add(new JLabel("输入车号:"));
		p.add(inputNumber);
		p.add(sendNumber);
		p.add(new JLabel("输入车名:"));
		p.add(inputName);
		p.add(sendName);

		add(p, BorderLayout.NORTH);
		add(showResult, BorderLayout.CENTER);
		connection.addActionListener(this);
		sendName.addActionListener(this);
		sendNumber.addActionListener(this);
		thread = new Thread(this);
		setBounds(10, 30, 350, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		validate();
	}

	@Override
	public void run() {
		String s = null;
		while(true){
			try {
				s = in.readUTF();
				showResult.append("\n"+s);
			} catch (IOException e) {
				showResult.setText("与服务器断开连接");
				break;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == connection) {
			try {
				if (socket.isConnected()) {
				} else {
					InetAddress address = InetAddress.getByName("127.0.0.1");
					InetSocketAddress socketAddress = new InetSocketAddress(address, 4331);
					socket.connect(socketAddress);
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					sendName.setEnabled(true);
					sendNumber.setEnabled(true);
					thread.start();
				}
			} catch (IOException e1) {
				socket = new Socket();
			}
		}
		
		else if(e.getSource()==sendNumber){
			String str = inputNumber.getText();
			if(str!=null){
				try {
					out.writeUTF("number:"+str);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource()==sendName){
			String str = inputName.getText();
			if(str!=null){
				try {
					out.writeUTF("name:"+str);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

}
