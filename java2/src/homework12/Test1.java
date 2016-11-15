package homework12;

/**
 * 协调同步的线程,模拟买票
 * @author lcj
 *
 */
public class Test1 {
	public static void main(String[] args) {
		TicketHouse house = new TicketHouse();
		Thread zhang,li,zhao;
		zhang = new Thread(house);
		zhang.setName("张飞");
		li = new Thread(house);
		li.setName("李四");
		zhao = new Thread(house);
		zhao.setName("赵三");
		zhang.start();
		li.start();
		zhao.start();
	}
}

class TicketHouse implements Runnable {
	int fiveAmount = 3,tenAmount = 0,twentyAmount = 0;
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("张飞")){
			saleTicket(20);
		}
		else if(Thread.currentThread().getName().equals("李四")){
			saleTicket(10);
		}
		else if(Thread.currentThread().getName().equals("赵三")){
			saleTicket(5);
		}
		
	}
	
	private synchronized void saleTicket(int money){
		if(money == 5 ){
			fiveAmount = fiveAmount+1;
			System.out.println("给"+Thread.currentThread().getName()+"入场卷,"+Thread.currentThread().getName()+"的钱正好");
		}
		if(money==10){
			while(fiveAmount<1){
				try {
					System.out.println("\n"+Thread.currentThread().getName()+"靠边等");
					wait();
					System.out.println("\n"+Thread.currentThread().getName()+"继续买票");
					
				} catch (InterruptedException e) {
				}
			}
			fiveAmount = fiveAmount-1;
			tenAmount = tenAmount+1;
			System.out.println("给"+Thread.currentThread().getName()+"入场卷,"+Thread.currentThread().getName()+"给10找零5");
		}
		else if(money ==20 ){
			
			while(fiveAmount<3){
				try {
					System.out.println("\n"+Thread.currentThread().getName()+"靠边等");
					wait();
					System.out.println("\n"+Thread.currentThread().getName()+"继续买票");
					
				} catch (InterruptedException e) {
				}
			}
			fiveAmount = fiveAmount-3;
			twentyAmount = twentyAmount+1;
			System.out.println("给"+Thread.currentThread().getName()+"入场卷,"+Thread.currentThread().getName()+"给20找零15");	
		}
		notifyAll();
	}
	
}
