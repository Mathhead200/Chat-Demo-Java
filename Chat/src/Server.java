import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket(9999);
		
		System.out.println("Waiting for connection...");
		Socket socket = server.accept();
		
		System.out.println("Conection Established.");
		PrintWriter clientOut = new PrintWriter( socket.getOutputStream(), true );
		BufferedReader clientIn = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
		
		Scanner stdIn = new Scanner(System.in);
		String response;
		do {
			System.out.println("Waiting for a message from the client...");
			System.out.println( "CLIENT: " + clientIn.readLine() );
		
			System.out.print("RESPONSE: ");
			response = stdIn.nextLine();
			clientOut.println(response);
		} while( response.length() != 0 );
		
		// clean up
		clientOut.close();
		clientIn.close();
		socket.close();
	}

}
