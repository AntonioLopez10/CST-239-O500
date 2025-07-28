package admin;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class AdminClientApp {
    public static void main(String[] args) {
        String update = "U|Shield|Blocks damage|25.0|10";
        try (Socket socket = new Socket("localhost", 9090);
             OutputStream out = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(out, true)) {
            writer.println(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
