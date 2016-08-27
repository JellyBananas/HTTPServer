import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jellyBananas on 2016/8/27.
 */
public class Server {
    public static void main(String[] args) {
        try {

            ServerSocket serverSocket = new ServerSocket(8889);
            Socket socket = new Socket();
//            BufferedReader sockIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter sockOut = new PrintWriter(socket.getOutputStream());
//            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Listening on port: "+serverSocket.getLocalPort());
            socket = serverSocket.accept();
            if (socket == null){
                System.out.println("socket null");
                System.exit(1);
            }
            else{
                System.out.println("accept connection from: "+socket.getInetAddress().getHostAddress());
            }
            BufferedReader sockIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sockOut = new PrintWriter(socket.getOutputStream());
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Listening on port: "+serverSocket.getLocalPort());
            sockOut.println("hello client");
            sockOut.flush();
            String s = sockIn.readLine();
            System.out.println("Information from client: "+s);
            sockOut.close();
            sockIn.close();
            socket.close();
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Error");
        }
    }
}
