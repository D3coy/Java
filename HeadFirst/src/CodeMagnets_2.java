class DrumKit
{
	boolean topHat = true;
	boolean snare = true;
	
	void playSnare() {
		System.out.println("��� ��� ��-���");
	}
	
	void playTopHat() {
		System.out.println("���� ���� ��-����");
	}
}


public class CodeMagnets_2 {

	public static void main(String[] args) 
	{
		DrumKit d = new DrumKit();
		d.playSnare();
		d.snare = false;
		d.playTopHat();
		
		if (d.snare == true) {
			d.playSnare();
		}
	}

}
