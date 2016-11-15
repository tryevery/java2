package com.test11;

/**
 * 条件查询
 * @author lcj
 *
 */
public class Example11_4 {
	public static void main(String[] args) {
		Query query = new Query();
		String tableName = "goods";
		query.setTableName(tableName);
		int id = 1;
		String sql = "select * from "+tableName+" where id="+id;
		query.setSql(sql);
		System.out.println(tableName+"表中的商品是"+id+"的记录");
		query.inputQueryResult();
		double max = 300000,min = 299988;
		sql = "select * from "+tableName+" where price >="+min+" and price <="+max;
		query.setSql(sql);
		System.out.println(tableName+"表价格在"+min+"和"+max+"之间的记录");
		query.inputQueryResult();
	}
}
