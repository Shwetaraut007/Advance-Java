import java.io.*;
import java.net.*;

public class TYA2Q7Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String fname = din.readUTF();
            File file = new File(fname);

            if (file.exists()) {
                dout.writeUTF("File Found");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    dout.writeUTF(line);
                }
                br.close();
                dout.writeUTF("EOF");
            } else {
                dout.writeUTF("File Not Found");
            }

            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
