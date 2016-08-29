import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by jellyBananas on 2016/8/28.
 */
public class UDPSend {
    public static void main(String[] args) {
        System.out.println("UDPSend launching...");
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            String string = "Hello UDP";
            DatagramPacket datagramPacket = new DatagramPacket(string.getBytes(),string.getBytes().length, InetAddress.getByName("127.0.0.1"),8889);
            datagramSocket.send(datagramPacket);
            System.out.println("Send over");
            datagramSocket.close();
        }catch (IOException e){

        }
    }
}
