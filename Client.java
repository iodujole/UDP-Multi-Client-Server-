import java.io.*;
import java.net.*;

// Client Class
public class Client {
	public static void main(String args[]) throws Exception {
    try {
        
        // Establish Input
        DatagramSocket clientSocket = new DatagramSocket();

        while (true)
        {
        
        // Reading Input
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
		InetAddress IPAddress = InetAddress.getByName("localhost");
        
        // Byes
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
        // Enter Data
		System.out.println("The UDP client is on. Please enter your input:");
        
        // Input
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6789);
	    clientSocket.send(sendPacket);

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

		String total = new String(receivePacket.getData());

		// Client Ouput 
        System.out.println("Total Messages:" + total);
        System.out.print("");
        
        if (sentence.equals("exit"))
        {
        // Close the Socket
		clientSocket.close();
        }
        
	}
        }

        catch(Exception e)
        {
            System.out.print("Connect to the server" );
        }
}   

}
