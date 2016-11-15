package homework11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

import com.test11.DBConnection;

/**
 * �����ݿ������ʮ�µı�׼������
 * @author lcj
 *
 */
public class Example11_13 {
	public static void main(String[] args) {
		ReadExaminationPaper read;
		read = new ReadExaminationPaper();
		read.setTableName("testFrom");
		Scanner s = new Scanner(System.in);
		int amount = read.getAmount();
		if(amount==0){
			System.out.println("û�������޷�����");
			System.exit(0);
		}
		System.out.println(amount);
		System.out.printf("�Ծ���%d����Ŀ",amount);
		System.out.println("�������:��ʼ����");
		while(s.hasNextInt()){
			int number = s.nextInt();
			String huiche = s.nextLine();
			if(number==1&&number<=amount+1){
				String []timu = read.getExamQuestion(number);
				for(int i=0;i<timu.length-1;i++){
					System.out.println(timu[i]);
				}
				System.out.printf("�������ѡ��:");
				String answer = s.nextLine();
				if(answer.compareToIgnoreCase(timu[5])==0){
					System.out.println("��"+number+"��������");
				}else 
					System.out.println("��"+number+"��������");
				System.out.printf("����������ĸ��������\t,������ż�������: ");
			}else{
				System.out.println("��Ų�����");
				System.out.printf("����������ĸ��������\t,������ż�������: ");
			}
		}
	}
}

class ReadExaminationPaper {
	String tableName;
	

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	public String getTableName() {
		return tableName;
	}


	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	public ReadExaminationPaper() {
		DBConnection db = new DBConnection();
		conn = db.getConnection();
	}
	
	public int getAmount(){
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery("select * from "+tableName);
			rs.last();
			int rows = rs.getRow();
			return rows;
		} catch (SQLException e) {
			System.out.println(""+e);
			return 0;
		}
	}
	
	public String[] getExamQuestion(int number){
		String []exam = new String[6];
		try {
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery("select * from testFrom");
			rs.absolute(number);
			for(int i=0;i<6;i++){
				exam[i]=rs.getString(i+1);
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println("�޷��������");
			e.printStackTrace();
		}
		return exam;
	}
}
