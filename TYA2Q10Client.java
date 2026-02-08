import java.io.*;
import java.net.*;

public class TYA2Q10Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String msg;
            while (true) {
                System.out.print("Client: ");
                msg = br.readLine();
                out.println(msg);

                String reply = in.readLine();
                System.out.println("Server: " + reply);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
