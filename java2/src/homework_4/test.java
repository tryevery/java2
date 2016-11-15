package homework_4;

public class test {
	public static void main(String[] args) {
		CPU cpu = new CPU();
		HardDisk disk = new HardDisk();
		PC pc = new PC();
		cpu.setSpeed(200);
		disk.setAmount(1000);
		pc.setCPU(cpu);
		pc.setHardDisk(disk);
		pc.show();
	}
}
