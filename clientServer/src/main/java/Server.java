import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();

        System.out.println("client connected");

//        InputStreamReader in = new InputStreamReader(s.getInputStream());
        InputStreamReader in = new InputStreamReader(System.in); // to get input
        BufferedReader br = new BufferedReader(in);

        String str=br.readLine();
        System.out.println("client :"+str);

        //for to way communication
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("yes");
        pr.flush();
    }
}
