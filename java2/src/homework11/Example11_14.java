package homework11;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.test11.DBConnection;

/**
 * 用表格显示数据库中的数据
 * @author lcj
 *
 */
public class Example11_14 {
	public static void main(String[] args) {
		JTable table;
		Query query = new Query();
		query.setTableName("cargo");
		Object [][]a = query.getRecord();
		int m = a[0].length;
		String []b = new String[m];
		for(int i=0;i<m;i++){
			b[i] = "字段"+(i+1);
		}
		table = new JTable(a, b);
		JFrame frame = new JFrame();
		frame.add(new JScrollPane(table));
		frame.setVisible(true);
		frame.setBounds(20, 20, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

class Query {
	String tableName = "";
	Object [][]a;
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	public Query() {
		DBConnection db = new DBConnection();
		conn = db.getConnection();
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public Object[][] getRecord(){
		try {
			DatabaseMetaData metadata = conn.getMetaData();
			ResultSet rs1 = metadata.getColumns(null, null, tableName, null);
			int colum = 0;
			while(rs1.next()){
				colum++;
			}
			int n = getAmount();
			a = new Object[n][colum];
			pstm = conn.prepareStatement("select * from "+tableName);
			rs = pstm.executeQuery();
			int m = 0;
			while(rs.next()){
				for(int i=1;i<=colum;i++){
					a[m][i-1] = rs.getString(i);
				}
				m++;
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("请输入正确的表名");
			e.printStackTrace();
		}
		return a;
	}
	private int getAmount() {
		Statement stm = null;
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery("select * from "+tableName);
			rs.last();
			int rows = rs.getRow();
			return rows;
		} catch (SQLException e) {
			System.out.println(" "+e);
			return 0;
		}
	}
	
}
