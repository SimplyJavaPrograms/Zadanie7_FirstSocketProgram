import Server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2001);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
