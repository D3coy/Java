class DVDPlayer
{
	boolean canRecord = false;
	
	void playDVD() {
		System.out.println("DVD диск проигрывается");
	}
	
	void recordDVD() {
		System.out.println("идет запись на DVD");
	}
}


public class DVDPlayerTestDrive_2 {

	public static void main(String[] args) 
	{
		DVDPlayer d = new DVDPlayer();
		d.canRecord = true;
		d.playDVD();	//no method playDVD in the task, here's an error
		
		if (d.canRecord) {
			d.recordDVD();
		}
	}

}
