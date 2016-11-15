package com.test11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ������
 * @author lcj
 *
 */
public class Example11_10 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stm;
		ResultSet rs;
		Scanner s = new Scanner(System.in);
		double n = s.nextDouble();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","root");
			conn.setAutoCommit(false); //�ر��Զ��ύ
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from cargo where number='A001'");
			rs.next();
			double priceOne = rs.getDouble("price");
			System.out.println("�������ǰ��A001��price"+priceOne);
			rs = stm.executeQuery("select * from cargo where number='B002'");
			rs.next();
			double priceTwo = rs.getDouble("price");
			System.out.println("�������ǰ��B002��price"+priceTwo);
			priceOne -=n;
			priceTwo +=n;
			stm.executeUpdate("update cargo set price ="+priceOne+" where number ='A001'");
			stm.executeUpdate("update cargo set price ="+priceTwo+" where number ='B002'");
			conn.commit();
			conn.setAutoCommit(true);
			
			rs = stm.executeQuery("select * from cargo where number='A001'");
			rs.next();
			priceOne = rs.getDouble("price");
			System.out.println("����������A001��price"+priceOne);
			rs = stm.executeQuery("select * from cargo where number='B002'");
			rs.next();
			priceTwo = rs.getDouble("price");
			System.out.println("����������B002��price"+priceTwo);
			conn.close();
		} catch (SQLException e) {
			try {
				conn.rollback(); //�����������
			} catch (SQLException e1) {}
			System.out.println(e);
		}
		
	}
}


