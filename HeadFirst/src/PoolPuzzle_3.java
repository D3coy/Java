// class Triangle = PoolPuzzle_3
public class PoolPuzzle_3 
{
	double area;
	int height;
	int length;
	
	public static void main (String[] args) {
		
		int x = 0;
		PoolPuzzle_3[] ta = new PoolPuzzle_3[4];
		
		while(x < 4) {
			
			// Don't forget that here's link <-> object binding ---> ta[0] = new .., ta[1] = new ..
			// Plus in every link variable = object in array stores individual variables [area, height, length]
			ta[x] = new PoolPuzzle_3();
			
			ta[x].height = (x + 1) * 2;
			ta[x].length = x + 4;
			ta[x].setArea();
			System.out.print("triangle " + x + ", зона");
			System.out.println(" = " + ta[x].area);
			x = x + 1;
		}
		// x = 3 -> y
		int y = x;
		x = 27;
		
		PoolPuzzle_3 t5 = ta[2];
		ta[2].area = 343;		//t5.area = ta[2].area
		
		System.out.print("y = " + y);
		System.out.println(", зона t5 = " + t5.area);	//343
	}
	
	void setArea() {
		area = (height * length) / 2;
	}
}
