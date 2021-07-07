package server;

public class Bridge {
    private int nVh, countSeq, maxCount;   //edinstveniq na4in trqbva da e prez metod za da ne pipat kadeto ne trqbva ni6kite
    private boolean open;
    Bridge(int maxCount){     //construktor
        nVh = countSeq=0;
        open = true;
        this.maxCount=maxCount;
    }
    synchronized public int brN(){      //kolko sa kolite na mosta
        return nVh;
    }
    synchronized public void takeB(boolean lr ){        //ka4vam se na mosta
        while((nVh>0)&& (lr==true)||
                (nVh<0) && (lr==false)|| !open){
            System.out.println("\t"+Thread.currentThread().getName()+" waiting");

            //probvam da vikam 4erti4kata
            new Draw().newBall();
            //

            try{     wait();   }
            catch(InterruptedException e){
                System.err.println(e);
            }
        }
        countSeq++;
        if (lr) nVh--;
        else nVh++;
        System.out.println(Thread.currentThread().getName()+" on the bridge in the same direction: "+countSeq);
        if (countSeq==maxCount){open = false; System.out.println("The bridge is closed");}
    }
    synchronized public void leaveB(boolean lr ){       //slizane ot mosta
        if (nVh>0) nVh--;
        else nVh++;
        System.out.println("\t\t"+Thread.currentThread().getName()+" leave the bridge");
        if(nVh==0){countSeq=0;open = true; System.out.println("The bridge is open");}
        notifyAll();
    }
}