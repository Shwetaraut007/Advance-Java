import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TYA2Q4Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            dout.writeUTF(name);

            String greeting = din.readUTF();
            System.out.println(greeting);

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
