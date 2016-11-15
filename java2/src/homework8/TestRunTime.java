package homework8;
/**
 * 学习runtime类
 * @author lcj
 *
 */
public class TestRunTime {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		long free = runtime.freeMemory();
		System.out.println("空闲内存："+free);
		long total = runtime.totalMemory();
		System.out.println("占用内存："+total);
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
		System.out.println("循环时用了："+(n2-n1)/1000/1000+"毫秒");
		free = runtime.freeMemory();
		System.out.println("空闲内存："+free);
		total = runtime.totalMemory();
		System.out.println("占用内存："+total);
	}
}
