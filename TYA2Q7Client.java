import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TYA2Q7Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1234);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter filename: ");
            String fname = sc.nextLine();
            dout.writeUTF(fname);

            String response = din.readUTF();
            System.out.println(response);

            if (response.equals("File Found")) {
                String content;
                while (!(content = din.readUTF()).equals("EOF")) {
                    System.out.println(content);
                }
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
