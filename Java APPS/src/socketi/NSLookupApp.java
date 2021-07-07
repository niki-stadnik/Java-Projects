package socketi;


import java.net.*;

public class NSLookupApp {
    public static void main(String args[]) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java NSLookupApp hostName");
                return;
            }
            InetAddress host[] = InetAddress.getAllByName(args[0]);
            for(int i=0;i<host.length;i++){
                String hostName = host[i].getHostName();
                System.out.println("Host name: " + hostName);
                System.out.println("IP address: " + host[i].getHostAddress());
            }
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host");
            return;
        }
    }
}

// za da raboti ot run config trqbva da se zadade adres v program arguments