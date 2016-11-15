package homework11;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Scanner;

import com.test11.DBConnection;

/**
 * 用数据库事项第十章的标准化考试
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
			System.out.println("没有试题无法考试");
			System.exit(0);
		}
		System.out.println(amount);
		System.out.printf("试卷共有%d道题目",amount);
		System.out.println("输入题号:开始考试");
		while(s.hasNextInt()){
			int number = s.nextInt();
			String huiche = s.nextLine();
			if(number==1&&number<=amount+1){
				String []timu = read.getExamQuestion(number);
				for(int i=0;i<timu.length-1;i++){
					System.out.println(timu[i]);
				}
				System.out.printf("输入你的选择:");
				String answer = s.nextLine();
				if(answer.compareToIgnoreCase(timu[5])==0){
					System.out.println("第"+number+"题做对了");
				}else 
					System.out.println("第"+number+"题做错了");
				System.out.printf("输入任意字母结束考试\t,输入题号继续考试: ");
			}else{
				System.out.println("题号不合理");
				System.out.printf("输入任意字母结束考试\t,输入题号继续考试: ");
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
			System.out.println("无法获得试题");
			e.printStackTrace();
		}
		return exam;
	}
}
