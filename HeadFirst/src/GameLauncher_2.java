class GuessGame{
	Player p1;	//экземпляры на основе класса Player
	Player p2;
	Player p3;
	
	public void startGame() {
		p1 = new Player();	//объекты типа Player
		p2 = new Player();
		p3 = new Player();
		
		int guessp1 = 0;	//хранение вариантов предположенных игроками
		int guessp2 = 0;
		int guessp3 = 0;
		
		boolean p1_isRight = false;		//переменные для хранения правильности ответов от игроков
		boolean p2_isRight = false;
		boolean p3_isRight = false;
		
		int targetNumber = (int) (Math.random() * 10);		//генерация числа 
		System.out.println("Загадываю число от 0 до 9");
		
		while (true) {
			System.out.println("Число, которое нужно угадать - " + targetNumber);
			
			p1.guess();		//опрос игроков
			p2.guess();
			p3.guess();
			
			guessp1 = p1.number;
			System.out.println("Первый игрок думает что загаданное число равняется - " + guessp1);
			guessp2 = p2.number;
			System.out.println("Второй игрок думает что загаданное число равняется - " + guessp2);
			guessp3 = p3.number;
			System.out.println("Третий игрок думает что загаданное число равняется - " + guessp3);
			
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
				System.out.println("У нас есть победитель!");
				System.out.println("Первый игрок угадал? " + p1_isRight);
				System.out.println("Второй игрок угадал? " + p2_isRight);
				System.out.println("Третий игрок угадал? " + p3_isRight);
				System.out.println("Конец игры.");
				break;
			}
			else
				System.out.println("Все игроки проиграли, попробуйте еще раз!\n");
		}
	}
}

class Player {
	int number = 0;  //загаданное число
	
	public void guess() {
		number = (int) (Math.random() * 10);
		System.out.println("Думаю это число " + number);
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
