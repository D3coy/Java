
class Dog {
	int size;
	String breed;
	String name;
	
	void bark() {
		System.out.print("Bark! Barrrrk!");
	}
}

public class Dog_obj {

	public static void main(String[] args) 
	{
		Dog d = new Dog();
		d.size = 40;
		d.bark();
	}

}
