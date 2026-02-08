import java.io.*;
import java.net.*;

public class TYA2Q5Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());

            String str = din.readUTF();
            System.out.print("Vowels in the string: ");

            for (int i = 0; i < str.length(); i++) {
                char ch = Character.toLowerCase(str.charAt(i));
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    System.out.print(ch + " ");
                }
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
