class DVDPlayer
{
	boolean canRecord = false;
	
	void playDVD() {
		System.out.println("DVD ���� �������������");
	}
	
	void recordDVD() {
		System.out.println("���� ������ �� DVD");
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
