package com.test12;


/**
 * currentThread 和 interrupt() 用来获取当前正在使用资源的线程以及唤醒休眠的线程
 * 下面是一个唤醒线程的小案例
 * @author lcj
 *
 */
public class Example12_6 {
	public static void main(String[] args) {
		ClassRoom room = new ClassRoom();
		room.student.start();
		room.teacher.start();
	}
}


class ClassRoom implements Runnable {
	Thread student,teacher;
	public ClassRoom() {
		teacher = new Thread(this);
		student = new Thread(this);
		teacher.setName("王教授");
		student.setName("张三");
	}
	@Override
	public void run() {
		if(Thread.currentThread()==student){
			try {
				System.out.println(student.getName()+"正在睡觉,不听课");
				Thread.sleep(1000*60*60);
			} catch (InterruptedException e) {
				System.out.println(student.getName()+"被老师叫醒了");
			}
			System.out.println(student.getName()+"开始听课");
		}
		else if(Thread.currentThread()==teacher){
			for(int i=1;i<=3;i++){
				System.out.println("上课!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
	
				}
			}
			
			student.interrupt();
		}
	}
	
}