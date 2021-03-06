package server;

import java.io.BufferedReader;
import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 
{
	private static ServerSocket server = null;
	private static Socket socket = null;
	private static final int port = 8081;
	public static void main(String[] args) 
	{
		String response;
		String inputPlayer_1;
		String inputComputer;
		
		//Generating random values
				Random rand = new Random();
				int upperbound = 3;
				int random = rand.nextInt(upperbound);
		
		//Create IO Objects
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner consoleInput = new Scanner(System.in);
		
		//Start Server
		try 
		{
			System.out.println("Server is starting ...");
			server = new ServerSocket(port);
			System.out.println("Server has started");
		} catch (IOException e) {
			System.out.println("Can not listen to port: " + port);
			System.exit(-1);
		}
		while(true) {
			
			//Create Socket
			try 
			{
				socket = server.accept();
			} 
			catch (IOException e) 
			{
				System.out.println("Communication Error with network");
				System.exit(-1);
			}
			try 
			{
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(),true);
				//start1
				out.println("Rock = 0, Paper = 1, scissor = 2");
				
				inputPlayer_1 = in.readLine();
				System.out.println("Player chose: " + inputPlayer_1);
				System.out.println("Computer chose: " + random);
				inputComputer=String.valueOf(random);
				
				
				
				if (inputPlayer_1.equals(inputComputer)) {
					System.out.print("It's a draw.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
				else if (inputPlayer_1.equals("0") && inputComputer.equals("2")) {
					System.out.print("Player wins.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
				else if (inputPlayer_1.equals("2") && inputComputer.equals("0")) {
					System.out.print("Computer wins.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
				else if (inputPlayer_1.equals("0") && inputComputer.equals("1")) {
					System.out.print("Computer wins.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
				else if (inputPlayer_1.equals("1") && inputComputer.equals("0")) {
					System.out.print("Player wins.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
				else if (inputPlayer_1.equals("2") && inputComputer.equals("1")) {
					System.out.print("Player wins.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
				else if (inputPlayer_1.equals("1") && inputComputer.equals("2")) {
					System.out.print("Computer wins.");
					// Catch responses
					response = in.readLine();

					// Display responses
					System.out.print("Winner " + response);
				}
				
			}
			catch (IOException e) 
			{
				System.out.print("Player Left");
				consoleInput.close();
			}
		}
	}
}
