package com.test7;
/**
 * 这是一个模拟装载货物的例子
 * P172
 * @author lcj
 *
 */

class DangerException extends Exception{
	final String message = "超重";
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
		System.out.println("目前装载了"+realContent+"吨货物");
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
			System.out.println("无法在装载重量是"+m+"吨的集装箱");
		}
		finally{
			System.out.println("货轮将准时启航");
		}
	}
}
