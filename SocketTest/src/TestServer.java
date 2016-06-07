import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class TestServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9876);
			Socket socket = server.accept();
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			
			String inputText = input.readLine();
			System.out.print("Message: "+inputText);
			output.writeBytes("Hello, "+inputText);
			
			output.close();
			input.close();
			socket.close();
			server.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
