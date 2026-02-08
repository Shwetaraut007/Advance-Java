import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TYA2Q5Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String str = sc.nextLine();
            dout.writeUTF(str);

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
