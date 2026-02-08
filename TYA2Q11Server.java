import java.io.*;
import java.net.*;

public class TYA2Q11Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("File Server started...");

            while (true) {
                Socket s = ss.accept();
                new FileHandler(s).start();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class FileHandler extends Thread {
    Socket s;

    FileHandler(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            String fname = din.readUTF();
            File file = new File(fname);

            if (file.exists()) {
                dout.writeUTF("File Found");
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    dout.write(buffer, 0, bytesRead);
                }
                fis.close();
            } else {
                dout.writeUTF("File Not Found");
            }

            s.close();
        } catch (Exception e) {}
    }
}
