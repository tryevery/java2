package com.test12;


/**
 * currentThread �� interrupt() ������ȡ��ǰ����ʹ����Դ���߳��Լ��������ߵ��߳�
 * ������һ�������̵߳�С����
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
		teacher.setName("������");
		student.setName("����");
	}
	@Override
	public void run() {
		if(Thread.currentThread()==student){
			try {
				System.out.println(student.getName()+"����˯��,������");
				Thread.sleep(1000*60*60);
			} catch (InterruptedException e) {
				System.out.println(student.getName()+"����ʦ������");
			}
			System.out.println(student.getName()+"��ʼ����");
		}
		else if(Thread.currentThread()==teacher){
			for(int i=1;i<=3;i++){
				System.out.println("�Ͽ�!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
	
				}
			}
			
			student.interrupt();
		}
	}
	
}