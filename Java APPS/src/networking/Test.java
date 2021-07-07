package networking;

import java.nio.charset.Charset;

public class Test{
    public static void main(String[] arg) {
        System.out.println("Local character encoding: "+Charset.defaultCharset().displayName());
    }
}
