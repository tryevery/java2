package homework8;
/**
 * ѧϰruntime��
 * @author lcj
 *
 */
public class TestRunTime {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		long free = runtime.freeMemory();
		System.out.println("�����ڴ棺"+free);
		long total = runtime.totalMemory();
		System.out.println("ռ���ڴ棺"+total);
		long n1 = System.currentTimeMillis();
		System.out.println(n1);
		for(int i=1;i<=100;i++){
			int j = 2;
			for(;j<=i/2;j++){
				if(i%j==0) break;
			}
			if(j>i/2) System.out.print(" "+i);
		}
		long n2 = System.currentTimeMillis();
		System.out.println("ѭ��ʱ���ˣ�"+(n2-n1)/1000/1000+"����");
		free = runtime.freeMemory();
		System.out.println("�����ڴ棺"+free);
		total = runtime.totalMemory();
		System.out.println("ռ���ڴ棺"+total);
	}
}
