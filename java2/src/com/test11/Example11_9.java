package com.test11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ʹ��ͨ��� ?
 * @author lcj
 *
 */
public class Example11_9 {
	public static void main(String[] args) {
		AddRecord add = new AddRecord();
		add.setTableName("goods");
		add.setId(5);
		add.setName("���ǵ�");
		add.setMadeTime("2016-7-01");
		add.setPrice(200000);
		String backMess = add.addRecord();
		System.out.println(backMess);
	}
}

class AddRecord {
	String tableName = null;
	String sql = null;
	int id;
	String name,madeTime;
	double price;
	public AddRecord() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMadeTime(String madeTime) {
		this.madeTime = madeTime;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String addRecord(){
		String str = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
			sql = "INSERT INTO goods VALUES(?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			if(id>4){
				pstm.setInt(1, id);
				pstm.setString(2, name);
				pstm.setString(3, madeTime);
				pstm.setDouble(4, price);
				int m = pstm.executeUpdate();
				if(m!=0){
					str = "�Ա������"+m+"����¼�ɹ�";
				}else str = "��Ӽ�¼ʧ��";
			}
			
			conn.close();
		} catch (SQLException e) {
			str = "û���ṩ��ӵ�����"+e;
		}
		return str;
	}
	
}
