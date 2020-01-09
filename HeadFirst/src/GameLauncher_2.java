class GuessGame{
	Player p1;	//���������� �� ������ ������ Player
	Player p2;
	Player p3;
	
	public void startGame() {
		p1 = new Player();	//������� ���� Player
		p2 = new Player();
		p3 = new Player();
		
		int guessp1 = 0;	//�������� ��������� �������������� ��������
		int guessp2 = 0;
		int guessp3 = 0;
		
		boolean p1_isRight = false;		//���������� ��� �������� ������������ ������� �� �������
		boolean p2_isRight = false;
		boolean p3_isRight = false;
		
		int targetNumber = (int) (Math.random() * 10);		//��������� ����� 
		System.out.println("��������� ����� �� 0 �� 9");
		
		while (true) {
			System.out.println("�����, ������� ����� ������� - " + targetNumber);
			
			p1.guess();		//����� �������
			p2.guess();
			p3.guess();
			
			guessp1 = p1.number;
			System.out.println("������ ����� ������ ��� ���������� ����� ��������� - " + guessp1);
			guessp2 = p2.number;
			System.out.println("������ ����� ������ ��� ���������� ����� ��������� - " + guessp2);
			guessp3 = p3.number;
			System.out.println("������ ����� ������ ��� ���������� ����� ��������� - " + guessp3);
			
			if (guessp1 == targetNumber) {
				p1_isRight = true;
			}
			if (guessp2 == targetNumber) {
				p2_isRight = true;
			}
			if (guessp3 == targetNumber) {
				p3_isRight = true;
			}
			
			if (p1_isRight || p2_isRight || p3_isRight) {
				System.out.println("� ��� ���� ����������!");
				System.out.println("������ ����� ������? " + p1_isRight);
				System.out.println("������ ����� ������? " + p2_isRight);
				System.out.println("������ ����� ������? " + p3_isRight);
				System.out.println("����� ����.");
				break;
			}
			else
				System.out.println("��� ������ ���������, ���������� ��� ���!\n");
		}
	}
}

class Player {
	int number = 0;  //���������� �����
	
	public void guess() {
		number = (int) (Math.random() * 10);
		System.out.println("����� ��� ����� " + number);
	}
}

public class GameLauncher_2 
{
	public static void main(String[] args) 
	{
		GuessGame game = new GuessGame();
		game.startGame();
	}

}
