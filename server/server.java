
import java.io.* ;
import java.net.* ;
import javax.swing.*;
import java.awt.*;

public final class server{
    public static void main(String argv[]) throws Exception {
        //initializing values
        int port = 0;
        int b_width = 0;
        int b_height = 0;
        String colour[] = new String[argv.length - 3];

        //taking input from client/ error handle

        if (argv.length < 4){
            System.out.println("input not valid");
            System.out.println("Enter inputs in form: ");
            System.out.println("java server <port #> <width> <height> <colour>");
        }else{
            port = Integer.valueOf(argv[0]);
            b_width = Integer.valueOf(argv[1]);
            b_height = Integer.valueOf(argv[2]);
            //adding colours to colour array
            for(int i = 3; i < argv.length; i++){
                colour[i - 3] = String.valueOf(argv[i]);
            }
            
        }

        

        ServerSocket ss = new ServerSocket(port);
        Socket s = ss.accept();

        InetAddress ip;
        ip = InetAddress.getLocalHost();

        //displaying what we know
        System.out.println("length: " + argv.length);
        System.out.println("Connected");
        System.out.println("port: "+ port);
        System.out.println("B_width: " + b_width);
        System.out.println("B_height: " + b_height);
        System.out.println("ip: " + ip);
        System.out.println("Colour(s): ");
        for (int i = 0; i<=argv.length-4; i++){
            System.out.print(colour[i] + ", ");
        } 

        //GUI
        JFrame frame = new JFrame("BBoard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(b_width,b_height);

        //JButton button1 = new JButton("POST");
        //JButton button2 = new JButton("GET");
        //frame.getContentPane().add(button1);
        //frame.getContentPane().add(button2);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter Text:");
        JTextField tf = new JTextField(20); // accepts upto 20 characters
        JButton get = new JButton("GET");
        JButton post = new JButton("POST");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(get);
        panel.add(post);
        JTextArea ta = new JTextArea();
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);
        
    }    
}
