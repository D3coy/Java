public class Dog_example_3 
{
	String name;
	
	public static void main (String[] args) {
		Dog_example_3 dog1 = new Dog_example_3();

		// Here name field of object token in method bark() <name= null>
		dog1.bark();
		
		dog1.name = "Bart";
		
		// Create array of link variables with type Dogs
		Dog_example_3[] myDogs = new Dog_example_3[3];
		
		myDogs[0] = new Dog_example_3();	// Associate every link variable with individual object of Dog_example_3 class
		myDogs[1] = new Dog_example_3();
		myDogs[2] = dog1;
		
		myDogs[0].name = "Homer";
		myDogs[1].name = "Freddy";
		
		//What's the name of the last dog???
		System.out.println("Name of the last Dog object is: " + myDogs[2].name);
		
		// For every element from array call method bark!
		int x = 0;
		while(x < myDogs.length) {
			myDogs[x].bark();
			x += 1;
		}
	}
	
	public void bark() {
		System.out.println(name + " - told Bark!");
	}
	public void eat() { }
	public void chaseCat() { }
}
