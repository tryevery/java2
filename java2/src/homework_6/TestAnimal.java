package homework_6;
interface Animal{
	void cry();
	String getAnimalName();
}

class Simulator{
	public void playSound(Animal animal){
		animal.cry();
		System.out.println("动物的名称:"+animal.getAnimalName());
	}
}

class Dog implements Animal{

	@Override
	public void cry() {
		System.out.println("汪汪汪");
	}

	@Override
	public String getAnimalName() {
		return "小狗";
	}
	
}

class Cat implements Animal{

	@Override
	public void cry() {
		System.out.println("喵喵喵");
	}

	@Override
	public String getAnimalName() {
		return "小猫";
	}
	
}
public class TestAnimal {
	public static void main(String[] args) {
		Simulator si = new Simulator();
		si.playSound(new Dog());
		si.playSound(new Cat());
	}
}
