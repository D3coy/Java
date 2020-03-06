// класс клиента - потребителя объектов

public class Program 
{
	public static void main(String[] args) {
		//		Developer dev = new JavaDeveloper();
		//		
		//		dev.writeCode();
		//		
		//		dev = new CppDeveloper();
		//		dev.writeCode();
		
		DeveloperFactory devFactory = new JavaDeveloperFactory();
		Developer developer = devFactory.createDeveloper();
		
		developer.writeCode();
	}
}
