package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    static int mcPort=9090;
    static String address= "230.0.1.0";
    static DatagramSocket socket;
    static InetAddress iAdr;

    public static void send(String message) throws IOException {
        byte[] msg = message.getBytes();
        DatagramPacket packet = new DatagramPacket(msg, msg.length,
                iAdr, mcPort);
        socket.send(packet);
    }

    public static void main(String[] args) throws IOException {
        socket = new DatagramSocket();
        iAdr = InetAddress.getByName(address);
        for(int i=0;i<20;i++) {
            send("This is a multicast message "+i);
        }
        send("END_FILE");
        socket.close();
    }
}