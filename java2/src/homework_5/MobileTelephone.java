package homework_5;

public class MobileTelephone {
	SIM card;
	public void useSIM(SIM card){
		this.card = card;
	}
	
	public void showMessage(){
		System.out.println("ʹ�õĿ��ǣ�"+card.giveCorpName());
		System.out.println("�ֻ������ǣ�"+card.giveNumber());
	}
}
