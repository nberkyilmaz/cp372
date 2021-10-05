
import java.io.* ;
import java.net.* ;
import javax.swing.*;

public final class server{
    public static void main(String argv[]) throws Exception {
        int port = 0;
        int b_width = 0;
        int b_height = 0;
        String colour[] = new String[argv.length - 3];
        //taking inout from client
        if (argv.length < 4){
            System.out.println("input not valid");
            System.out.println("Enter inputs in form: ");
            System.out.println("java server <port #> <width> <height> <colour>");
        }else{
            port = Integer.valueOf(argv[0]);
            b_width = Integer.valueOf(argv[1]);
            b_height = Integer.valueOf(argv[2]);
            for(int i = 3; i < argv.length; i++){
                System.out.println("" + i);
                System.out.println(String.valueOf(argv[i]));
                colour[i - 3] = String.valueOf(argv[i]);
                //colour = String.valueOf(argv[3]);
            }
            
        }

        

        ServerSocket ss = new ServerSocket(port);
        Socket s = ss.accept();
        //int port;
        //port = Integer.valueOf(argv[0]);
        //port = 4554;
        System.out.println("length: " + argv.length);
        System.out.println("Connected");
        System.out.println("port: "+ port);
        System.out.println("B_width: " + b_width);
        System.out.println("B_height: " + b_height);
        System.out.println("Colour: " + colour);
        for (int i = 0; i<=argv.length-4; i++){
            System.out.print(colour[i]);
        } 

        JFrame frame = new JFrame("BBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(b_width,b_height);
        frame.setVisible(true);
        
    }    
}