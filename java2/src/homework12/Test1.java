package homework12;

/**
 * Э��ͬ�����߳�,ģ����Ʊ
 * @author lcj
 *
 */
public class Test1 {
	public static void main(String[] args) {
		TicketHouse house = new TicketHouse();
		Thread zhang,li,zhao;
		zhang = new Thread(house);
		zhang.setName("�ŷ�");
		li = new Thread(house);
		li.setName("����");
		zhao = new Thread(house);
		zhao.setName("����");
		zhang.start();
		li.start();
		zhao.start();
	}
}

class TicketHouse implements Runnable {
	int fiveAmount = 3,tenAmount = 0,twentyAmount = 0;
	
	@Override
	public void run() {
		if(Thread.currentThread().getName().equals("�ŷ�")){
			saleTicket(20);
		}
		else if(Thread.currentThread().getName().equals("����")){
			saleTicket(10);
		}
		else if(Thread.currentThread().getName().equals("����")){
			saleTicket(5);
		}
		
	}
	
	private synchronized void saleTicket(int money){
		if(money == 5 ){
			fiveAmount = fiveAmount+1;
			System.out.println("��"+Thread.currentThread().getName()+"�볡��,"+Thread.currentThread().getName()+"��Ǯ����");
		}
		if(money==10){
			while(fiveAmount<1){
				try {
					System.out.println("\n"+Thread.currentThread().getName()+"���ߵ�");
					wait();
					System.out.println("\n"+Thread.currentThread().getName()+"������Ʊ");
					
				} catch (InterruptedException e) {
				}
			}
			fiveAmount = fiveAmount-1;
			tenAmount = tenAmount+1;
			System.out.println("��"+Thread.currentThread().getName()+"�볡��,"+Thread.currentThread().getName()+"��10����5");
		}
		else if(money ==20 ){
			
			while(fiveAmount<3){
				try {
					System.out.println("\n"+Thread.currentThread().getName()+"���ߵ�");
					wait();
					System.out.println("\n"+Thread.currentThread().getName()+"������Ʊ");
					
				} catch (InterruptedException e) {
				}
			}
			fiveAmount = fiveAmount-3;
			twentyAmount = twentyAmount+1;
			System.out.println("��"+Thread.currentThread().getName()+"�볡��,"+Thread.currentThread().getName()+"��20����15");	
		}
		notifyAll();
	}
	
}
