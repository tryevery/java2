package homework_6;
interface Animal{
	void cry();
	String getAnimalName();
}

class Simulator{
	public void playSound(Animal animal){
		animal.cry();
		System.out.println("���������:"+animal.getAnimalName());
	}
}

class Dog implements Animal{

	@Override
	public void cry() {
		System.out.println("������");
	}

	@Override
	public String getAnimalName() {
		return "С��";
	}
	
}

class Cat implements Animal{

	@Override
	public void cry() {
		System.out.println("������");
	}

	@Override
	public String getAnimalName() {
		return "Сè";
	}
	
}
public class TestAnimal {
	public static void main(String[] args) {
		Simulator si = new Simulator();
		si.playSound(new Dog());
		si.playSound(new Cat());
	}
}
