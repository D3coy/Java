import java.net.ServerSocket;
import java.net.Socket;

import javax.management.RuntimeErrorException;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Server 
{
	public static void main(String[] args){
		int port = 8000;
		
		// Main socket for associate service with port 
		//ServerSocket server = new ServerSocket(port);
		try (ServerSocket server = new ServerSocket(port)){
			System.out.println("Server started!");
			
			Socket sock = server.accept();	//waiting for client connecting. if client connected program create a handler for further interactions
			System.out.println("Client connected!");
			
			// getInputStream - receive data stream from client, getOutputStream - save stream, for send out to the client 
			OutputStream stream = sock.getOutputStream();
			
			// Remade byte-by-byte writer to string writer(code each symbol of string to byte by encoding) to the client
			OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
			
			// Write string with newline feature. 
			// Exactly difference between BufferedWriter and OutputStream is that in BufferedWriter symbols
			// cached in memory, and Java aint need to call converter for each symbol just like in OutputStreamWriter 
			BufferedWriter writer = new BufferedWriter(streamWriter);
			writer.write("HELLO FROM SERVER");
			writer.newLine();
			
			// command for sending directly..
			writer.flush();
			
			// closing sockets
			writer.close();
			sock.close();
		}
		catch (IOException e) {
			
			// use unchecked exception for not to work on it.
			throw new RuntimeException(e);
		}
	}
}