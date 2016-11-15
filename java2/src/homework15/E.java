package homework15;

import java.util.LinkedList;

public class E {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=1;i<=10;i++){
			list.add(new Integer(i));
		}
		list.remove(5);
		list.remove(5);
		Integer m = list.get(5);
		System.out.println(m.intValue());
	}
}
