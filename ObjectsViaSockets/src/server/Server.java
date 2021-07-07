package server;
import java.io.*;
import java.net.*;
import java.util.*;
import stud.*;

class Students{
    private ArrayList<Student>  st;
    public Students(){
        st = new ArrayList<Student>(10);
    }
    public synchronized void addS(Student p){
        st.add(p);
    }
    public synchronized void rmvS(Student p){
        st.remove(p);
    }
    public synchronized int nSt(){
        return st.size();
    }
    public synchronized void printSt(){
        Iterator<Student> itr = st.iterator();
        System.out.println("---------------------------");
        while(itr.hasNext()) {
            Student p=(Student)itr.next();
            System.out.println(""+p);
        }
        System.out.println(nSt() +" students total\n");
    }
}
//...............................................................
class ServeOneClient extends Thread {
    private static int number=0;
    private int num;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectInputStream iStr;
    private Students clt;
    public ServeOneClient(Socket s,Students clt)  throws IOException {
        num= ++number;
        System.out.println("join a new client - with number "+ num);
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
        iStr = new ObjectInputStream(socket.getInputStream());




        // If any of the above calls throw an
        // exception, the caller is responsible for
        // closing the socket. Otherwise the thread
        // will close it.

        start();    // Calls run()
    }
    public void run() {
        try {
            while (true) {
                System.out.println("waiting for new student from client "+num);
                Student s=null;
                try{
                    s = (Student)iStr.readObject();
                }
                catch(ClassNotFoundException exc){}
                if (s == null) break;
                System.out.println("receive student from client "+num+"\t"+s);
                clt.addS(s);
                clt.printSt();
            }

        } catch (IOException e) {  }
        finally {
            try {
                System.out.println("disconecting  client "+num);
                socket.close();
            } catch(IOException e) {}
        }
    }
}

//................................................................................
public class Server {
    static final int PORT = 9595;
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server Started");
        Students clt = new Students();
        try {
            while(true) {
                // Blocks until a connection occurs:
                Socket socket = s.accept();
                try {
                    new ServeOneClient(socket,clt);

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