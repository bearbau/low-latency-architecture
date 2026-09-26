package tcpServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// object initialization; with serverSocket for port access
		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		OutputStreamWriter outputStreamWriter = null;
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(1234);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				// Waits for a connection from the same port
				socket = serverSocket.accept();
				
				// Reading from the client
				inputStreamReader = new InputStreamReader(socket.getInputStream());
				outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
				
				// Buffers
				bufferedReader = new BufferedReader(inputStreamReader);
				bufferedWriter = new BufferedWriter(outputStreamWriter);
				
				while(true) {
					String clientMsg = bufferedReader.readLine();
					
					System.out.println("Client: " + clientMsg);
					bufferedWriter.write("Received");
					bufferedWriter.newLine();
					bufferedWriter.flush();
					
					if (clientMsg.equalsIgnoreCase("end"))
						break;
				}
				
				socket.close();
				inputStreamReader.close();
				outputStreamWriter.close();
				bufferedReader.close();
				bufferedWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
