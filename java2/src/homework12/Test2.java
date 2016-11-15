package homework12;


/**
 * currentThread �� interrupt() ������ȡ��ǰ����ʹ����Դ���߳��Լ��������ߵ��߳�
 * ������һ�������̵߳�С����
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
		teacher.setName("������");
		student.setName("����");
		student1.setName("����");
	}
	@Override
	public void run() {
		if(Thread.currentThread()==student){
			try {
				System.out.println(student.getName()+"����˯��,������");
				Thread.sleep(1000*60*60);
			} catch (InterruptedException e) {
				System.out.println(student.getName()+"��"+student1.getName()+"������");
			}
			System.out.println(student.getName()+"��ʼ����");
		}
		else if(Thread.currentThread()==student1){
			try {
				System.out.println(student1.getName()+"����˯��,������");
				Thread.sleep(1000*60*10);
			} catch (InterruptedException e) {
				System.out.println(student1.getName()+"����ʦ������");
			}
			student.interrupt();
			System.out.println(student1.getName()+"��ʼ����");
		}
		else if(Thread.currentThread()==teacher){
			for(int i=1;i<=3;i++){
				System.out.println("�Ͽ�!");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
	
				}
			}
			student1.interrupt();
		}
	}
	
}