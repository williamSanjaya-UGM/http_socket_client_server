import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",8080);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("is it working");
        pr.flush();

        // for two way communication
//        InputStreamReader in = new InputStreamReader(s.getInputStream());
        InputStreamReader in = new InputStreamReader(System.in); // to get input
        BufferedReader br = new BufferedReader(in);

        String str=br.readLine();
        System.out.println("server :"+str);
    }
}
