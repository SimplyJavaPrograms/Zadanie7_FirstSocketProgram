import Server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class MainServer {
    public static int port = 2001;
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);
        Server server = new Server(serverSocket);
        System.out.println("Server is listening at port: "+port);
        server.startServer();

    }
}
