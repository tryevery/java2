package com.test11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

/**
 * 预处理语句PreparedStatement
 * @author lcj
 *
 */
public class Example11_8 {
	public static void main(String[] args) {
		PreparedQuery query = new PreparedQuery();
		query.setTableName("goods");
		query.setSql("select * from "+query.getTableName());
		query.inputQueryResult();
	}
}


class PreparedQuery {
	String tableName = null; //表名
	String sql = null;       //sql语句
	public PreparedQuery() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public void inputQueryResult(){
		Connection conn;
		PreparedStatement pstm;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "root");
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
			int column = 0;
			while(rs1.next()){
				column++;
			}
			
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				for(int i=1;i<=column;i++){
					System.out.printf(" "+rs.getString(i)+" ");
				}
				System.out.println();
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("请输入正确的表名:"+e);
		}
		
	}
}