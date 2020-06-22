import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {

    public static void main(String[] args) {
        Socket clientSocket = null;
        try{
            ServerSocket socket = new ServerSocket(9001);
            System.out.println("Waiting for client connection");
            while(true) {
                clientSocket = socket.accept();
                try {
                    clientSocket.setSoTimeout(1000 * 5);
                }catch (IOException e){
                    System.out.println("Connection is closed");
                }

                MessageThread thread = new MessageThread(clientSocket);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
