import java.io.*;
import java.net.*;

public class TYA2Q3Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            String msg = din.readUTF();
            System.out.println("Client says: " + msg);
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
