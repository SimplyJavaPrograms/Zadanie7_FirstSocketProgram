import Client.Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    private static int timeout = 2;
    private static final int MaxTimeout = 10;

    public static void main(String[] args) throws InterruptedException {
        String username = readUserName();

        while (timeout <= MaxTimeout){
            try {
                startClientService(username);
                break;
            } catch (Exception e) {
                System.out.println("Connection to server failed... I will try to connect again in  " + timeout + "seconds");
                Thread.sleep(timeout * 1000);
                timeout *= 2;
            }
        }
        System.out.println("the program has finished its work");

    }

    public static String readUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        return username;
    }

    private static void startClientService(String username) throws IOException {
        Socket socket = new Socket("localhost", 2001);
        Client client = new Client(socket, username);

        client.listenForMessage();
        client.sendMessage();
    }
}
