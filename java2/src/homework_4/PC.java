package homework_4;

public class PC {
	CPU cpu;
	HardDisk HD;
	public void setCPU(CPU c){
		this.cpu = c;
	}
	public void setHardDisk(HardDisk hd){
		this.HD = hd;
	}
	
	public void show(){
		System.out.println("CPU���ٶ���"+cpu.getSpeed());
		System.out.println("Ӳ�̵��ٶ���"+HD.getAmount());
	}
}
