package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class RemVehicleClient {
    private static final int PORT = 8080;
    private static String name;
    public static void main(String[] args)throws IOException {
        String server = null;       //mqsto za vuvejdane ili ip ili null za kum local   "192.168.42.31"
        InetAddress addr =  InetAddress.getByName(server);
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, PORT);
        //Socket s=new Socket(); //s.connect(new  InetSocketAddress(host,port),timeout); //udobno za bavna mreja
        // Guard everything in a try-finally to make        
        // sure that the socket is closed:
        try {
            System.out.println("socket = " + socket);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            BufferedReader sin =  new BufferedReader(
                    new InputStreamReader(System.in));

            // Output is automatically flushed
            // by PrintWriter:
            PrintWriter out =   new PrintWriter(
                    new BufferedWriter(  new OutputStreamWriter(
                            socket.getOutputStream())),true);
            System.out.print("Your name please:");
            name = sin.readLine();
            out.println(name);
            for(;;) {
                System.out.print("input L(left->right) or R(right->left) [empty for finish] :");
                String s = sin.readLine();
                if(s.length()==0) break;
                if(!(s.equalsIgnoreCase("L"))&&!(s.equalsIgnoreCase("R"))) {
                    System.out.println("L or R or 'Enter' please");
                    continue;
                }

                out.println(s.equalsIgnoreCase("L")?"Left":"Right");
                System.out.println(in.readLine());    // wait to take the bridge
                System.out.println(in.readLine());    // wait to leave the bridge
            }
            out.println("END");
        }
        finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}