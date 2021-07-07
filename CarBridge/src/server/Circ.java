package server;


public class Circ {
    public static void main(String arg[]){

        Bridge b = new Bridge(5);
        (new Server(b)).start();
        for(int i = 1; ; i++){
            (new Vehicle(null,Math.random()>0.5?true:false, b,null)).start();
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
            if((i%10)==0)
                try{
                    Thread.sleep(15000);
                }catch (InterruptedException e){}
        }
    }
}