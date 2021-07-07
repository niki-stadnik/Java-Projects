package client;

import java.net.*;
import java.io.*;
import javax.swing.*;
import stud.*;

public class Client {
    BufferedReader in;
    PrintWriter out;
    ObjectOutputStream oStr;
    InetAddress addr;
    Socket socket;
    String name;
    Client(){
        try{
            String server = null;        //null ili ip       "192.168.42.41"
            InetAddress addr = InetAddress.getByName(server);
            System.out.println("addr = " + addr);
            socket = new Socket(addr, 9595);
            System.out.println("socket = " + socket);
            in =  new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),true);
            oStr = new ObjectOutputStream(socket.getOutputStream());

            
            // da si pra6ta imeto predi da zapo4va da vuvejda studenti

        }catch (Exception e){
            System.out.println("exception: "+e);
            System.out.println("closing...");
            try{
                socket.close();
            }catch (Exception e2){
                System.out.println("no server running");
                System.exit(5);
            }
        }

    }
    void send(Student s) throws IOException{
        oStr.writeObject(s);
    }
    public static void main(String[] args )throws IOException{
        Client cl= new Client();
        String name = JOptionPane.showInputDialog("Your name?");
        for(;;){
            if(JOptionPane.showConfirmDialog(null, "do you want to introduce a new student?")!=0)break;
            Student st = new Student();
            cl.send(st);
            JOptionPane.showMessageDialog(null,st+" is send");
        }
    }

}