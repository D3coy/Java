class TapeDeck {
	boolean canRecord = false;
	
	void playTape() {
		System.out.println("пленка проигрывается");
	}
	
	void recordTape() {
		System.out.println("идет запись на пленку");
	}
}


public class TapeDeckTestDrive_2 {

	public static void main(String[] args) 
	{
		//here was an error <no object mate>
		TapeDeck t = new TapeDeck();
		
		t.canRecord = true;
		t.playTape();
		
		if (t.canRecord == true) {
			t.recordTape();
		}
	}

}
