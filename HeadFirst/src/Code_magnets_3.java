public class Code_magnets_3 
{
	public static void main (String[] args) {
		String[] islands = new String[4];
		int[] index = new int[4];
		
		islands[0] = "Bermuds";
		islands[1] = "Fiji";
		islands[2] = "Azor islands";
		islands[3] = "Kosumel";
		
		index[0] = 1;
		index[1] = 3;
		index[2] = 0;
		index[3] = 2;
		
		int y = 0;
		int ref;
		while (y < 4) {
			ref = index[y];
			System.out.println(islands[ref]);
			y = y + 1;
		}
	}
}

/*
 [0]      [1]      [2]      [3]          <<----- [Y]
 
 [1]      [3]      [0]      [2]		  <<----- [INDEX]
 
 [1]      [3]      [0]      [2]		  <<----- [REF]
 
 [Fiji]   [Josumel]  [Bermuds]  [Azor islands]
*/