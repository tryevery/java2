package com.test11;

/**
 * ������ѯ
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
		System.out.println(tableName+"���е���Ʒ��"+id+"�ļ�¼");
		query.inputQueryResult();
		double max = 300000,min = 299988;
		sql = "select * from "+tableName+" where price >="+min+" and price <="+max;
		query.setSql(sql);
		System.out.println(tableName+"��۸���"+min+"��"+max+"֮��ļ�¼");
		query.inputQueryResult();
	}
}
