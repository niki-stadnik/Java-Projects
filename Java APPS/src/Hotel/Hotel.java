package Hotel;

public class Hotel {
    public static void main(String[] args) {
        Sauna c=new Sauna(2);
        for(int i = 0; i<10;i++){
            (new Client(c)).start();
        }
    }
}
