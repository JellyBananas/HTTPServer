import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by jellyBananas on 2016/8/28.
 */
public class UDPReceive {
    public static void main(String[] args) {
        System.out.println("UDPReceive launching...");
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8889);
            byte[] bytes = new byte[124];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(datagramPacket);
            String information = new String(bytes,0,datagramPacket.getLength());//!!!
            String ip = datagramPacket.getAddress().getHostAddress();
            System.out.println("From IP: "+ip);
            System.out.println();
            System.out.println("Information: "+information);
            datagramSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
