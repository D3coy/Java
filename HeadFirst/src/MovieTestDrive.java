class Movie 
{
	String title;
	String genre;
	int rating;
	
	void playIt() {
		System.out.println("Playing the film - " + this.title);
	}
}

public class MovieTestDrive {

	public static void main(String[] args) 
	{
		Movie one = new Movie();
		one.title = "Home alone";
		one.genre = "Comedy";
		one.rating = 5;
		one.playIt();
	}

}
