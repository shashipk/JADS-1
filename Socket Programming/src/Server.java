import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try{
            ServerSocket socket = new ServerSocket(6001);
            System.out.println("Waiting for the client to connect");

            Socket clientSocket = socket.accept();
            System.out.println("Connected to a client...");

            // This is used to read the messages sent by client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // This is used to write the messages to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while(true){
                String msg = in.readLine();
                out.println("Server acks this message : " + msg);

                System.out.println("Client request: " + msg);

                if(msg.equals("exit")){
                    break;
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
