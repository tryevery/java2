package homework_5;

public class MobileTelephone {
	SIM card;
	public void useSIM(SIM card){
		this.card = card;
	}
	
	public void showMessage(){
		System.out.println("使用的卡是："+card.giveCorpName());
		System.out.println("手机号码是："+card.giveNumber());
	}
}
