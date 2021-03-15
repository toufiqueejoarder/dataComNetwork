package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client1 {
	public static Socket socket = null;
	public static void main(String[] args) 
	{
		String response;
		try 
		{
			socket = new Socket("localhost", 8081);
			System.out.println("Connected to Server\n" + "Socket: " + socket.getInetAddress() + ":" + socket.getPort() + "\n" );
		} 
		catch (IOException e) 
			{
				System.out.print("Connection to network can not be established");
			}
		
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner consoleInput = new Scanner(System.in);
		try 
		{
			in = new BufferedReader( new InputStreamReader(socket.getInputStream() ));
			out = new PrintWriter(socket.getOutputStream(), true);
			//start0
			System.out.println("Rules: " + in.readLine());
			System.out.print("Choose any: ");
			out.println(consoleInput.nextLine());
			
			// Catch responses
			response = in.readLine();

			// Display responses
			System.out.print("Winner " + response);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


