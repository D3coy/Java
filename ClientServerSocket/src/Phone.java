import java.net.Socket;

import javax.management.RuntimeErrorException;

import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


// this class created for exchanging messages between cli-server
// p.s. we override closeable class with overriding close() method
public class Phone implements Closeable
{
	// Constant for constructor to set it further in constructor before obj will be created.
	private final Socket socket;
	private final BufferedReader reader;
	private final BufferedWriter writer;
	
	// constructor for client using.
	public Phone(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
			this.reader = createReader();
			this.writer = createWriter();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Overloaded constructor for server creating.
	public Phone(ServerSocket server) {
		try {
			this.socket = server.accept();
			this.reader = createReader();
			this.writer = createWriter();
		}
		catch (IOException e) {
			
			// need to manually throws ex. here 'cause
			// methods : createReader(), createWriter()
			throw new RuntimeException(e);
		}
	}
	
	// methods for twin type of essence
	public void writeLine(String message) {
		try {
			writer.write(message);
			writer.newLine();
			writer.flush();
		}
		catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	public String readLine() {
		try {
			return reader.readLine();
		}
		catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	// throws exception here, cause ex checks in constructors calling,
	// also getInput and getOutputStream function may cause an IO failed in transfer data
	private BufferedReader createReader() throws IOException{
		return new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	private BufferedWriter createWriter() throws IOException{
		return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}

	@Override
	public void close() throws IOException {
		
		reader.close();
		writer.close();
		socket.close();
	}
}
