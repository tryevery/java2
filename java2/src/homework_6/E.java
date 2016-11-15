package homework_6;

interface A{
	double f(double a,double b);
}
class B implements A{

	@Override
	public double f(double a, double b) {
		return a*b;
	}
	
	int g(int a,int b){
		return a+b;
	}
	
}
public class E {
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.f(3, 5));
		B b = (B) a;
		System.out.println(b.f(3, 5));
		System.out.println(b.g(3, 5));
	}
}
