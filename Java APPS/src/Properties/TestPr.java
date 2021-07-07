package Properties;


import java.util.Properties;
public class TestPr {
    public static void main(String[] arg){
        Properties props = System.getProperties();
        System.out.println("\n\t  The program Properties:\n");
        System.out.println("\n\t total properties found: "+props.size()+"\n\n");
        props.list(System.out);
    }
}
