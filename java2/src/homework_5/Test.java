package homework_5;

/**
 * 这是一个继承与多态的案例
 * 在书上第P135
 * @author lcj
 *
 */
public class Test {
	public static void main(String[] args) {
		MobileTelephone telephone = new MobileTelephone();
		SIM sim = new SIMOfChinaMobile();
		sim.setNumber("123456468");
		telephone.useSIM(sim);
		telephone.showMessage();
		sim = new SIMOfChinaUnicon();
		sim.setNumber("1234564685456456");
		telephone.useSIM(sim);
		telephone.showMessage();
		
	}
	
}
