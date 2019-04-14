import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class crypt {
	
	public static int sz = 0;					//public variable to store a size of wrote characters
	
	public static void writing_file(String text) {
		try(FileWriter writer = new FileWriter("dummy.txt", true)){			//write method, false =rw
			writer.write(text);			//write obv
			writer.flush();				//clear buffer of the stream
			writer.close();
			
			sz += text.length();		//every iteration of write, sz will grow on count of wrote chars
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static void reading_file() {
		try(FileReader reader = new FileReader("dummy.txt")) {							//read to buffer 4om file
			char[] buff_read = new char[sz];											//alloc buffer depends on (How much wrote == Size of buffer for reading)
			int c;
			
			while ((c = reader.read(buff_read)) > 0) {
				buff_read = Arrays.copyOf(buff_read, c);								//copy to buffer every symbol to read it
			}
			
			System.out.println("Length of symbols in file: " + (int)buff_read.length);
			System.out.print("File contents: ");
			System.out.println(buff_read);
			reader.close();
		}
		catch(IOException ex){
            
            System.out.println(ex.getMessage());
        }
	}
	
	public static void crypt3r(String text) {
		char[] ch_text = text.toCharArray();							//remake string -> char array
				//System.out.println(text.length());						// _DBG_ size of string entered..
		int[] buff_bin = new int[text.length()];						//memory allocation for VAR depending on the size of entered text
		char[] buff_char = new char[text.length()];						//alloc var depends, stores char symbols
		
		for (int i = 0; i < text.length(); i++) {						//binary operation [every entered char -> XOR 10]
			//System.out.println(smasstext[i]);
			buff_bin[i] += ch_text[i] ^ 10;
		}
		
		for (int q = 0; q < text.length(); q++) {
				//System.out.println((char)buff[q]);		//_DBG_ printline the char repr of mass[int]
			buff_char[q] += (char)buff_bin[q];				//write to char buffer, XORed int array-> chars
		}
		
		String buff_str = String.valueOf(buff_char);		//Char arr -> string
		System.out.println("Crypt result: " + buff_str);		//_DBG_
		writing_file("\r\n");								//mustdie newline awereness
		writing_file(buff_str);
	}
	
	public static void main(String[] args) 
	{	
		File file = new File("dummy.txt");
        if(file.delete()) {
            System.out.println("File deleted, go baby!");
        } 
        else {
            System.out.println("Del error");
        }
		
		Scanner in = new Scanner(System.in);
        System.out.print("Enter symbols: ");
        String text = in.nextLine();
        in.close();
        
		writing_file(text);			//wrote stock input
		crypt3r(text);				//call crypter function
		reading_file();				//read to console _DBG_
	}
}
