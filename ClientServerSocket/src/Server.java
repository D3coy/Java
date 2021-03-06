import java.net.ServerSocket;
import java.io.IOException;

/*
import java.net.Socket;
import java.util.Random;
import javax.management.RuntimeErrorException;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

 */

public class Server
{
	public static void main(String[] args){
		int port = 8000;
		
		// Main socket for associate service with port 
		//ServerSocket server = new ServerSocket(port);
		
		// try - catch feature, 'cause ServerSocket class realize Closeable interface,
		// if exception raised - server will close em connection
		try (ServerSocket server = new ServerSocket(port)){
			System.out.println("Server started!");
			
			while (true) {
				// waiting for connections
				Phone phone = new Phone(server);
				//Socket sock = server.accept();	//waiting for client connecting. if client connected program create a handler for further interactions
				
				// getInputStream - receive data stream from client, getOutputStream - save stream, for send out to the client 
				//OutputStream streamW = sock.getOutputStream();
				
				// Remade byte-by-byte writer to string writer(code each symbol of string to byte by encoding) to the client
				//OutputStreamWriter streamWriter = new OutputStreamWriter(streamW);
				
				// Write string with newline feature. 
				// Exactly difference between BufferedWriter and OutputStream is that in BufferedWriter symbols
				// cached in memory, and Java aint need to call converter(char-byte) for each symbol just like in OutputStreamWriter 
				//BufferedWriter writer = new BufferedWriter(streamWriter);
				
				
//					InputStream streamR = sock.getInputStream();
//					InputStreamReader streamReader = new InputStreamReader(streamR);
//					BufferedReader reader = new BufferedReader(streamReader);
				
				//BufferedReader reader = 
					//	new BufferedReader(
						//		new  InputStreamReader(
							//			sock.getInputStream()))
				
				new Thread(() -> {
					System.out.println("Client connected");
					
					//String request = reader.readLine();
					String request = phone.readLine();
					System.out.println("Request: " + request);	// read bytes from client
					
					String response = (int)(Math.random() * 30 - 10) + "";
					
					//allocated time for client request handling
					try {Thread.sleep(4000);} catch (InterruptedException e) {}
					phone.writeLine(response);
					
					System.out.println("Response: " + response);	// received from client
					
					try {phone.close();} catch(IOException e){}
				}).start();

				//writer.write(response);
				//writer.newLine();
				
				// command for sending message directly..
				//writer.flush();
			  }
			}
		 
		catch (IOException e) {
			
			// use unchecked exception for not to work on it.
			throw new RuntimeException(e);
		}
	}
}