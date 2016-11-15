package com.test11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 使用conn对象的getMetaDate()方法获得表中的字段名
 * 
 * @author lcj
 *
 */
public class Example11_2 {
	public static void main(String[] args) {
		Query query = new Query();
		query.setTableName("goods");
		query.setSql("select * from " + query.getTableName() );
		query.inputQueryResult();
	}
}

class Query {
	String tableName = null;//表名
	String sql = null;  //sql语句

	public void setTableName(String tableName) {
		this.tableName = tableName.trim();
	}

	public String getTableName() {
		return tableName.trim();
	}

	public void setSql(String sql) {
		this.sql = sql.trim();
	}

	public Query() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void inputQueryResult() {
		Connection conn;
		PreparedStatement pstm = null;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root","root");
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
			int columns = 0;
			while(rs1.next()){
				columns++;
			}
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				for(int i=1;i<=columns;i++){
					System.out.print(" "+rs.getString(i)+" ");
				}
				System.out.println();
			}
			conn.close();
			pstm.close();
			rs.close();
			rs1.close();
		} catch (SQLException e) {
			System.out.println("请输入正确的表名"+e);
		}
	}
}
