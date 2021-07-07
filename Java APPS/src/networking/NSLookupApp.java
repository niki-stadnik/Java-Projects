package networking;

import java.net.*;

public class NSLookupApp {
    public static void main(String args[]) {
        try {
            if (args.length != 1) {
                System.out.println("Usage: java NSLookupApp hostName");
                return;
            }
            InetAddress host[] = InetAddress.getAllByName(args[0]);
            for (InetAddress hst : host) {
                String hostName = hst.getHostName();
                System.out.println("Host name: " + hostName);
                System.out.println("IP address: " + hst.getHostAddress());
            }
        } catch (UnknownHostException ex) {
            System.out.println("Unknown host");
            return;
        }
    }
}
