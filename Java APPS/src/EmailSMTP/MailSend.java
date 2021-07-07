package EmailSMTP;


import java.net.*;
import java.io.*;

public class MailSend{
    private static String messageSys[]= new String[4],
            messageData[]=new String[5],hostName=null,
            sender = "<testnbu@gmail.com>";
    private static InetAddress mServer= null;
    public static void initStrings(){
        messageSys[0]="HELO "+hostName+"\r\n";
        messageSys[1]="MAIL FROM: "+sender+ "\r\n";
        messageSys[2]="RCPT TO: ";
        messageSys[3]="DATA\r\n";
        messageData[0]="From: "+sender+"\r\n";
        messageData[1]="To: ";
        messageData[2]="Subject: ";
        messageData[3]= "";
        messageData[4]=".\r\n";
    }
    public static void init(){
        try{
            mServer=InetAddress.getByName("mail.nbu.bg");
            hostName= InetAddress.getLocalHost().getHostName();
        }catch(Exception e){System.out.println("Exception"+e); }
        initStrings();
    }
    public static void putData(String arg[]){
        messageSys[2]+="<"+arg[0]+">\r\n";
        messageData[1]+=arg[0]+"\r\n";
        messageData[2]+= arg[1]+"\r\n";
        messageData[3]= arg[2]+"\r\n";

    }
    public static void send (){
        try{                                 // или c timeout 10000 ms:
            Socket s=null;		    // Socket s = new Socket();
            s = new Socket(mServer,25);  // s.connect(new InetSocketAddress(
            //    mserver,25),10000);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream());
            System.out.println(in.readLine());
            for(int i=0; i<messageSys.length;i++){
                out.print(messageSys[i]);
                System.out.println(messageSys[i]);
                out.flush();
                System.out.println(in.readLine());
            }
            for(int i=0;i<messageData.length;i++){
                out.print(messageData[i]);
                System.out.println(messageData[i]);
                out.flush();
            }
            System.out.println(in.readLine());
            s.close();
        }
        catch(Exception e) {System.out.println(e); }
        initStrings();
    }
}
