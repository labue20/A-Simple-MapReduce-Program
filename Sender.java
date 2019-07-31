package mapReduceProgram;

import java.util.*;
import java.io.*;
import java.net.*;

public class Sender 
{
	private Socket socket = null;
	private DataOutputStream out = null;
	
	//constructor
	public Sender(String address, int port, String text) throws IOException 
	{
			try
			{
				socket = new Socket(address, port);
				out = new DataOutputStream(socket.getOutputStream());
				
			}
			catch(UnknownHostException u)
			{
				System.out.println(u);
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
			
			String line = text;
			out.writeUTF(line);
			
			try
			{
				out.close();
				socket.close();
			}
			catch(IOException i)
			{
				System.out.println(i);
			}
		}
		
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		
		Reader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		String text = br.readLine();
		
		Sender sender = new Sender("127.0.0.1", 5000, text);
	}
}