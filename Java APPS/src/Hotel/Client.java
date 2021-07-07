package Hotel;

public class Client extends Thread{
    String  name;
    static int n=0;
    Sauna c;
    public int gender;
    public String genderText;
    Client(Sauna c){
        if(Math.random()<0.5){
            gender=0;
            genderText="Male";
        }
        else{
            gender=1;
            genderText="Female";
        }
        name = "Client "+ ++n + genderText;
        this.c=c;
        try {
            System.out.println(" creating new client:"+name);
            sleep((int)(Math.random()*50));
        } catch (InterruptedException e){}
        super.setName(name);
    }
    public void run(){
        double vreme=0;
        try {
            System.out.println(this+" otiva na sauna");
            sleep((int)(Math.random()*50));
        } catch (InterruptedException e){}
        try {
            System.out.println(this+" otiva v syblekalnqta");
            sleep((int)(vreme=Math.random()*100));
        } catch (InterruptedException e){}
        System.out.println(this+" opitva da vleze v saunata");
        c.takeSauna(gender);
        try {
            System.out.println(this+" v saunata");
            sleep((int)(vreme*5));
        } catch (InterruptedException e){}
        System.out.println(this+" release Sauna");
        c.releaseSauna();
        try {
            System.out.println(this+" v syblekalnqta");
            sleep((int)(vreme*2));
        } catch (InterruptedException e){}
        System.out.println(this+" izliza ot syblekalnqta");
    }
    public String toString(){
        return name;
    }
}
