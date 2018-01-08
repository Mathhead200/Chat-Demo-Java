import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Conneting...");
		Socket socket = new Socket("127.0.0.1", 9999);
		
		System.out.println("Conection Established.");
		PrintWriter serverOut = new PrintWriter( socket.getOutputStream(), true );
		BufferedReader serverIn = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
		
		Scanner stdIn = new Scanner(System.in);
		String message;
		do {
			System.out.print("MESSAGE: ");
			message = stdIn.nextLine();
			serverOut.println(message);

			
			System.out.println("Waiting for a response from the server...");
			System.out.println( "RESPONSE: " + serverIn.readLine() );
		} while( message.length() != 0 );
		
		// clean up
		serverOut.close();
		serverIn.close();
		socket.close();
	}

}
