import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by jellyBananas on 2016/8/27.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8889);
            if (socket == null){
                System.out.println("socket null, connect error!");
                System.exit(1);
            }
            else {
                System.out.println("connect success!");
            }
            BufferedReader sockIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sockOut = new PrintWriter(socket.getOutputStream());
            sockOut.println("this is client");
            sockOut.flush();
            String s = sockIn.readLine();
            System.out.println("Information from server: "+s);
            sockOut.close();
            sockIn.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("Error");
        }
    }
}
