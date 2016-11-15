package com.test11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 更新,添加,删除操作表中的数据
 * @author lcj
 *
 */
public class Example11_7 {
	public static void main(String[] args) {
		ModifyTable mo = new ModifyTable();
		String sql = "update goods set price = 3009 where name ='路虎'";
		mo.setSql(sql);
		String backMess = mo.modifyRecord();
		System.out.println(backMess);
		mo.setSql("insert into goods values(4,'手机','2016-10-09',789789)");
		backMess = mo.modifyRecord();
		System.out.println(backMess);
	}
}


class ModifyTable {
	String sql,message="";
	public ModifyTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public String modifyRecord(){
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			/*原来的连接url：Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "letmein");

			现在的连接url:Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root", "letmein");*/
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			pstm = conn.prepareStatement(sql);
			pstm.execute();
			message = "操作成功!";
			conn.close();
		} catch (SQLException e) {
			message = e.toString();
		}
		return message;
	}
}