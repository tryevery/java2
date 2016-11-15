package com.test11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.rowset.*;

/**
 * CachedRowSetImp 可以保存结果及对象,即使关闭了conn连接也可便利数据
 * @author lcj
 *
 */
public class Example11_12 {
	public static void main(String[] args) {
		CachedQuery query = new CachedQuery();
		query.setTableName("cargo");
		query.setSql("select * from "+query.getTableName());
		query.inputQueryResult();
	}
}


class CachedQuery {
	String tableName = "";
	String sql;
	Connection conn = null;
	DBConnection db = new DBConnection();
	public CachedQuery() {
		conn = db.getConnection();
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
		Statement stm = null;
		ResultSet rs = null;
		CachedRowSetImpl rowSet;
		try {
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
			int column = 0;
			while(rs1.next()){
				column++;
			}
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
			rowSet = new CachedRowSetImpl();  //缓冲结果集
			rowSet.populate(rs);
			conn.close();
			while(rowSet.next()){
				for(int i=1;i<=column;i++){
					System.out.printf(" "+rowSet.getString(i)+" ");
				}
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("请输入正确的表名");
			e.printStackTrace();
		}
		
	}
}