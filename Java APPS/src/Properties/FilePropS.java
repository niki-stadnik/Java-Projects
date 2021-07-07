package Properties;


import java.io.*;
import java.util.Properties;

public class FilePropS {
    public static void main(String[] args) {

        Properties prop = new Properties();
        OutputStream output = null;

        try {
            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty("server", "localhost");
            prop.setProperty("client", "127.0.0.1");
            prop.setProperty("password", "secret");

            // save properties to project root folder
            prop.store(output, "test property save");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
