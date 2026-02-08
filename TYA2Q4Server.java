import java.io.*;
import java.net.*;
import java.util.Date;

public class TYA2Q4Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String name = din.readUTF();
            Date d = new Date();
            int hour = d.getHours();
            String greet;

            if (hour < 12)
                greet = "Good Morning ";
            else if (hour < 17)
                greet = "Good Afternoon ";
            else
                greet = "Good Evening ";

            dout.writeUTF(greet + name);

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
