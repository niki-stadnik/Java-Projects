package sockettest;

import java.io.*;
import java.net.*;

public class test {
    static Socket s;
    static PrintWriter pw;

    public static void main(String[] args) {
        try{
            s = new Socket("raspberrypi", 8000);
            pw = new PrintWriter(s.getOutputStream());
            pw.write("hello");
            pw.flush();
            pw.close();
            s.close();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}