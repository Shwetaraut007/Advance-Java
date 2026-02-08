import java.net.InetAddress;

public class TYA2Q1 {
    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("IP Address of this machine: " + ip.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
