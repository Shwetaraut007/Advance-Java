import java.io.*;
import java.net.*;

public class TYA2Q6Client {
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
                if (msg.equalsIgnoreCase("bye")) break;

                String reply = in.readLine();
                System.out.println("Server: " + reply);
                if (reply.equalsIgnoreCase("bye")) break;
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
