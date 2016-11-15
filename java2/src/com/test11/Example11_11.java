package com.test11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ������+������
 * @author lcj
 *
 */
public class Example11_11 {
	public static void main(String[] args) {
		Connection conn;
		Statement stm;
		ResultSet rs;
		DBConnection db = new DBConnection();
		conn = db.getConnection();
		try {
			conn.setAutoCommit(false);
			stm = conn.createStatement();
			stm.addBatch("update cargo set price = 55555 where number='C003'");
			stm.addBatch("insert into cargo values('D004','����','2009-10-05',300000)");
			int []number = stm.executeBatch();
			conn.commit();
			System.out.println("����"+number.length+"��sql��䱻ִ��");
			stm.clearBatch();
			conn.close();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
