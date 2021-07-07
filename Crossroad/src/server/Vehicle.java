package server;//for local in constructor's parameter:  name=out=null

import java.io.PrintWriter;

public class Vehicle extends Thread{
    private boolean lr;
    private Bridge b;
    private String name;
    private static int num;
    private PrintWriter out;
    Vehicle(String name,boolean lr, Bridge b, PrintWriter out){
        this.lr=lr;
        this.b = b;
        this.out=out;
        if(name==null)this.name = "V "+ ++num + (lr?" left->":" <-right");  //local vehicle
        else this.name = "\07\t\t"+name + (lr?" left->":" <-right"); //remote vehicle
        super.setName(this.name);
    }
    public void run(){
        try {
            sleep((int)(Math.random()*600));
        } catch (InterruptedException e){}
        b.takeB(lr);
        if (out!=null){         //remote
            out.println(name+ " take the bridge");
        }
        try {
            sleep(3000);
        } catch (InterruptedException e){}
        b.leaveB(lr);
        if(out!=null)out.println(name+" leave the bridge");          //remote
    }
}

//test