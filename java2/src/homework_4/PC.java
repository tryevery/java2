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
		System.out.println("CPU的速度是"+cpu.getSpeed());
		System.out.println("硬盘的速度是"+HD.getAmount());
	}
}
