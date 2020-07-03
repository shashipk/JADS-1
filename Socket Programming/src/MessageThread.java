import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageThread extends Thread {


    private Socket clientSocket;

    public MessageThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // write the messaging code
        try {
            // This is used to read the messages sent by client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // This is used to write the messages to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            while (true) {
                String msg = in.readLine();
                out.println("Server acks this message : " + msg);

                System.out.println("Client request: " + msg + " is executing in thread : " + currentThread().getName());

                if (msg.equals("exit")) {
                    break;
                }
            }
        }catch (IOException e){
            try {
                clientSocket.close();
            }catch (IOException ee){
                System.out.println("connection is already closed");
                ee.printStackTrace();
            }
            System.out.println("connection timed out");
            e.printStackTrace();
        }

    }
}
