package nettest.udptest;

import java.io.IOException;
import java.net.*;

public class Send {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        byte[] bytes="我叫宋子明".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 8888);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
