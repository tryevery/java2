package com.test11;


/**
 * �����ѯ
 * @author lcj
 *
 */
public class Example11_5 {
	public static void main(String[] args) {
		Query query = new Query();
		String tableName = "goods";
		query.setTableName(tableName);
		String sql = "select * from goods order by name";
		query.setSql(sql);
		System.out.println("����Ʒ��������:");
		query.inputQueryResult();
		sql = "select * from goods order by price asc";
		query.setSql(sql);
		System.out.println("����Ʒ�۸�����:");
		query.inputQueryResult();
		
	}
}
