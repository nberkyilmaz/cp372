import java.io.*;
import java.net.*;

public final class client{
    public static void main(String argv[]) throws Exception {
        Socket s = new Socket("localhost", 4554);
        //s.close();
    }
    
}