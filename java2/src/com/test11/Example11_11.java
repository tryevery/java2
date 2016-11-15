package com.test11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 批处理+事务处理
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
			stm.addBatch("insert into cargo values('D004','东风','2009-10-05',300000)");
			int []number = stm.executeBatch();
			conn.commit();
			System.out.println("共有"+number.length+"条sql语句被执行");
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
