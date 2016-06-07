import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9876);
			
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			output.writeBytes("Mike Tsui");
			String reply = input.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
