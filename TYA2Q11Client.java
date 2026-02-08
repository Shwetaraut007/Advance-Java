import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TYA2Q11Client {
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
                FileOutputStream fos = new FileOutputStream("received_" + fname);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = din.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                fos.close();
                System.out.println("File received successfully.");
            }

            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
