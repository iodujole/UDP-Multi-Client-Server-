import java.io.*;
import java.net.*;

// Server Class 
public class Server {
	public static void main(String args[]) throws Exception {
        int total = 0;
        
    try {

        System.out.println("The UDP Server is on.");
        
        // Host Port Number
		DatagramSocket serverSocket = new DatagramSocket(6789);
		
        while (true) {
        
        // Bytes 
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];

		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		serverSocket.receive(receivePacket);
            

			String sentence = new String(receivePacket.getData());

			InetAddress IPAddress = receivePacket.getAddress();

			int port = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
           
            total++;

            // Server Output
            System.out.println("The message is: "+ sentence);
            System.out.println("Your IP Address is: " + InetAddress.getLocalHost());
            System.out.println("Your Port Number is: " + port);
            System.out.println("");
			
            
		}
	}

    catch (Exception e)
    {
        System.out.println("Sever is not available");
    }
}
}


