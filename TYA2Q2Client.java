import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TYA2Q2Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            dout.writeInt(num);

            String result = din.readUTF();
            System.out.println("Server says: " + result);

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
