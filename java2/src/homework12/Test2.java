package homework12;


/**
 * currentThread 和 interrupt() 用来获取当前正在使用资源的线程以及唤醒休眠的线程
 * 下面是一个唤醒线程的小案例
 * @author lcj
 *
 */
public class Test2 {
	public static void main(String[] args) {
		ClassRoom room = new ClassRoom();
		room.student.start();
		room.teacher.start();
		room.student1.start();
	}
}


class ClassRoom implements Runnable {
	Thread student,teacher,student1;
	public ClassRoom() {
		teacher = new Thread(this);
		student = new Thread(this);
		student1 = new Thread(this);
		teacher.setName("王教授");
		student.setName("张三");
		student1.setName("李四");
	}
	@Override
	public void run() {
		if(Thread.currentThread()==student){
			try {
				System.out.println(student.getName()+"正在睡觉,不听课");
				Thread.sleep(1000*60*60);
			} catch (InterruptedException e) {
				System.out.println(student.getName()+"被"+student1.getName()+"叫醒了");
			}
			System.out.println(student.getName()+"开始听课");
		}
		else if(Thread.currentThread()==student1){
			try {
				System.out.println(student1.getName()+"正在睡觉,不听课");
				Thread.sleep(1000*60*10);
			} catch (InterruptedException e) {
				System.out.println(student1.getName()+"被老师叫醒了");
			}
			student.interrupt();
			System.out.println(student1.getName()+"开始听课");
		}
		else if(Thread.currentThread()==teacher){
			for(int i=1;i<=3;i++){
				System.out.println("上课!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
	
				}
			}
			student1.interrupt();
		}
	}
	
}