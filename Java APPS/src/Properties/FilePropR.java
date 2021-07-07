package Properties;


import java.io.*;
import java.util.Properties;

public class FilePropR {
    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("config.properties");


            // load a properties file
            System.out.println("Total properties: " + prop.size());
            prop.load(input);

            // get a property value and print it out
            System.out.println(prop.getProperty("server")+"\n");

            // listing all properties
            System.out.println("Total properties: " + prop.size());
            prop.list(System.out);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
