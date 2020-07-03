import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 9001);
        System.out.println("Client is connected");

        // This is used to read the messages sent by server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // This is used to write the messages to server
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String msg = null;
        Scanner scn = new Scanner(System.in);

        do{
            System.out.println("Write a msg to server");
            msg = scn.nextLine();
            out.println(msg);

            String resp = in.readLine();
            System.out.println("Server response : " + resp);

        }while(!msg.equals("exit"));
    }
}
