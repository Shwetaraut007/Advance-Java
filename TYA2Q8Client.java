import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TYA2Q8Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            dout.writeInt(num);

            System.out.println("Factors received from server:");
            int factor;
            while ((factor = din.readInt()) != -1) {
                System.out.println(factor);
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
