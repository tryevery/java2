package com.test6;

/**
 * 这是一个测试接口参数的一个例子
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
		System.out.println("中国人习惯问候语：你好，吃饭了吗？");
	}
	
}
class English implements SpeakHello{
	
	@Override
	public void speakHello() {
		System.out.println("英国人习惯问候语：你好，天气不错");
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
