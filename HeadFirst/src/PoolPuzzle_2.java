
//название класса EchoTestDrive, назвал так из-за структуризации файлов
public class PoolPuzzle_2 
{
	// 1вариант == 10
//	public static void main(String[] args) {
//		Echo e1 = new Echo();
//		Echo e2 = new Echo();
//		int x = 0;
//		
//		while (x < 4) {
//			e1.hello();
//			e1.count = e1.count + 1;	 // [1, 2, 3, 4]
//			
//			if (x > 0) {
//				e2.count = e2.count + 1; //  [0, 1, 2->5, 6->10]
//			}
//			
//			//
//			if (x > 1) {
//				e2.count = e2.count + e1.count;
//			}
//			x = x + 1;	//0, 1, 2, 3
//		}
//		System.out.println(e2.count);	//10
//	}
	
	// 2вариант == 24
	public static void main(String[] args) {
		Echo e1 = new Echo();
		Echo e2 = e1;
		int x = 0;
		
		while (x < 4) {
			e1.hello();
			e1.count = e1.count + 1;	 // 0_1; 1_2+2; 2_5+5; 3_12+12  
			
			if (x == 3) {
				e2.count = e2.count + 1; // 1; 4; 10; 24
			}
			
			//
			if (x > 0) {
				e2.count = e2.count + e1.count;
			}
			x = x + 1;	//0, 1, 2, 3
		}
		System.out.println(e2.count);	//10
	}
}

class Echo 
{
	int count = 0;
	
	void hello() {
		System.out.println("привеееееет...");
	}
}
