package kLearn_consoleVer;

import java.util.Random;
import java.util.Scanner;

public class Primary 
{	
	public static void main(String[] args) 
	{
		Body bodyObj = new Body();
		bodyObj.startBody();
	}
}

class Body 
{
	String chars = "abcdefghijklmnopqrstuvwxyz";
	String letters = "1234567890";
	String keyboard = "1234567890qwertyuiopasdfghjklzxcvbnm";
	int count = 0;
	
	//Body(){
	//		
	//}
	
	public void drawPicture(char z) {
		char[] keyboard_symbols = new char[keyboard.length()];
		System.arraycopy(keyboard.toCharArray(), 0, keyboard_symbols, 0, keyboard.length());
		
		System.out.printf("%31s", "[___Keyboard layout___]");
		System.out.print("\n");
		System.out.printf("%40s", "---------------------------------------");
		System.out.print("\n");
		
		for (int i = 0; i < keyboard_symbols.length; i++) {
			// [0] key
			if (i == 9) {
				System.out.print(" [" + keyboard_symbols[i] + "]");
				System.out.print("\n");
			}
			// [Q] key new line
			else if (i == 10) {
				System.out.printf("%3s%s%s", "[", keyboard_symbols[i], "]");
			}
			// [P] key new line
			else if (i == 19) {
				System.out.print(" [" + keyboard_symbols[i] + "]");
				System.out.print("\n");
			}
			// [a] key
			else if (i == 20) {				
				System.out.printf("%4s%s%s", "[", keyboard_symbols[i], "]");
			}
			// [l] key new line
			else if (i == 28) {
				System.out.print(" [" + keyboard_symbols[i] + "]");
				System.out.print("\n");
			}
			// [z] key
			else if (i == 29) {
				System.out.printf("%5s%s%s", "[", keyboard_symbols[i], "]");
			}
			// [m] key new line
			else if (i == 35) {
				System.out.print(" [" + keyboard_symbols[i] + "]");
				System.out.print("\n");
				System.out.printf("%40s", "---------------------------------------");
			}
			// if next symbol = generated -> mark it !
			else if (keyboard_symbols[i] == z) {
				System.out.print(" <<[" + keyboard_symbols[i] + "]>>");
			}
			else
				System.out.print(" [" + keyboard_symbols[i] + "]");
		}
	}
	
	public void startBody() {
		
		// new array from chars and numbers
		char[] symbols = new char[chars.length() + letters.length()];

		// copy to new array [src, posStart_src, dest, destPos, src.length]
    	System.arraycopy(chars.toCharArray(), 0, symbols, 0, chars.length());
    	System.arraycopy(letters.toCharArray(), 0, symbols, chars.length(), letters.length());
		
    	// get random char from function
    	char symbol = symbols[getRandom(symbols)];
    	
    	// call drawing with generated symbol
    	drawPicture(symbol);
		
		System.out.println("\n Press the [" + symbol + "] button");
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		
		// Get char in console, read from userinput and if inputted == getRandom(char) callback in recursive
		while (flag) {
			System.out.print("Input: ");
			 
			// first from input
			String num = in.next();
			 
			// first element of string to char 
			char num_char = num.charAt(0);
			
			if (num_char == symbol) {
				count += 1;
				System.out.println("Correct answer!");
				System.out.print("\n");
				
				startBody();
			}
			else if (num_char == '`') {
				System.out.println("Game is over!");
				System.out.println("Your score is: [" + count + "]");
			}
			else {
				System.out.println("Incorrect, try again!");
				continue;
			}
		 }
	}
	
	public static int getRandom(char[] array) {
		
		// create int array with size of symbols array
		int[] numbers = new int[array.length];
		
		// next int variable read from the console generated from 0 to array.length
		int rnd = new Random().nextInt(array.length);
		
		return rnd;
	}
}