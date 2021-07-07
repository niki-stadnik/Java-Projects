package networking;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;

class ReadURL {
    public static void main(String[] a) {
        try {
            URL url = new URL("https://nbu.bg");
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(url.openStream(), Charset.forName("UTF-8"))); //частта след запетаята се добавя ако ни е нужно да прочетем с конкретен енкодинг.
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
    }
}
