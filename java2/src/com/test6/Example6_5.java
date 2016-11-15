package com.test6;

/**
 * ����һ�����Խӿڲ�����һ������
 * P154
 * @author lcj
 *
 */

interface SpeakHello{
	void speakHello();
}

class Chinese implements SpeakHello{

	@Override
	public void speakHello() {
		System.out.println("�й���ϰ���ʺ����ã��Է�����");
	}
	
}
class English implements SpeakHello{
	
	@Override
	public void speakHello() {
		System.out.println("Ӣ����ϰ���ʺ����ã���������");
	}
}
class KindHello{
	public void lookHello(SpeakHello speakHello){
		speakHello.speakHello();
	}
	
}

public class Example6_5 {
	public static void main(String[] args) {
		KindHello kind = new KindHello();
		kind.lookHello(new Chinese());
		kind.lookHello(new English());
		
	}
}
