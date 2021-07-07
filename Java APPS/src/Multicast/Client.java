package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
    static int mcPort=9090;
    static String address="230.0.1.0";;

    public static void main(String[] args) throws     IOException {

        byte[] buffer=new byte[1024];
        MulticastSocket socket=new MulticastSocket(mcPort);
        InetAddress adr=InetAddress.getByName(address);
        socket.joinGroup(adr);
        DatagramPacket packet=new DatagramPacket(buffer,
                buffer.length);
        System.out.println("Waiting for multicast messages");
        while(true){
            socket.receive(packet);
            String msg=new String(packet.getData(),
                    packet.getOffset(),packet.getLength());
            System.out.println(msg);
            if("END_FILE".equals(msg)) {
                System.out.println("No more message. Exiting : ");
                break;
            }
        }
        socket.leaveGroup(adr);
        socket.close();
    }
}