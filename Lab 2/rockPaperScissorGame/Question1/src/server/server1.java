package server;

import java.io.BufferedReader;
import java.util.Random;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server1 
{
	private static ServerSocket server = null;
	private static Socket socket = null;
	private static final int port = 8082;
	public static void main(String[] args) 
	{
		String input;
		
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
				out.println("Asad, Rishab, Batul");
				
				input = in.readLine();
								
				if (input.equals("Asad")||input.equals("asad")||input.equals("ASAD")) 
				{
					out.println("School: ACADEMIA\nClass: 7\nSection: Jupiter\nRoll no: 9\nAge: 15");
				}
				
				else if (input.equals("Rishab")||input.equals("rishab")||input.equals("RISHAB")) 
				{
					out.println("School: ACADEMIA\nClass: 6\nSection: Neptune\nRoll no: 2\nAge: 14");
				}
				
				else if (input.equals("Batul")||input.equals("batul")||input.equals("BATUL")) 
				{
					out.println("School: ACADEMIA\nClass: 8\nSection: Pluto\nRoll no: 11\nAge: 16");
				}
					
			}
			catch (IOException e) 
			{
				System.out.print("Client Left");
				consoleInput.close();
			}
		}
	}
}
