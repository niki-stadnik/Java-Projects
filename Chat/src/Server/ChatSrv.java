package Server;

import java.io.*;
import java.net.*;
import java.util.*;

class Clients{
    private ArrayList<PrintWriter>  pW;
    public Clients(){
        pW = new ArrayList<PrintWriter>(10);
    }
    public synchronized void addC(PrintWriter p){
        pW.add(p);
    }
    public synchronized void rmvC(PrintWriter p){
        pW.remove(p);
    }
    public synchronized void sendC(String s){
        Iterator<PrintWriter> itr = pW.iterator();
        while(itr.hasNext()) {
            PrintWriter p=(PrintWriter)itr.next();
            p.println(s);
        }
    }
    public synchronized int nCl(){
        return pW.size();
    }

}
//...............................................................
class ServeOneClient extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    Clients clt;
    public ServeOneClient(Socket s,Clients clt)  throws IOException {
        socket = s;
        this.clt =clt;
        in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
        // Enable auto-flush:
        out = new PrintWriter( new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()
                )
        ),
                true);
        // If any of the above calls throw an
        // exception, the caller is responsible for
        // closing the socket. Otherwise the thread
        // will close it.
        clt.addC(out);
        start();    // Calls run()
    }
    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("END")) break;
                System.out.println(str);
                clt.sendC(str);
            }

        } catch (IOException e) {  }
        finally {
            try {
                clt.rmvC(out);
                System.out.println("disconect a client. Total number "+clt.nCl());
                socket.close();
            } catch(IOException e) {}
        }
    }
}
//................................................................................
public class ChatSrv {
    static final int PORT = 9090;
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server Started");
        Clients clt = new Clients();
        try {
            while(true) {
                // Blocks until a connection occurs:
                Socket socket = s.accept();
                try {
                    new ServeOneClient(socket,clt);
                    System.out.println("join a new client - total number "+ clt.nCl());
                } catch(IOException e) {
                    // If it fails, close the socket,
                    // otherwise the thread will close it:
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}