package patterns_package;

public class Delegate_simple 
{
	public static void main(String[] args) {
		Delegate_simple test = new Delegate_simple();
		Delegate_simple.B b1 = test.new B();
		
		b1.f();
	}
	
	class A 
	{
		void f() {
			System.out.println("Function f prints text");
		}
	}
	
	class B
	{
		void f() {
			A a = new A();
			a.f();
		}
	}
}