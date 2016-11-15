package homework12;


public class E {
	public static void main(String[] args) {
		Target t = new Target();
		Thread thread = new Thread(t);
		t.run();
		for(int i=0;i<=10;i++){
			System.out.println("yes");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


class Target implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<=10;i++){
			System.out.println("ok");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}