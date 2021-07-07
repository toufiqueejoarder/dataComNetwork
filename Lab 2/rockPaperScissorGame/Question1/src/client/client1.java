package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client1 {
	public static Socket socket = null;
	public static void main(String[] args) 
	{
		
		try 
		{
			socket = new Socket("localhost", 8082);
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
			System.out.println("Student list: " + in.readLine());
			System.out.print("Choose any: ");
			out.println(consoleInput.nextLine());
			System.out.println("Details: ");	
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


