package com.test7;
/**
 * ����һ��ģ��װ�ػ��������
 * P172
 * @author lcj
 *
 */

class DangerException extends Exception{
	final String message = "����";
	public String warnMess(){
		return message;
	}
}

class CargoBoat{
	int realContent;
	int maxContent;
	public void setMaxContent(int c){
		maxContent = c;
	}
	public void loading(int m) throws DangerException{
		realContent += m;
		if(realContent > maxContent){
			realContent -= m;
			throw new DangerException();
		}
		System.out.println("Ŀǰװ����"+realContent+"�ֻ���");
	}
}
public class Example7_7 {
	public static void main(String[] args) {
		CargoBoat ship = new CargoBoat();
		ship.setMaxContent(1000);
		int m =600;
		try {
			ship.loading(m);
			m=300;
			ship.loading(m);
			m=100;
			ship.loading(m);
		} catch (DangerException e) {
			System.out.println(e.warnMess());
			System.out.println("�޷���װ��������"+m+"�ֵļ�װ��");
		}
		finally{
			System.out.println("���ֽ�׼ʱ����");
		}
	}
}
