import java.io.*;
import java.net.*;

public class TYA2Q6Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Server started...");
            Socket s = ss.accept();
            System.out.println("Client connected.");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String msg;
            while (true) {
                msg = in.readLine();
                System.out.println("Client: " + msg);
                if (msg.equalsIgnoreCase("bye")) break;

                System.out.print("Server: ");
                String reply = br.readLine();
                out.println(reply);
                if (reply.equalsIgnoreCase("bye")) break;
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}