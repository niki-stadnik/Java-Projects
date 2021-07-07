package Properties;


import java.util.Properties;
public class TestPr1 {
    public static void main(String[] arg){
        Properties props = System.getProperties();
        props.put("myInProperty","myInPropertyValue");
        System.out.println("before remove:");
        System.out.println ("myInProperty has value:" +props.getProperty("myInProperty"));
        System.out.println ("myOutProperty has value:"+props.getProperty("myOutProperty"));
        System.out.println("Total properties: " + props.size());
        props.remove("myInProperty");
        props.remove("myOutProperty");
        System.out.println("after remove:");
        System.out.println ("myInProperty has value:"+props.getProperty("myInProperty"));
        System.out.println ("myOutProperty has value:"+props.getProperty("myOutProperty"));
        System.out.println("Total properties: " + props.size());
    }
}
